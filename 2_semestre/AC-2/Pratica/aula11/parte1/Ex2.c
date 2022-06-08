#include <detpic32.h>

void putc(char byte);

int main(void) {
    // Configure UART2: 115200, N, 8, 1
    U2BRG = 10;      // U2BRG = (20MHz / (16 * 115200)) – 1  = 10
    // 2 – Configure number of data bits, parity and number of stop bits --> procurar por parity
    U2MODEbits.PDSEL = 0;       // no parity
    U2MODEbits.STSEL = 0;       // only 1 stop bit
    U2MODEbits.BRGH = 0;        // divide by 16
    // 3 – Enable the trasmitter and receiver modules (see register U2STA) --> procurar "STA", clicar no link e pesquisar o transmit e receiver enable bits
    U2STAbits.UTXEN = 1;        // Enable the trasmitter
    U2STAbits.URXEN = 1;        // Enable receiver modules
    // 4 – Enable UART2 (see register U2MODE)
    U2MODEbits.ON = 1;          // Enable UART2

    // Configure UART2 interrupts, with RX interrupts enabled
    U2STAbits.URXISEL = 0;  // Select interrupt only for receiver

    // and TX interrupts disabled:
    IEC1bits.U2RXIE = 1;       // U2RX Interrupt Enable
    IEC1bits.U2TXIE = 0;       // U2TX Interrupt Disable
    IFS1bits.U2TXIF = 0;       // U2RX Interrupt Disable
    
    IPC8bits.U2IP = 1;         // UART2 Priority       
    // define RX interrupt mode (URXISEL bits)

    // Enable global Interrupts
    EnableInterrupts();

    while(1);

    return 0;
} 

void _int_(32) isr_uart2(void) {

    if (IFS1bits.U2RXIF == 1) {
        // Read character from FIFO (U2RXREG)
        char c = U2RXREG;
        // Send the character using putc()
        putc(c);
        // Clear UART2 Rx interrupt flag
        IFS1bits.U2RXIF = 0;
    }
} 

void putc(char byte) {
    while(U2STAbits.UTXBF == 1);// wait while UART2 UTXBF == 1
    // Copy "byte" to the U2TXREG register
    U2TXREG = byte;
} 
