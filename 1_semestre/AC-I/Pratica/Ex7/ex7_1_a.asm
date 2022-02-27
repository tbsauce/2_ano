#funcao strlen
#$a0	p
#$t0	*p
#$t1	len
#$v0	len final


strlen:	li $t1, 0

while:
	lb $t0, 0($a0)
	addiu $a0, $a0, 1
	beq $t0, '\0', endwhile
	addi $t1, $t1, 1
	j while
	
endwhile:
	move $v0, $t1
	jr $ra