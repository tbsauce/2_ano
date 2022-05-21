#include <detpic32.h>

int main(void){
    // Configure Timer T3 with interrupts enabled 
    //k_prescaler = 20 000 000 / (65535+1) * fout(neste caso 1Hz) ) = 300 como 2hz e o max entao ao fazer 2 vezes 2hz da 1 hz
   
    T3CONbits.TCKPS = 7; // 1:k_prescaler;  fout_presc = 78125 = 20 000 000 / 256;
    PR3 = 39063;  // Fout = 20Mhz / (256 * (39063 + 1)) = 1,999Hz          
    TMR3 = 0;  // Reset timer T3 count register
    T3CONbits.TON = 1;  // Enable timer T3   

    IPC3bits.T3IP = 2;      // Interrupt priority 2(podia ser 1 a 6) irrelevante pq só ha uma
    IEC0bits.T3IE = 1;      // Enable timer T3 interrupts
    IFS0bits.T3IF = 0;      // Reset timer T3 interrupt flag 

    EnableInterrupts();

    while(1);

    return 0;
}

void _int_(12) isr_T3(void) { //ReplaceVECTORbythetimerT3 // vector number
    static int count = 0;
    
    count = (count + 1 ) % 2;
    // 2 interruptions
    if(count == 0) {
        putChar('.');
        count = 0;
    }
    // Reset T3 interrupt flag
    IFS0bits.T3IF = 0;
}
