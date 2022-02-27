#i	 		$t0
#v	 		$t1
#v1			$t2
#&val			$t3
#&val[i]		$t4
#&val[size/2+i]		$t5
#size			$t6


	.data
	.eqv size, 8
	.eqv p_string, 4
	.eqv p_int10, 1
	.eqv p_char, 11
arr: 	.word 8, 4, 15, -1987, 327, -9, 27, 16
str:	.asciiz "Result is:"
	.text
	.globl main

main:
	li $t0, 0		# i= 0
	la $t3, arr		# t2=$arr

do:
	sll $t6, $t0, 2
	addu $t4, $t3, $t6	#&val[i]
	
	li $t6, size
	div $t6, $t6, 2		#size/2
	sll $t6, $t6, 2
	
	addu $t5, $t4, $t6
	
	lw $t1, 0($t4)		#v= val[i]
	
	lw $t2, 0($t5)		#v1 = val[size/2+i]
	
	sw $t1, 0($t5)		#val[size/2+i] = v 
		
	sw $t2, 0($t4)		#val[i] = v1
	
	addi $t0, $t0, 1	#i++
	
while:
	li $t6, size
	div $t6, $t6, 2		#size/2
	blt $t0, $t6, do	#i< size/2
	
	
printS:
	la $a0, str
	li $v0, p_string	
	syscall			#print(str)
	
	
	li $t0, 0		#i =0

do1:
	sll $t6, $t0, 2
	addu $t4, $t3, $t6	#&val[i]
	
	
	lw $a0, 0($t4)		
	li $v0, p_int10
	syscall			#print(arr[i])
	
	addi $t0, $t0, 1	#i++
	
	li $a0, ','
	li $v0, p_char
	syscall			#print(',')
	
while1:
	li $t6, size
	blt $t0, $t6, do1	#i<size
	
end:
	jr $ra
	
	


	
	

	
	
	
