#$t0, i
#$t1, j
#$t2, &array[i]
#$t3, &array[i][j]
#$t4, i *4
	

	.eqv p_char, 11
	.data
	.eqv size, 3
array:	.word str1, str2, str3
str1:	.asciiz "Array"
str2:	.asciiz "de"
str3:	.asciiz "ponteiros"
	.text
	.globl main
	
main:
	
while:
	bge $t0, size, endw
	
	la $t2, array
	
	sll $t4, $t0, 2 #i*4
	addu $t2, $t2, $t4
	
	lw $t2, 0($t2)	#load endereco da word
	
	
	addu $t3, $t2, $t1
	lb $t3, 0($t3)	#load byte do caracter
	
	beq $t3, '\0', reset	#reset j=0 i++
	
	move $a0 , $t3
	li $v0, p_char
	syscall
	
	li $a0 , '-'
	li $v0, p_char
	syscall
	
	addi $t1, $t1, 1	#j++
	
	j while
	
reset:
	addi $t0, $t0, 1	
	li $t1, 0
	
	j while
endw:
	jr $ra
