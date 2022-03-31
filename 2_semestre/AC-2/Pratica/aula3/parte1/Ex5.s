    .equ SFR_BASE_HI, 0xBF88
    .equ TRISB, 0x6040
    .equ PORTB, 0x6050
    .equ LATB, 0x6060
    .equ TRISE, 0x6100
    .equ PORTE, 0x6110
    .equ LATE, 0x6120
    .equ resetCoreTimer, 12
    .equ readCoreTimer, 11
    .equ putChar, 3
    .equ printInt, 6
    .equ inkey, 1
    .data
    .text
    .globl main
main:
    addiu $sp, $sp, -12
    sw $ra, 0($sp)
    sw $s0, 4($sp)
    sw $s1, 8($sp)

    li $s0, 0   #v = 0

    lui     $t1, SFR_BASE_HI        # 0xBF88
    lw      $t2, TRISE($t1)                 # READ  (Mem_addr = 0xBF880000 + 0x6100)
    andi    $t2, $t2, 0xFFFE        # MODIFY (bit0-3 = 0 - RE0
    sw      $t2, TRISE($t1)                 # WRITE (Write TRISE register)

loop:
    
    lw      $t3, LATE($t1)              #           $t3 = LATE
    andi    $t3, $t3, 0xFFFE            #           RE0 = 0
    or      $t3, $t3, $s0              #            
    sw      $t3, LATE($t1)
    
    li $a0, 500
    jal delay                           #delay(500)

    xori $s0, $s0, 0x0001

    j       loop

    sw $s1, 8($sp)
    lw $s0, 4($sp)
    lw $ra, 0($sp)
    addiu $sp, $sp, 12

    jr $ra

###########################
delay:
    li $v0, resetCoreTimer
    syscall
whiled:
    li $v0, readCoreTimer
    syscall

    li $t0, 20000	# k 
    mul $t0, $a0, $t0	#k *ms
    blt $v0, $t0, whiled
    jr $ra