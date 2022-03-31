    .equ resetCoreTimer, 12
    .equ readCoreTimer, 11
    .equ putChar, 3
    .equ printInt, 6

    .data

    .text
    .globl main
main:

    addiu $sp , $sp, -8
    sw $ra, 0($sp)
    sw $s0, 4($sp)
    
    li $s0, 0
while:

    li $a0, 1
    jal delay
    
    addi $s0, $s0, 1
    move $a0, $s0

    ori $a1, $0, 5
    sll $a1, 16
    ori $a1, $a1, 10
    li $v0, printInt
    syscall

    li $a0, '\r'
    li $v0, putChar
    syscall

    j while
endw:
    lw $ra, 0($sp)
    lw $s0, 4($sp)
    addiu $sp , $sp, 4
    
    li $v0, 0
    jr $ra
    
delay:
    li $v0, resetCoreTimer
    syscall
while2:
    li $v0, readCoreTimer
    syscall

    li $t0, 200000	# k = 200000
    mul $t0, $a0, $t0	#k *ms
    blt $v0, $t0, while2	#100hz
    jr $ra
    
