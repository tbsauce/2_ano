	.eqv p_string, 4
	.eqv p_char, 11
	.eqv p_int10, 1
	.eqv size, 40
	.data
str:	.asciiz "101101"
	.text
	.globl main
main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	la $a0, str
	jal atoi
	
	move $a0, $v0
	li $v0, p_int10
	syscall
	
	
	li $v0, 0
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4

end:
	jr $ra
	
#$t0, res
#$t2, digit
atoi:
	li $t0, 0	#res = 0
	
while:
	lb  $t1, 0($a0)
	
	blt $t1, '0', endwhile
	bgt $t1, '1', endwhile	#(*s >= '0') && (*s <= '9')
	
	
	sub $t2, $t1, '0'	#digit = *s++ - '0';
	addiu $a0, $a0, 1	#s++
	
	sll $t0, $t0, 1
	add $t0, $t0,$t2 	#res = 10 * res + digit;
	
	j while
	
endwhile:
	move $v0, $t0

	
end1:
	jr $ra 
