#$t4, houve_troca
#$t5, i
#$t6, list
#$t7, list + i and size/size-1
#$t8, v
#$t9, v1

	
	.data
	.eqv size, 10
	.eqv false, 0
	.eqv true, 1
	.eqv r_int, 5
	.eqv p_int10, 1
list:	.space 40
	.text
	.globl main
main:
	li $t5, 0
#fill list
for0:
	bge $t5, size, do
	
	
	la $t6, list
	
	sll $t7, $t5, 2
	addu $t7, $t7, $t6
	
	
	li $v0, r_int
	syscall
	sw $v0, 0($t7)
	
	addi $t5, $t5, 1
	
	j for0
	
#order list
do:
	li $t4, false
	
	li $t5, 0
for1:
	li $t7, size
	sub $t7, $t7, 1

	bge $t5, $t7, endfor1
	
	
	sll $t7, $t5, 2
	addu $t7, $t7, $t6
	lw $t8, 0($t7)
	lw $t9, 4($t7)
	
if:	ble $t8, $t9, endif
	sw $t8, 4($t7)
	sw $t9, 0($t7)
	li $t4, true
	
endif:	
	addi $t5, $t5, 1
	j for1
	
endfor1:
	beq $t4, true, do
	
	
	
#print list
	li $t5, 0
do2:
	la $t6, list
	
	bge $t5, size, end
	
	sll $t7, $t5, 2
	addu $t7, $t7, $t6
	
	lw $t8 , 0($t7)
	move $a0, $t8
	li $v0, p_int10
	syscall
	
	addi $t5, $t5, 1
	
	j do2
	
end: 	jr $ra
	
	
	
	
