#argc: $s0	
#argv: $s1
#fArr: $t0
#i: $t1
#p: $t2
	.eqv size, 4
	.eqv p_float, 2
	.data
fArr:	.space 40	#4*size
	.text
	.globl main
main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	move $s0, $a0
	move $s1, $a1
if1:
	bge $s0, 1, endif1	# argc< 1
	li $v0, -1 	#return -1
	jr $ra
endif1:

	li $t1, 0	#i=0
	la $t2, fArr	#p=fArr	
for:
	bge $t1, $s0, endfor
	bge $t1, size, endfor	#i<argc && i<size
	
	add $a0, $s1, $t1	
	li $a1, 10
	jal atoi	#atoi
	
	mtc1 $v0, $f2
	cvt.s.w	$f2, $f2	#(float)atoi
	
	s.s $f2, 0($t2)
	addi $t1, $t1, 1	#i++
	addi $t2, $t2,	4	#p++ 		
	j for
endfor:

	l.s $f12, fArr
	move $a0, $s0
	jal mean	#mean
	
	mov.s $f12, $f0
	li $v0, p_float
	syscall
	
end:
	addiu $sp, $sp, 4
	lw $ra, 0($sp)
	li $v0, 0
	jr $ra

atoi:
mean:
	
	