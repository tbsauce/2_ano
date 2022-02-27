	#v : $t2
	#v1: $t3
	#i : $t0
	#size/2 : $t4
	#arr: $t1
	
	
	
	.data
	.eqv SIZE,8
        .eqv p_string,4
        .eqv p_char,11
        .eqv p_int10,1
str1:   .asciiz "Result is: \n"
arr:	.word 8, 4, 15, -1987, 327, -9, 27, 16

	.eqv size, 8		# size array
	
	.text
	.globl main
main:	

	li $t0, 0		#i = 0 ($t0)
	
do:	#do while
	la $t1, arr		# &(arr[0]) ($t1)
	
	
	sll $t5, $t0, 2
	addu $t1, $t1, $t5
	
	lw $t2, 0($t1)		# v = arr[i]
	
	li $t4, size		#$t4 = size
	div $t4, $t4, 2		#t4 = size/2 ($t4)
	sll $t4, $t4, 2
	addu $t1, $t1, $t4		#atualiza arr
	
	lw $t3, 0($t1)		#$t3 = arr[i+size/2]
	
	sw $t2, 0($t1)
	sub $t1, $t1, $t4
	sw $t3, 0($t1)
	
	addi $t0, $t0, 1
	
	srl $t4, $t4, 2
	
	blt $t0, $t4, do

next:
        la $a0,str1
        li $v0,p_string
        syscall        #print

    li $t0,0      #i=0
do2:
        la $t2, arr    #arr(0)
        sll $t1, $t0, 2
        add $t2, $t1, $t2 #arr+i
        lw $a0,0($t2)
        li $v0,p_int10
        syscall

        li $a0,':'
        li $v0,p_char
        syscall
        
        addi $t0, $t0, 1 #i++


while2: 
        bge $t0,SIZE,endw
        j do2

endw:
    jr $ra

	
	jr $ra
