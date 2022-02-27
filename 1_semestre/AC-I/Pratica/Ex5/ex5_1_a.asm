#$t0  i
#$t1  lista
#$t2  lista+i

	.data
	.eqv size, 5
str1: 	.asciiz "\nIntroduza um numero:"
	.align 2
list:	.space 20
	.eqv read_int, 5
	.eqv print_string, 4
	.text
	.globl main
main:
	li $t0, 0
while:	bge $t0, size, endw
	la $a0, str1
	li $v0, print_string
	syscall			#prints str1

	
	li $v0, read_int
	syscall
	
	
	la $t1, list
	sll $t2, $t0,2
	addu $t2, $t1, $t2   
	sw $v0, 0($t2)
	addi $t0, $t0, 1
	j while
	
endw: jr $ra
