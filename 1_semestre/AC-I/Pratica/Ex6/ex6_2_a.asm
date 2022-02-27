#$t0, size
#$t1, p
#$t2, ultp
	

	.eqv p_string, 4
	.eqv p_char, 11
	.data
	.eqv size, 3
array:	.word str1, str2, str3
str1:	.asciiz "Array"
str2:	.asciiz "de"
str3:	.asciiz "ponteiros"
	.text
	.globl main
	
main:
	la $t1, array
	li $t0, size
	sll $t0,$t0 2 
	addu $t2, $t0, $t1
	
for:
	bge $t1, $t2, end
	
	lw $t3, 0($t1)
	
	move $a0, $t3
	li $v0, p_string
	syscall
	
	addiu $t1, $t1, 4
	
	j for
	
end:
	jr $ra
	
