#include <detpic32.h>

int main(void) {
    // Configure UART2:
    // 1 - Configure BaudRate Generator
    U2BRG = 10;      // U2BRG = (20MHz / (16 * 115200)) – 1  = 10
    // 2 – Configure number of data bits, parity and number of stop bits
    U2MODEbits.PDSEL = 0;
    U2MODEbits.STSEL = 0;       // only 1 stop bit
    U2MODEbits.BRGH = 0;        // divide by 16
    // 3 – Enable the trasmitter and receiver modules (see register U2STA) --> procurar "STA", clicar no link e pesquisar o transmit e receiver enable bits
    U2STAbits.UTXEN = 1;        // Enable the trasmitter
    U2STAbits.URXEN = 1;        // Enable receiver modules
    // 4 – Enable UART2 (see register U2MODE)
    U2MODEbits.ON = 1;          // Enable UART2
} 

