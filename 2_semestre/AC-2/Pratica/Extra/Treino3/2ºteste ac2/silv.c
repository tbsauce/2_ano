#include <detpic32.h>

volatile char keyboard = 0;

void configure_dip(void);
void configUart(int baudRate, int parity, int stop);
void putc(char byte2send);
void puts(char *s);

int main(void)
{
    configure_dip();
    configUart(9600, 10, 1);
    EnableInterrupts();

    
    LATEbits.LATE4 = 1;
    while (1)
    {
       
        
    }
}

void configure_dip(void)
{
    TRISEbits.TRISE4 = 0;

    ///// DIP SWITCH
    // Colocar os portos RB3 ... RB0 como inputs
    TRISB = TRISB | 0x000F;
}

void configUart(int baudRate, int parity, int stop)
{
    // Configure UART2:

    U2BRG = ((20000000 + 8 * baudRate) / (16 * baudRate)) - 1;
    U2MODEbits.BRGH = 0; // divisor de 16  = 0 ;   divisor de 4 = 1;

    U2MODEbits.PDSEL = parity; // 11 = 9-bit data, no parity  ; 10 = 8-bit data, odd parity  ;  01 = 8-bit data, even parity  ; 00 = 8-bit data, no parity
    U2MODEbits.STSEL = stop;   // 1 = 2 Stop bits ; 0 = 1 Stop bit

    U2STAbits.UTXEN = 1; // transmitter
    U2STAbits.URXEN = 1; // receiver

    // 4 - Enable interrupts

    U2STAbits.UTXSEL = 00;  // interrupts of transmitter
    U2STAbits.URXISEL = 00; // interrupts of receiver

    IEC1bits.U2RXIE = 1; // Enable U2RXIE interrupts
    //IEC1bits.U2TXIE = 1; // Enable U2TXIE interrupts
    //IEC1bits.U2EIE = 1;  // Enable U2EIE interrupts

    IFS1bits.U2RXIF = 0; // clear flags
   // IFS1bits.U2TXIF = 0;
    //IFS1bits.U2EIF = 0;

    IPC8bits.U2IP = 2; // priority

    U2MODEbits.ON = 1;
}

void _int_(32) isr_uart2(void)
{

    // If OERR == 1 then reset OERR
    if (U2STAbits.OERR == 1)
    {
        U2STAbits.OERR == 0;
    }
    // If FERR or PERR then
    // read UxRXREG (to discard the character) and return 0
    if (U2STAbits.FERR || U2STAbits.PERR)
    {
        char tmp = U2RXREG;
    }
    if (IFS1bits.U2RXIF == 1)
    {
        if (U2RXREG == 'T')
        {
            LATEbits.LATE4 = !LATEbits.LATE4;
        }

        if (U2RXREG == 'P')
        {
            puts("DipSwitch=");
            putc(PORTBbits.RB3 + 0x30);
            putc(PORTBbits.RB2 + 0x30); 
            putc(PORTBbits.RB1 + 0x30); 
            putc(PORTBbits.RB0 + 0x30);
            puts("\n");
        }
       // U2RXREG = "";
    }

    // Clear UART2 rx interrupt flag
    IFS1bits.U2RXIF = 0; // clear flags
}

void putc(char byte2send)
{
    while (U2STAbits.UTXBF == 1)
        ; // wait while UTXBF == 1

    U2TXREG = byte2send; // Copy byte2send to the UxTXREG register
    U2TXREG = 0;
    U2TXREG = 0;
    U2TXREG = 0;
    U2TXREG = 0;
    U2TXREG = 0;
    U2TXREG = 0;
    U2TXREG = 0;
}

void puts(char *s)
{
    while (*s)
    {
        putc(*s++);
    }
}