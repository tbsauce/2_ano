#p: $t0
#*p: $t1
#lista+SIZE: $t2
	.data
	.eqv size, 10
	.eqv print_int10, 1
	.eqv print_string, 4
str1:	.asciiz "\nConteudo do array:\n"
str2:	.asciiz ";"
	.align 2
array:	.word 8, -4, 3, 5, 124, -15, 87, 9, 27, 15
	.text
	.globl main
main:	
	la $a0, str1
	li $v0, print_string
	syscall			#print_string
	
	la $t0, array	#p = array
	li $t3, size
	sll $t3, $t3, 2
	add $t2, $t0, $t3
	
while:	bgeu $t0, $t2, endw
	lw $t1, 0($t0)
	
	addi $t0, $t0, 4    #passar a outra posicao do array
	
	move $a0, $t1
	li $v0, print_int10
	syscall
	
	
	la $a0, str2
	li $v0, print_string
	syscall			#print_string
	
	j while


endw:
	jr $ra
	
