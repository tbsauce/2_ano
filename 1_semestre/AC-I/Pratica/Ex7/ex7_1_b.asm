	.data
str:	.asciiz "123456789"
	.eqv p_int10, 1
	.text
	.globl main

main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)		#salvaguardar $ra
	
	la $a0, str
	jal strlen		#chamar funcao
	
	
	move $a0, $v0
	li $v0, p_int10
	syscall			#print
	
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4 	#restaurar $ra
	
end:
	jr $ra
	
	
	
#funcao strlen
#$a0	p
#$t0	*p
#$t1	len
#$v0	len final


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
