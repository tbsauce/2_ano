###########################
timeDone:

    li $t0, 0               #unsigned int retValue = 0

if:
    ble $a1, 0, else        #reset > 0
    li $v0, resetCoreTimer
    syscall                 #resetCoreTimer()

else:
    li $v0, readCoreTimer
    syscall                 #curCount = readCoreTimer();
    move $t1, $v0

ifelse:
    mul $t2, 20000, $a0
    ble $t1, $t2, endif     #if (curCount > (K * ms))
    div $t0, $t1, 20000     #retValue = curCount / K;

endif:
    move $v0, $t0

    jr $ra

