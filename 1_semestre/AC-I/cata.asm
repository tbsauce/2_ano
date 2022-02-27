#Mapa de Registos
# $t0 - val
# $t1 - n
# $t2 - min
# $t3 - max

	.data
	.eqv print_string,4
	.eqv print_int10,1
	.eqv read_int,5
	.eqv print_char,11
	
str1 : 	.asciiz "Digite até 20 inteiros (zero para terminar): "
str2 : 	.asciiz "Máximo/Mínimo são: "
	
	.text
	.globl main
	
main : 	li $t1, 0		# n = 0
	li $t2, 0x7FFFFFFF	# min = 0x7FFFFFFF
	li $t3, 0x80000000	# max = 0x80000000
	la $a0, str1
	li $v0, print_string
	syscall
	
while: 	bge $t1, 5, endw # n<20
	li $v0, read_int  #val = read_int()
	syscall 
	
	move $t0, $v0
	
	beqz $t0, endw
	ble $t0, $t2, if2 # if val>max
	bge $t0, $t3, if1 # if val<max
	
	addi $t1, $t1, 1 # num++
	j while
	

if1:	move $t3, $t0     # val = max
	addi $t1, $t1, 1 # num++
	j while
	
if2:	move $t2, $t0     # val = max
	addi $t1, $t1, 1 # num++
	j while

endw: 	la $a0, str2
	li $v0, print_string
	syscall
	
	move $a0, $t3
	li $v0, print_int10
	syscall
	
	li $a0, ':'
	li $v0, print_char
	syscall
	
	move $a0, $t2
	li $v0, print_int10
	syscall
	
	
	jr $ra