	.eqv p_float, 2
	.eqv p_double, 3
	.eqv p_string, 4
	.eqv p_int10, 1
	.eqv r_int, 5
	.eqv r_float, 6
	.eqv r_double, 7
	.eqv p_char, 11
	.eqv n_int, -2	#int de entrada
	.data
n_float:.float 2	#float de entrada
um:	.float 1.0
str:	.asciiz "result:"
	.text
	.globl main
main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	l.s $f12, n_float
	li $a0, n_int
	
	jal xtoy
	
	la $a0, str
	li $v0, p_string
	syscall
	
	mov.s $f12, $f0
	li $v0, p_float
	syscall
	
	
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
	
xtoy:	
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	li $s0, 0		#i=0
	l.s $f0, um	#result=1.0
	
	jal abs			#abs(y)
	
for_xtoy:
	bge $s0, $v0, end_xtoy	#i < abs(y)

if_xtoy:
	ble $a0, $0, else_xtoy	#y > 0
	
	mul.s $f0, $f0, $f12	#result *= x
	j endif_xtoy
	
else_xtoy:
	div.s $f0, $f0, $f12	#result /= x
	
endif_xtoy:
	addi $s0, $s0, 1	#i++
	j for_xtoy

end_xtoy:	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
	
abs:
	bge $a0, $0, end_abs	#val <0
	
	sub $t0, $0, $a0	#val = -val
end_abs:
	move $v0, $t0
	
	jr $ra
	
	
	

	
	
	
	
	
	
