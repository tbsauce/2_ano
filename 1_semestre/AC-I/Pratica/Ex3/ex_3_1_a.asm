	.data
str1:	.asciiz "Introduza um numero: "
str2:	.asciiz	"Valor ignorado\n"
str3:	.asciiz "A soma dos positivos e: "
	.eqv print_string,4
	.eqv read_int,5
	#soma $t0
	#value $t1
	#i $t2
	
.text
.globl main
main: 	li $t0, 0
	li $t2, 0
	
for: 	bge $t2,5, endfor 
	#while
	la $a0, str1 
	li $v0,print_string 
	syscall
	#print
	li $v0,read_int
	syscall
	or $t1, $v0, $0
	#read int
	ble $t1,$0,else
	#if(value>0)
	add $t0, $t1, $t0
	#soma = soma + value
	j endif
	#jumps to for
	
 else:	la $a0, str2
 	ori $v0, $0, print_string
 	syscall
 	#print
 	
 	j endif

 endif: addi $t2, $t2, 1
 	#i++
 	j for
 
 endfor: la $a0, str3
 	 ori $v0, $0, print_string
 	 syscall
 	 #print
 	 
 	 or  $a0, $t0, $0
 	 ori $v0, $0, 1
 	 syscall
 	 #print 10
 	 
jr	$ra
 	 
 	 
	
		
	
	
	
