	.data
str1:	.asciiz "Introduza um numero: "
str2:	.asciiz "\nO valor em binário e': "
	.eqv print_string, 4
	.eqv read_int, 5
	.eqv print_char, 11
	
	.text
	.globl main
	
	# $t0 – value
	# $t1 – bit
	# $t2 – i
main:	la $a0, str1
	li $v0, print_string 
	syscall
	#print string
	li $v0, read_int
	syscall
	or $t0, $v0, $0
	#reads int
	la $a0, str2
	li $v0, print_string 
	syscall
	#print string
	li $t2, 0

for:	bge $t2, 32, endfor  
	andi $t1,$t0 , 0x80000000
	beq  $t1, $0, else   
	li $a0 ,'1'
	li $v0, print_char
	syscall
	#print do char
	j endif
	
space: 	rem $t3, $t2, 4
	bne $t3, $0, for
	li $a0 ,' '
	li $v0, print_char
	syscall
	#print do space
	j for

else:	li $a0 ,'0'
	li $v0, print_char
	syscall
	#print do char
	j endif

endif:
	sll $t0, $t0, 1
	#shifts left
	addi $t2, $t2, 1
	
	j space 
endfor:
	jr $ra
	
		
	
