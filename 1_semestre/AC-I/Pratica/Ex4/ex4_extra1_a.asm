	
	.eqv size, 20
	.eqv r_int,5
	.eqv p_string,4
        .eqv p_char,11
        .eqv p_int10,1
        .eqv r_string, 8
	.data
str1:	.asciiz "Introduza uma string:\n"
	.align 2
str:	.space 20
        .text
        .globl main
        
main:
	la $a0, str1
	li $v0, p_string
	syscall
	
	
	la $a0, str
	li $v0, r_string
	syscall
	
	la $t0, str
	
while:
	lb $t1, 0($t0)
	
	beq $t1,'\0', print
	
if:
	bgt $t1, 0x7a, endif
	blt $t1, 0x61, endif
	
	sub $t1, $t1, 0x20
	
	sb $t1, 0($t0) 
	
endif:
	addiu $t0, $t0, 1
	
	j while
	
print:

	la $a0, str
	li $v0, p_string
	syscall
	
	
	jr $ra
        
