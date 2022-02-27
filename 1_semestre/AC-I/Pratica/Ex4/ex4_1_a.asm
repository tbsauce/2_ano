# num: $t0
#i: $t1
#str: $t2
#str+i: $t3
#str[i]: $t4

	.data
	.eqv size, 20
	.eqv read_string, 8
	.eqv print_int10, 1
str:	.space	size		#size of string

	.text
	.globl main
main:	la $a0, str
	li $a1, size
	li $v0, read_string
	syscall	
	li $t0, 0
	li $t1, 0
	#num=0; i=0;

while:	la $t2, str	#$t2 = str 
	addu $t3, $t2, $t1 #$t3 = str+i
	lb $t4, 0($t3) #$t4=str[i]
	beq $t4, '\0', endw
if:	blt $t4, '0', endif
	bgt $t4, '9', endif
	addi $t0, $t0, 1 #num++

endif:
	addi $t1, $t1, 1 #i++
	j while
	
endw: 	or $a0, $0, $t0
	li $v0, print_int10
	syscall
	jr $ra