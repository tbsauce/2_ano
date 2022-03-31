#include <detpic32.h>

void delay(int ms);

int main(void){
    //inicializar a 0
    LATB = LATB & 0x80FF;       
    LATD = LATD & 0xFFCF;
    // Configure port RB8 a RB14, RD5 e RD6 como saídas
    TRISB = (TRISB & 0x80FF);
    TRISD = (TRISD & 0xFF9F);      

    //ativar dislpay 
    LATDbits.LATD5 = 1;   // RD5 = 1
    LATDbits.LATD6 = 0;   // RD6 = 0 


    while(1){
        char c = getChar();
        switch (c){
        case 'a':
        case 'A':
            LATB = (LATB & 0x80FF) | 0x0100;   // RB8 = 1
            break;
        case 'b':
        case 'B':
            LATB = (LATB & 0x80FF) | 0x0200;   // RB9 = 1
            break;
        case 'c':
        case 'C':
            LATB = (LATB & 0x80FF) | 0x0400;   // RB10 = 1
            break;
        case 'd':
        case 'D':
            LATB = (LATB & 0x80FF) | 0x0800;   // RB11 = 1
            break;
        case 'e':
        case 'E':
            LATB = (LATB & 0x80FF) | 0x1000;   // RB12  = 1
            break;
        case 'f':
        case 'F':
            LATB = (LATB & 0x80FF) | 0x2000;   // RB13 = 1
            break;
        case 'g':
        case 'G':
            LATB = (LATB & 0x80FF) | 0x4000;   // RB14 = 1
            break;
        default:
            break;
        }
    }
    return 0;
}

//Funcao delay
void delay(int ms){
    resetCoreTimer();
    while(readCoreTimer()<20000);
}