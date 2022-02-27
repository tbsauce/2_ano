	.eqv p_float, 2
	.eqv p_double, 3
	.eqv p_string, 4
	.eqv p_int10, 1
	.eqv r_int, 5
	.eqv r_float, 6
	.eqv r_double, 7
	.eqv p_char, 11
	.data
trinta: .double 32.0
cinco:	.double 5.0
nove:	.double 9.0
str:	.asciiz "Choose a temperature in Fahrenheit:"
	.text
	.globl main
main:

	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	 
	la $a0, str
	li $v0, p_string
	syscall
	
	li $v0, r_double
	syscall
	
	mov.d $f12, $f0

	jal f2c
	
	mov.d $f12, $f0
	li $v0, p_double
	syscall
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
	
	
f2c:
	l.d $f2, trinta
	l.d $f4, cinco
	l.d $f6, nove
	sub.d $f0, $f12, $f2
	div.d $f4, $f4, $f6
	mul.d $f0, $f4, $f0
	
	jr $ra