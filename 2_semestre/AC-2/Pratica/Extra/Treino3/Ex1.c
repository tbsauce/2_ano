#include <detpic32.h>

void configureAll();
void delay(int ms);

volatile int duty = 1;

int main(void){

    while(1){

        configureAll();

        if(PORTB & 0x0009 == 0x0008)
        duty = 70;

        if(PORTB & 0x0009 == 0x0001)
        duty = 25;

        delay(25);
    };

    return 0;
}

void configureAll(){
    //Port
    TRISB = TRISB | 0x0009;

    T2CONbits.TCKPS = 1;        //20000000 /((65535 +1) * 280);
                                //1:2 -> 1
    PR2 = 35713;                //20000000/(2 *280)- 1 = 35713
    TMR2 = 0;
    T2CONbits.TON = 1;

    OC2CONbits.OCM = 6;
    OC2CONbits.OCTSEL = 0;
    OC2RS = ((PR2 + 1) * duty) /100;
    OC2CONbits.ON = 1;

}

void delay(int ms) {
    resetCoreTimer();
    while(readCoreTimer() < 200 * ms);
}
