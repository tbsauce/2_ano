	.eqv p_float, 2
	.eqv p_double, 3
	.eqv p_string, 4
	.eqv p_int10, 1
	.eqv p_intu10, 36
	.eqv r_int, 5
	.eqv r_float, 6
	.eqv r_double, 7
	.eqv p_char, 11
	
	.eqv of_id, 0
	.eqv of_first, 4
	.eqv of_last, 22
	.eqv of_grade, 40
	
	.data

	.align 2
stg:	.word 72343
	.asciiz "Napoleao"
	.space 9
	.asciiz "Bonaparte"
	.space 5
	.align 2
	.float 5.1
	
str1:	.asciiz "\nN. Mec: "
str2:	.asciiz "\nNome: "
str3:	.asciiz "\nNota: "

	.text
	.globl main
main:

	la $a0, str1
	li $v0, p_string
	syscall			#print_string()
	
	la $a0, stg
	lw $a0, of_id($a0)
	li $v0, p_intu10
	syscall			#print_intu10(stg.id_number)
	
	
	
	
	la $a0, str2
	li $v0, p_string
	syscall			#print_string()
	
	la $a0, stg
	addiu $a0, $a0, of_last
	li $v0, p_string
	syscall			#print_string(stg.last_name)
	
	li $a0, ','
	li $v0, p_char
	syscall			#print_char(',')
	
	la $a0, stg
	addiu $a0, $a0, of_first
	li $v0, p_string
	syscall			#print_string(stg.first_name)
	
	
	
	
	
	la $a0, str3
	li $v0, p_string
	syscall			#print_string()
	
	la $t0, stg
	l.s $f12, of_grade($t0)
	li $v0, p_float		#print_float(stg.grade);
	syscall
	
	
	
	
	
	li $v0, 0
	jr $ra
	
	
	
	
	
