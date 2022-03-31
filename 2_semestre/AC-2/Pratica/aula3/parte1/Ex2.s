    .equ SFR_BASE_HI, 0xBF88
    .equ TRISB, 0x6040
    .equ PORTB, 0x6050
    .equ LATB, 0x6060
    .equ TRISE, 0x6100
    .equ PORTE, 0x6110
    .equ LATE, 0x6120

    .data
    .text
    .globl main

main:
    lui     $t1, SFR_BASE_HI        # 0xBF88
    lw      $t2, TRISE($t1)                 # READ  (Mem_addr = 0xBF880000 + 0x6100)
    andi    $t2, $t2, 0xFFFE        # MODIFY (bit0 = 0 - RE0
    sw      $t2, TRISE($t1)                 # WRITE (Write TRISE register)

    lw      $t2, TRISB($t1)         # READ  (Mem_addr = 0xBF880000 + 0x6040)
    ori     $t2, $t2, 0x0001        # MODIFY (bit0 = 0 - RB0
    sw      $t2, TRISB($t1)                 # WRITE TRISB register
loop:                                               #   while(1) {
    lw      $t2, PORTB($t1)                 #           $t2 = PORTB
    andi    $t2, $t2, 0x0001                #               $t2 = RB0
    xori    $t2, $t2, 0x0001

    lw      $t3, LATE($t1)              #           $t3 = LATE
    andi    $t3, $t3, 0xFFFE            #           RE0 = 0
    or      $t3, $t3, $t2               #           RE0 = RB0
    sw      $t3, LATE($t1)
    j           loop

    li      $v0, 0                          #       return 0;
    jr      $ra