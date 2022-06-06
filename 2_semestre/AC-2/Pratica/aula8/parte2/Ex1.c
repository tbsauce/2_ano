#include <detpic32.h>

void delay(int ms);


int main(void){
    
    //reset
    LATE = LATE 

    //Ports
    TRISD = TRISD | 0x0100;
    TRISE = TRISE & 0xFFFE;

    if(PORTD == 0x0100){
        LATE = (LATE  & 0xFFFE) | 0x0001;
        delay(3000);
    }
}

//Funcao delay
void delay(int ms){
    resetCoreTimer();
    while(readCoreTimer()<20000 * ms);
}