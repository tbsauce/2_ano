#n_even    $t0
#n_odd	   $t1
#p1	   $t2
#p2	   $t3
#ult	   $t4


	
	.data
	.eqv size, 5
	.eqv r_int,5
	.eqv p_string,4
        .eqv p_char,11
        .eqv p_int10,1
array1:	.space 20	#size*4
array2:	.space 20	#size*4
str:	.asciiz "aaaaaa"
	.text
	.globl main
main:
	la $t2, array1
	li $t4, size
	sll $t4, $t4, 2
	addu $t4, $t2, $t4  # a+N---> ult ponteiro
	
for:
	bge $t2, $t4, endf
	
	li $v0, r_int
	syscall
	
	sw $v0, 0($t2)
	
	addiu $t2, $t2, 4
	
	j for
endf:
	la $t2, array1
	la $t3, array2
	
for1:
	bge $t2, $t4, endf1
if:

	lw $t5, 0($t2)
	rem $t5, $t5, 2
	beq $t5, $0, else
	
	lw $t5, 0($t2)
	sw $t5, 0($t3)

	addiu $t3, $t3, 4
	addi $t1, $t1, 1
	
	j endif 
	
else:
	addi $t0, $t0, 1
	
	j endif
	
endif:
	addiu $t2, $t2, 4
	
	
	j for1
	
endf1:
	la $t3, array2
	
	sll $t1, $t1, 2
	addu $t4, $t3, $t1 

for3:
	bge $t3, $t4, end
	
	lw $a0, 0($t3)
	li $v0, p_int10
	syscall
	
	li $a0, ':'
	li $v0, p_char
	syscall
	
	addiu $t3, $t3, 4
	j for3
	

end:
	jr $ra
