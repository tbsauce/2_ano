#$t0, i
#$t1, &array
#$t2, &array[]-----&str
	

	.eqv p_string, 4
	.eqv p_char, 11
	.data
	.eqv size, 3
str1:	.asciiz "Array"
str2:	.asciiz "de"
str3:	.asciiz "ponteiros"
array:	.word str1, str2, str3
	.text
	.globl main


main:

	li $t0, 0	
for:
	bgt $t0, size, end 
	la $t1, array
	sll $t2,$t0,2
	addu $t2, $t2, $t1
	lw $a0, 0($t2)
	li $v0, p_string
	syscall
	
	addi $t0, $t0, 1
	
	j for

end:	 
	
	jr $ra
		
