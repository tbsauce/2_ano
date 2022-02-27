
	.eqv p_string, 4
	.eqv p_char, 11
	.eqv p_int10, 1
	.eqv size, 40
	.data
str1:	.asciiz "I serodatupmoC ed arutetiuqrA"
	.align 2
str2:	.space 41	 #(size+1)
	.align 2
par:	.asciiz "\n"
	.align 2
error:	.asciiz "String too long: "
	.text
	.globl main
	
main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)

	la $a0, str1
	jal strlen	#strlen(str1)
if:
	
	bgt $v0, size, else	#strlen(str1) <= STR_MAX_SIZE
	
	la $a0, str2
	la $a1, str1
	jal strcpy	#strcpy(str2, str1)
	
	move $a0, $v0
	li $v0, p_string
	syscall		#print_string(str2)
	
	la $a0, par
	li $v0, p_string
	syscall		#print_string("\n")
	
	la $a0, str2
	jal strrev	#strrev(str2)
	
	move $a0, $v0
	li $v0, p_string
	syscall		#print_string(strrev(str2))
	
	li $v0, 0	#exit_value = 0
	
	j end
	
else:
	
	la $a0, error
	li $v0, p_string
	syscall		#print_string("String too long: ")
	
	
	la $a0, str1
	jal strlen	#strlen(str1)
	
	move $a0, $v0
	li $v0, p_int10
	syscall		#print_int10(strlen(str1));
	
	li $v0, -1	#exit_value = -1
		
end:
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	jr $ra

	
################################################
strcpy: 
	li $t0, 1	#int i=0
	move $t2, $a0
do:	
	lb $t1, 0($a1)
	
	sb $t1, 0($a0)		#dst[i] = src[i];
	
	addu $a1, $a1, $t0
	addu $a0, $a0, $t0
	beq $t1, '\0', return
	j do
	
return:
	move $v0, $t2
	
end1:
	jr $ra
##################################################
strrev:
	addiu $sp,$sp,-16	# reserva espaço na stack
	sw $ra,0($sp)		# guarda endereço de retorno
	sw $s0,4($sp)		# guarda valor dos registos
	sw $s1,8($sp)		# $s0, $s1 e $s2
	sw $s2,12($sp)		#
	move $s0,$a0		# registo "callee-saved"
	move $s1,$a0		# p1 = str
	move $s2,$a0		# p2 = str
	
	
while1:
	lb $t1, 0($s2)
	beq $t1, '\0', endw1
	addiu $s2, $s2, 1
	j while1
	
endw1:
	addiu $s2, $s2, -1
	

while2:
	bge $s1, $s2, endw2
	move $a0, $s1
	move $a1, $s2
	jal exchange
	addiu $s1, $s1, 1
	addiu $s2, $s2, -1
	
	j while2

endw2:
	move $v0, $s0
	lw $ra,0($sp)		# repoe endereço de retorno
	lw $s0,4($sp)		# repoe valor dos registos
	lw $s1,8($sp)		# $s0, $s1 e $s2
	lw $s2,12($sp)	
	addiu $sp,$sp,16	
	
end2: jr $ra



exchange:
	lb $t0, 0($a0)
	lb $t1, 0($a1)
	
	sb $t0, 0($a1)
	sb $t1, 0($a0)

end3:	
	jr $ra
	
##############################################
strlen:	li $t1, 0

while:
	lb $t0, 0($a0)
	addiu $a0, $a0, 1
	beq $t0, '\0', endwhile
	addi $t1, $t1, 1
	j while
	
endwhile:
	move $v0, $t1
	jr $ra
		
	