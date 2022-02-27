#val	$t0
#n	$t1
#min	$t2
#max	$t3	
	
	.data
	.eqv min, 0x7fffffff
	.eqv max, 0x80000000		
	.eqv r_int10, 5
	.eqv p_int10, 1
	.eqv p_string, 4
	.eqv p_char, 11
str:	.asciiz "Digite 20 inteiros (zero para terminar) \n"
str1:	.asciiz "Maximo/Minimo são: \n"
	.text
	.globl main

main:
	li $t1, 0	#n=0
	li $t2, min	#min= 0x7fffffff
	li $t3, max	#max= 0x80000000	
	
	la $a0, str
	li $v0, p_string
	syscall		#print(str)
	
do:
	li $v0, r_int10
	syscall 	#readint()

	move $t0, $v0	#val = readint()

if:
	beq $t0, $0, endif	# if val!=0
	
ifmax:	
	ble $t0, $t3, ifmin	#if val > max
	move $t3, $t0	# max = val
	
ifmin:	
	bge $t0, $t2, endif	#if val < min
	move $t2, $t0
	
endif:
	addi $t1, $t1, 1	#n++

#while sem negacao , logo &&	
#while:
#	blt $t1, 20, gand	#if n< 20
#	j print
#gand:
#	bne $t0, $0, do		#if val!=0
#	j print


#while com negacao , logo ||


while:
	bge $t1, 5, print
	beq $t0, $0, print
	
	j do
	
print:
	la $a0, str1
	li $v0 ,p_string
	syscall
	
	move $a0, $t3
	li $v0, p_int10
	syscall
	
	li $a0, ':'
	li $v0 , p_char
	syscall
	
	move $a0, $t2
	li $v0, p_int10
	syscall
	
end:
	jr $ra
	
