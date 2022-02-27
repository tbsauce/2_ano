# Mapa de registos
# n: $a0 -> $s0
# b: $a1 -> $s1
# s: $a2 -> $s2
# p: $s3
# digit: $t0
itoa:
	addiu $sp, $sp, -20
	sw $s0, 0($sp)
	sw $s1, 4($sp)
	sw $s2, 8($sp)
	sw $s3, 12($sp)
	sw $ra, 16($sp)
	
	move $s0, $a0
	move $s1, $a1
	move $s2, $a2
	move $s3, $a2
	
do:
	rem $t0, $s0, $s1 	#digit = n % b
	
	div $s0, $s0, $s1	#n = n / b
	
	move $a0, $t0
	jal toascii		#toascii( digit )
	
	sb $v0 , 0($s3)		#*p = toascii( digit )
	addiu $s3, $s3, 1	#p++
	
while:
	bgt $s0, $0, do  		#while(n > 0)
	
	li $t1, '\0'
	sb $t1,0($s3) 
	
	move $a0, $s2
	jal strrev		#strrev( s );
	
	move $v0, $s2
	
	
	lw $s0, 0($sp)
	lw $s1, 4($sp)
	lw $s2, 8($sp)
	lw $s3, 12($sp)
	lw $ra, 16($sp)
	addiu $sp, $sp, 20
	
	jr $ra
	
	
	
###########################################
toascii:
	lb $t0, 0($a0)
	
	addi $t0, $t0, '0'
	
if:
	ble $t0, '9', endif
	
	addi $t0, $t0, 7 
	
endif:
	move $v0, $t0
	
end: 
	jr $ra
##############################################
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
	
