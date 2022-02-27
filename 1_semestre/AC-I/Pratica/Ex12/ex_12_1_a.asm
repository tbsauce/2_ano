	.eqv p_int, 1
	.eqv p_float, 2
	.eqv p_double, 3
	.eqv p_string, 4
	.eqv r_int, 5
	.eqv r_float, 6
	.eqv r_double, 7
	.eqv r_string, 8
	.eqv p_char, 11
	.eqv r_char, 12
	
	
	.eqv id, 0		4	4	0
	.eqv fn, 4		1	18	4
	.eqv ln, 22		1	15	22
	.eqv g, 40		4	4	40
	.eqv size_stru, 44
	.eqv stu, 2
	
	.data
st_array: .space 88	#44*4
media:	.float
max_f:	.float -20.0
sum:	.float 0.0 
str:	.asciiz "\nMedia: "
str1:	.asciiz "N. Mec: "
str2:	.asciiz "Primeiro Nome: "
str3:	.asciiz "Ultimo Nome: "
str4:	.asciiz "Nota: "
	.text
	.globl main
main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	la $a0, st_array
	li $a1, stu
	jal read_data
	
	la $a0, st_array
	li $a1, stu
	l.s $f12, media
	jal max
	move $s0, $v0
	
	la $a0, str
	li $v0, p_string
	syscall
	
	mov.s $f12, $f0
	li $v0, p_float
	syscall
	
	move $a0, $s0
	jal print_student
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	li $v0, 0
	jr $ra
	
read_data:
	
	li $t0, 0			#i=0
	move $t1, $a0
	move $t6, $a1

	
forr:
	bge $t0, $t6, endforr
	
	mul $t3, $t0, size_stru
	addu $t2, $t1, $t3	#&arr[i]
	
	
	la $a0, str1
	li $v0, p_string
	syscall				#print_string("N. Mec: ")
	
	li $v0, r_int
	syscall
	sw  $v0, id($t2)		#read_id
	
	
	
	la $a0, str2
	li $v0, p_string
	syscall				#print_string("primeiro nome")
	
	addiu $a0, $t2, fn
	li $a1, 17
	li $v0, r_string
	syscall				#read_fn
	
	
	la $a0, str3
	li $v0, p_string
	syscall				#print_string("last name ")
	
	addiu $a0, $t2, ln
	li $a1, 14
	li $v0, r_string
	syscall				#read_ln

	
		
	la $a0, str4
	li $v0, p_string
	syscall				#print_string("grade")
	
	li $v0, r_float
	syscall
	s.s  $f0, g($t2)			#read_grade
	
	addi $t0, $t0, 1
	j forr
	
endforr:
	jr $ra

max:
	l.s $f6, max_f
	move $t0, $a0
	mul $t1, $a1, size_stru
	addu $t1, $t0, $t1
	
	
form:
	bge $t0, $t1, endform
	
	l.s $f2, g($t0)
	add.s $f4, $f4, $f2
	
ifm:	

	c.le.s $f2, $f6
	bc1t endifm
	
	mov.s $f6, $f2
	move $v0, $t0
endifm:
	addiu $t0, $t0, size_stru
	j form
	 
endform:
	mtc1 $a1, $f8
	cvt.s.w $f8,$f8
	
	div.s $f0, $f4, $f8
	jr $ra 
	
	
print_student:
	
	move $t0, $a0
	
	
	lw $a0, id($t0)
	li $v0, p_int
	syscall
	
	addiu $a0, $t0, fn
	li $v0, p_string
	syscall
	
	addiu $a0, $t0, ln
	li $v0, p_string
	syscall
	
	l.s $f12, g($t0)
	li $v0, p_float
	syscall
	
	jr $ra
	
	

	
	


	
	
