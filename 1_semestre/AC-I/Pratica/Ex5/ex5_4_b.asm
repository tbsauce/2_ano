#$t4, houve_troca
#$t5, p
#$t6, pult
#$t7

	.data
	.eqv false, 0
	.eqv true, 1
	.eqv r_int, 5
	.eqv p_int10, 1
	.eqv p_char,11
	.eqv size, 3
array:	.space size
	.text
	.globl main

main:
	la $t5, array  #$t5 = &array
	
	li $t7, size
	sub $t7, $t7, 1
	sll $t7, $t7, 2
	addu $t6, $t5, $t7  #$t6 = &ultarraya
	
readw:
	bgt $t5, $t6, order
	
	li $v0, r_int
	syscall

	sw $v0, 0($t5)
	
	addiu $t5, $t5, 4
	
	j readw



order:
	
do:
	la $t5, array  #$t5 = &array
	li $t4, false

for:
	bge $t5, $t6, while
	
	lw $t0, 0($t5)
	
	lw $t1, 4($t5)
	
if:	
	ble $t0, $t1, endif
	sw $t0, 4($t5)
	
	sw $t1, 0($t5)
	
	li $t4, true

endif: 
	
	addiu $t5, $t5, 4
	
	j for
	
while:
	bne $t4, true, print
	j do


print:
	la $t5, array  #$t5 = &array
	
printw:
	bgt $t5, $t6, end

	
	lw $a0, 0($t5)
	li $v0, p_int10
	syscall
	
	li $a0, ':'
	li $v0, p_char
	syscall
	
	addiu $t5, $t5, 4
	
	j printw
	
end:
	jr $ra
	