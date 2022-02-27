#char id		1	1	0
#int sum		4	4	1
#char sample[29]	1	29	5
#unsigned char ns	1	1	34
#float average		4	4	38
#preassure		4	44

#pts:	$t4
#maxIndex: $t2
#i:	$t1
#j:	$t3
#sum: 	$t0
#acc:	$f2

	.eqv of_id, 0
	.eqv of_sum, 1
	.eqv of_sample, 5
	.eqv of_ns, 34
	.eqv of_average, 38
	
	.data
acc:	.float 0.0
	.text
	.globl main
main:
float_recalc:

	li $t0, 0	#sum = 0
	li $t1, 0	#i=0
	move $t2, $a1	#maxindex
	move $t4, $a0	#pts
for_i:
	bge $t1, $t2, endfor_i	#i< maxIndex
	li $t3, 0	#j = 0
	
	lw $t5, of_ns($t4) #pts->ns
for_j:	
	bge $t3,$t5, endfor_j
	lw $t6, of_sample($t4)
	add $t6, $t6, $t3	#pts-> sample[j]
	add $t0, $t0, $t6	#sum+= pts-> sample[j]
	
	sw $t0, of_sum($t4)	#pts-> sum
	
	mtc1 $t0, $f4		#(float)sum
	cvt.s.w $f4, $f4
	mtc1 $t5, $f6		#(float)pts->ns
	cvt.s.w $f6, $f6
	
	div.s $f4, $f4, $f6	#num/ pts->ns
	s.s $f4, of_average($t4) #pts-> average= num/pts->ns
	
	add.s $f2, $f2, $f4	#sum+= pts-> average	
	
	addi $t3, $t3, 1
	j for_j
endfor_j:
	mtc1 $t2, $f4
	cvt.s.w $f4, $f4
	div.s $f0, $f2, $f4
	
	addi $t1, $t1, 1
	addi $t4, $t4, 44
	j for_j
endfor_i:

endend:
	jr $ra

		