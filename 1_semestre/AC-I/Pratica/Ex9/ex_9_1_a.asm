	.eqv p_float, 2
	.eqv p_double, 3
	.eqv p_string, 4
	.eqv p_int10, 1
	.eqv r_int, 5
	.eqv r_float, 6
	.eqv r_double, 7
	.eqv p_char, 11
	.data
num:	.float 2.59375
zero:	.float 0.0
	.text
	.globl main
main:

do:
	li $v0, r_int
	syscall		#val = read_int()
	
	mtc1 $v0, $f20
	
	cvt.s.w $f20, $f20	#(float)val
	l.s $f22, num		#num = 2.59375
	
	mul.s $f12, $f20, $f22		#res = (float)val * 2.59375;
	
	
	li $v0, p_float
	syscall
	
while:
	l.s $f24, zero
	c.eq.s $f12, $f24
	bc1f do	
end:
	li $v0, 0
	
	jr $ra
	
