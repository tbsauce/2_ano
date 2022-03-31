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
    addiu   $sp, $sp, -20
    sw      $ra, 0($sp)
    sw      $s0, 4($sp)
    sw      $s1, 8($sp)
    sw      $s2, 12($sp)
    sw      $s3, 16($sp)

    lui     $s0, SFR_BASE_HI        # 0xBF88
    li $s2, 0                       # count = 0

    lw      $s1, TRISE($s0)         # READ  (Mem_addr = 0xBF880000 + 0x6040)
    andi    $s1, $s1, 0xFFF0        # MODIFY (bit(0-3) = 0) output
    sw      $s1, TRISE($s0)         # WRITE (Write TRISE register)

    lw      $s1, TRISB($s0)         # READ  (Mem_addr = 0xBF880000 + 0x6100)
    ori     $s1, $s1, 0x0008        # MODIFY (bit3 = 1) input
    sw      $s1, TRISB($s0)         # WRITE (Write TRISB register)


loop:
     
    lw      $s1, LATE($s0)
    andi    $s1, $s1, 0xFFF0
    or      $s1, $s1, $s2
    sw      $s1, LATE($s0)

    li      $a0, 500
    jal     delay

    lw      $s3, PORTB($s0)
    andi    $s3, $s3, 0x0008
    
if:
    bne $s3, 0x0008, else
    addi $s2, $s2, 0x0001
    j endif

else:
    sub $s2, $s2, 0x0001

endif:
    j loop

    lw      $ra, 0($sp)
    lw      $s0, 4($sp)
    lw      $s1, 8($sp)
    lw      $s2, 12($sp)
    lw      $s3, 16($sp)
    addiu   $sp, $sp, 20

    li      $v0, 0                          #       return 0;
    jr      $ra



############################################################### 
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