	.eqv p_float, 2
	.eqv p_double, 3
	.eqv p_string, 4
	.eqv p_int10, 1
	.eqv r_int, 5
	.eqv r_float, 6
	.eqv r_double, 7
	.eqv p_char, 11
	.data
um:	.double	1.0
zero:	.double 0.0
meio:	.double 0.5	
	.text
	.globl main
main:
	addiu $sp, $sp, -4
	sw $ra , 0($sp)
	li $v0, r_double
	syscall
	
	mov.d $f12, $f0
	
	jal sqrt
	
	mov.d $f12, $f0
	li $v0, p_double
	syscall
	
	
	lw $ra , 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
sqrt:
	l.d $f0, um	#xn = 1.0
	li $t0, 0	#i = 0
	
	l.d $f4, zero	#zero
	
if:	c.le.d $f12, $f4
	bc1t else	#val > 0.0
	
do:	
	mov.d $f2, $f0	#aux = xn
	
	div.d $f6, $f12, $f0	#val/xn
	
	add.d $f6, $f0, $f6	#xn + val/xn
	
	l.d $f8, meio
	
	mul.d $f0, $f8, $f6	#xn = 0.5 * (xn + val/xn)
	
while:
	addi $t0, $t0, 1	#i++
	c.eq.d $f2, $f0		#aux != xn
	bc1t end_sqrt
	blt $t0, 25, do		#i < 25
	
	j end_sqrt
	
else:
	l.d $f0, zero
end_sqrt:
	jr $ra
	
	