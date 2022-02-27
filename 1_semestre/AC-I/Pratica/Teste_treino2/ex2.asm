#x: $f12
#tol: $f14
#fact: $t0
#i: $t1
#tmp: $f2
#sum: $f6
	.data
sum:	.float 0.0
um:	.float 1.0
	.text
	.globl main
main:
pow:
func2:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	li $t0, 1	#fact=1
	li $t1, 1	#i=1
	l.s $f6, sum	#sum= 0.0
		
do:	
	mul $t0, $t0, $t1	#fact*= i
	
	move $a0, $t1
	jal pow		#pow(x, i)
	
	mtc1 $t0, $f4	#(float)fact
	cvt.s.w $f4, $f4
	
	div.s $f2, $f0, $f4	#pow/fact

	add.s $f6, $f6, $f2
	
	addi $t1, $t1, 1	#i++
	
while:	
	c.le.s $f2, $f14	#tmp> tol
	bc1f do
	
	l.s $f16, um
	add.s $f0, $f6, $f16	#sum+1
end:

	addiu $sp, $sp, 4
	lw $ra, 0($sp)
	jr $ra
	
	