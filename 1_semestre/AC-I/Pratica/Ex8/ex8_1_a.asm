#$t0, res
#$t2, digit
atoi:
	li $t0, 0	#res = 0
	
while:
	lb  $t0, 0($a0)
	
	blt $t1, '0', endwhile
	bgt $t1, '9', endwhile	#(*s >= '0') && (*s <= '9')
	
	
	sub $t2, $t1, '0'	#digit = *s++ - '0';
	addiu $t1, $t1, 1	#s++
	
	mul $t0, $t0, 10
	add $t0, $t0,$t2 	#res = 10 * res + digit;
	
	j while
	
endwhile:
	move $v0, $t0

	
end:
	jr $ra 