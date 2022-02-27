	.eqv p_float, 2
	.eqv p_double, 3
	.eqv p_string, 4
	.eqv p_int10, 1
	.eqv r_int, 5
	.eqv r_float, 6
	.eqv r_double, 7
	.eqv p_char, 11
	.eqv size, 3
	.data
arr:	.space 24	#size times 8
um:	.double	1.0
zero:	.double 0.0
meio:	.double 0.5	
	.text
	.globl main
main:
	addiu $sp, $sp, -4
	sw $ra , 0($sp)
	
	la $s0, arr
	
for_m:
	bge $s1, size, endfor_m	#i < SIZE
	
	sll $t0, $s1, 3
	add $t1, $s0, $t0
	
	li $v0, r_int
	syscall
	
	mtc1 $v0, $f2
	cvt.d.w $f2, $f2	#(double)read_int()
	
	s.d $f2, 0($t1)
	
	addi $s1, $s1, 1
	
	j for_m
	
endfor_m:
	
	li $a1, size
	la $a0, arr
	
	jal stdev
	
	lw $ra , 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
#########################################################
stdev:
	addiu $sp, $sp, -4
	sw $ra , 0($sp)
	
	jal var	#var(array, nval)
	
	mov.d $f12, $f0
	
	jal sqrt	#sqrt( var(array, nval)
	
	
	lw $ra , 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
##########################################################
var:
	addiu $sp, $sp, -4
	sw $ra , 0($sp)
	
	mov.d $f2, $f12
	move $s0, $a1
	
	jal average
	
	cvt.s.d $f24, $f0 	#media =(float)average(array, nval)
	
for_var:
	l.s $f28, zero
	bge $s1, $s0, endfor_var	#i < nval
	
	sll $t0, $s1, 3
	mtc1 $t0, $f6
	cvt.d.w $f6, $f6
	 
	add.d $f6, $f22, $f6
	
	cvt.w.d $f6, $f6 
	mfc1 $t0, $f6
	
	
	l.d $f12, 0($t0)
	cvt.s.d $f12, $f12	#(float)array[i]
	
	sub.s $f12, $f12, $f24	#float)array[i] - media
	li $a0, 2
	jal xtoy
	
	add.s $f28, $f0, $f28	#soma += xtoy(...)
	
	addi $s1, $s1, 1
	
	j for_var
endfor_var:
	
	mtc1 $s0, $f30
	cvt.s.w $f30, $f30
	
	div.s $f0, $f28, $f30
	
	cvt.d.s $f0, $f0
	
	lw $ra , 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
##########################################################
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
	
###########################################################
average:
	l.d $f2, zero	#double sum = 0.0
	
	move $t0, $a0	#int i = n;
	
for:
	ble $t0, 0, endfor	#i > 0
	
	sll $t1, $t0, 3
	mtc1 $t1, $f6
	cvt.d.w $f6, $f6
	 
	add.d $f6, $f12, $f6
	
	cvt.w.d $f6, $f6 
	mfc1 $t1, $f6
	
	l.d $f4, -8($t1)
		
	add.d $f2, $f2, $f4	#sum += array[i-1];
	
	
	sub $t0, $t0, 1		#i--
	
	j for
	
endfor:
	mtc1 $a0, $f6
	cvt.d.w $f6, $f6	#(double)n
	
	div.d $f0, $f2, $f6
	
	jr $ra

###########################################################
xtoy:	
	addiu $sp, $sp, -8
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	
	li $s0, 0		#i=0
	l.s $f0, um	#result=1.0
	
	jal abs			#abs(y)
	
for_xtoy:
	bge $s0, $v0, end_xtoy	#i < abs(y)

if_xtoy:
	ble $a0, $0, else_xtoy	#y > 0
	
	mul.s $f0, $f0, $f12	#result *= x
	j endif_xtoy
	
else_xtoy:
	div.s $f0, $f0, $f12	#result /= x
	
endif_xtoy:
	addi $s0, $s0, 1	#i++
	j for_xtoy

end_xtoy:
	lw $s0, 4($sp)	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra

	
########################################################################	
abs:
	bge $a0, $0, end_abs	#val <0
	
	sub $t0, $0, $a0	#val = -val
end_abs:
	move $v0, $t0
	
	jr $ra
	
	