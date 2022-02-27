    .eqv p_float, 2
    .eqv p_double, 3
    .eqv p_string, 4
    .eqv p_int10, 1
    .eqv r_int, 5
    .eqv r_float, 6
    .eqv r_double, 7
    .eqv p_char, 11
    .eqv size, 3
    .data
oito:    .double 8.0
zero:	 .double 0.0
    .align 2
arr:    .space 24    #size *8
    .text
    .globl main
main:
    addiu $sp, $sp, -4
    sw $ra, 0($sp)
    
    la $s0 , arr    #&arr
    
    li $s1, 0    #i = 0
for_m:
    bge $s1, size, endfor_m    #i < SIZE
    
    sll $t0, $s1, 3
    add $t1, $s0, $t0
    
    li $v0, r_int
    syscall
    
    mtc1 $v0, $f2
    cvt.d.w $f2, $f2    #(double)read_int()
    
    s.d $f2, 0($t1)
    
    addi $s1, $s1, 1
    
    j for_m
    
endfor_m:
    
    mtc1 $s0, $f12
    cvt.d.w $f12, $f12
    li $a0, size
    jal average
    
    mov.d $f12, $f0
    li $v0, p_double
    syscall            #print average


    mtc1 $s0, $f12
    cvt.d.w $f12, $f12
    li $a0, size
    jal max
    
    mov.d $f12, $f0
    li $v0, p_double
    syscall            #print max

    
    lw $ra, 0($sp)
    addiu $sp, $sp, 4
    li $v0, 0
    jr $ra


###########################################
max:
    sub $a0, $a0, 1
    sll $a0, $a0, 3

    mtc1 $a0, $f2
    cvt.d.w $f2, $f2
    
    add.d $f4, $f12, $f2    #last ponteiro = $f4

    cvt.w.d $f12, $f12
    mfc1 $t0, $f12 
    
    l.d $f0, 0($t0)

    l.d $f10, oito
    cvt.d.w $f12, $f12
    add.d $f12, $f12, $f10     #max = *p++

for_max:
    c.le.d $f12, $f4
    bc1f endfor_max

    cvt.w.d $f12, $f12
    mfc1 $t0, $f12 

    l.d $f8, 0($t0)

if:
    c.le.d $f8, $f0
    bc1t endif

    mov.d $f0, $f8

endif:
    cvt.d.w $f12, $f12
    add.d $f12, $f12, $f10
    j for_max
    
endfor_max:
    jr $ra
    
################################################################
average:
	l.d $f2, zero	#double sum = 0.0
	
	move $t0, $a0	#int i = n;
	
for:
	ble $t0, 0, endfor	#i > 0
	
	sll $t1, $t0, 3
	mtc1 $t1, $f6
	cvt.d.w $f6, $f6
	 
	add.d $f6, $f12, $f6
	
	cvt.w.d $f6, $f6 
	mfc1 $t1, $f6
	
	l.d $f4, -8($t1)
		
	add.d $f2, $f2, $f4	#sum += array[i-1];
	
	
	sub $t0, $t0, 1		#i--
	
	j for
	
endfor:
	mtc1 $a0, $f6
	cvt.d.w $f6, $f6	#(double)n
	
	div.d $f0, $f2, $f6
	
	jr $ra
	
	

    
