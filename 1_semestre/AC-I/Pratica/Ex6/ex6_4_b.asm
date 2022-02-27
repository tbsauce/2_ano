#$t0, size
#$t1, array
#$t2, i
#$t3, i*4
#$t4, &array + i
		
	.eqv p_string, 4
	.eqv p_char, 11
	.eqv p_int10, 1
	.data
str1:	.asciiz "Nr. de parametros:"
str2:	.asciiz ":"
	.text
	.globl main
main:
	
	move $t0, $a0 #size
	move $t1, $a1 # &array
	
	la $a0, str1
	li $v0, p_string
	syscall
	
	move $a0, $t0
	li $v0, p_int10
	syscall
	
	li $a0, '\n' 
	li $v0, p_char
	syscall
	
for:
	bge $t2, $t0, endf #i < size
	
	move $a0, $t2
	li $v0, p_int10
	syscall
	
	la $a0, str2
	li $v0, p_string
	syscall
	
	sll $t3, $t2, 2
	addu $t4, $t3, $t1
	
	lw $t4, 0($t4)
	 
	move $a0, $t4
	li $v0, p_string
	syscall
	
	li $a0, ' ' 
	li $v0, p_char
	syscall
	
	
	addi $t2, $t2, 1
	 
	j for
	 
endf:
	jr $ra
	 
	 
