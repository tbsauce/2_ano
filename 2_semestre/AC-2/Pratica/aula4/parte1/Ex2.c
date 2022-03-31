#include <detpic32.h>

void delay(int ms);

int main(void){
    //inicializar entrada a 0
    LATE = LATE & 0xFFF0;
    // Configure port RE0 a RE3 as output
    TRISE = (TRISE & 0xFFF0);

    int count = 1;

    while(1){
        // LATE = count
        LATE = (LATE & 0xFFF0) | count;
        // Wait 4 hz
        delay(250);
        
        count = (count + 1 ) & 0x000F;
        //count = (count + 1 ) % 16;
    }
    return 0;
}

//Funcao delay
void delay(int ms){
    resetCoreTimer();
    while(readCoreTimer()<20000);
}