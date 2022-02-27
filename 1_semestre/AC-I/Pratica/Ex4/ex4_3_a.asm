#p:       $t0
#pultimo: $t1
#*p:      $t2
#soma:    $t3
	.data
array: .word 1, 2, 3, 40
	.eqv print_int10, 1
	.eqv SIZE,4
	.text
	.globl main
main: li $t3,0
      li $t4,SIZE
      sub $t4,$t4,1
      sll $t4,$t4,2
      la $t0, array
      addu $t1, $t0, $t4
      
while: bgtu $t0, $t1, endw
       lw $t2, 0($t0)     #$t2=p
       addu $t3, $t3,$t2
       addiu $t0,$t0,4    #cada int ocupa 4 lugares
       j while
endw:  move $a0, $t3
     li $v0, print_int10
     syscall
     
     jr $ra