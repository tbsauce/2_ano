#include <detpic32.h>

void delay(int ms);

int main(void) {
    unsigned char segment;
    LATB = LATB & 0x80FF;        
    LATD = LATD & 0xFF9F;      
    TRISB = TRISB & 0x80FF;             // configure RB8-RB14 as outputs
    TRISD = TRISD & 0xFF9F;             // configure RD5-RD6 as outputs

    //ativar dislpay 
    LATDbits.LATD5 = 1;                 // RD5 = 1
    LATDbits.LATD6 = 0;                 // RD6 = 0 

    int i ;
    while(1){
        segment = 1;  
        for(i=0; i < 7; i++){
            // send "segment" value to display
            LATB = (LATB & 0x80FF) | segment << 8; 
            // wait 0.5 second
            delay(500);
            segment = segment << 1;
        }
        //toggle display selection
        LATDbits.LATD5 = !LATDbits.LATD5;         
        LATDbits.LATD6 = !LATDbits.LATD6; 
    }
    return 0; 
}


void delay(int ms) {
    resetCoreTimer();
    while(readCoreTimer() < 20000 * ms);
}