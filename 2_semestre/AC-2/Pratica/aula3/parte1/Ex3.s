    .equ SFR_BASE_HI, 0xBF88
    .equ TRISD, 0x60C0
    .equ PORTD, 0x60D0
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

    lw      $t2, TRISD($t1)         # READ  (Mem_addr = 0xBF880000 + 0x6040)
    ori     $t2, $t2, 0x0100       # MODIFY (bit8 = 0 - RD8
    sw      $t2, TRISD($t1)                 # WRITE TRISB register
loop:                                               #   while(1) {
    lw      $t2, PORTD($t1)                 #           $t2 = PORTD
    andi    $t2, $t2, 0x0100                #               $t2 = RD8


    lw      $t3, LATE($t1)              #           $t3 = LATE
    andi    $t3, $t3, 0xFFFE            #           RE0 = 0
    srl     $t2, $t2, 8
    or      $t3, $t3, $t2               #           RE0 = RB0
    sw      $t3, LATE($t1)
    j           loop

    li      $v0, 0                          #       return 0;
    jr      $ra