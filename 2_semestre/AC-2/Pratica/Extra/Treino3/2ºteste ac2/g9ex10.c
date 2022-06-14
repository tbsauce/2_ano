#include <detpic32.h>

#define DisableUart2RxInterrupt() IEC1bits.U2RXIE = 0
#define EnableUart2RxInterrupt() IEC1bits.U2RXIE = 1
#define DisableUart2TxInterrupt() IEC1bits.U2TXIE = 0
#define EnableUart2TxInterrupt() IEC1bits.U2TXIE = 1

#define BUF_SIZE 8
#define INDEX_MASK (BUF_SIZE-1)

typedef struct
 {
    unsigned char data[BUF_SIZE];
    unsigned int head;
    unsigned int tail;
    unsigned int count;
 } circularBuffer; 


volatile circularBuffer txb; // Transmission buffer
volatile circularBuffer rxb; // Reception buffer

void comDrv_flushRx(void);
void comDrv_flushTx(void);
void comDrv_putc(char ch);
void comDrv_puts(char *s);
void comDrv_config(int baudRate, char parity, int stop);
char comDrv_getc(char *pchar);

int main(void){
    comDrv_config(115200,00,0); // default "pterm" parameters with TX and RX interrupts disabled
    comDrv_flushRx();
    comDrv_flushTx();
    EnableInterrupts();
    
    comDrv_puts("PIC32 UART Device-driver\n"); 

    char tmp;
    while(1){
        if (comDrv_getc(&tmp)){
            comDrv_putc(tmp);
        }
    }
}

void comDrv_flushRx(void){
 // Initialize variables of the reception buffer
    rxb.count = 0;
    rxb.tail = 0 ;
    rxb.head = 0 ;
}

void comDrv_flushTx(void){
 // Initialize variables of the transmission buffer
    txb.count = 0;
    txb.tail = 0 ;
    txb.head = 0 ;
}

void comDrv_putc(char ch){
    while(txb.count == BUF_SIZE){} // Wait while buffer is full
    txb.data[txb.tail] = ch; // Copy character to the transmission
    // buffer at position "tail"
    txb.tail = (txb.tail + 1) & INDEX_MASK; // Increment "tail" index
    // (mod. BUF_SIZE)
    DisableUart2TxInterrupt(); // Begin of critical section
    
    txb.count++;                // Increment "count" variable
    EnableUart2TxInterrupt(); // End of critical section
}

void comDrv_puts(char *s){
    while(*s){
        comDrv_putc(*s++);       
    }   
}

void _int_(32) isr_uart2(void){
    if(IFS1bits.U2TXIF == 1){// if U2TXIF is set

        if(txb.count>0) {       // if "count" variable (transmission buffer, txb) is greater than 0
            while(U2STAbits.UTXBF != 0){}
            U2TXREG = txb.data[txb.head];// Copy character pointed by "head" to U2TXREG register
            txb.head= (txb.head +1) & INDEX_MASK;// Increment "head" variable (mod BUF_SIZE)
            txb.count--;// Decrement "count" variable
        }
        
        if(txb.count==0){// if "count" variable is 0 then
            DisableUart2TxInterrupt();
        }
        IFS1bits.U2TXIF = 0; // Reset UART2 TX interrupt flag
    }

    if(IFS1bits.U2RXIF == 1){// If U2RXIF is set 

        rxb.data[rxb.tail] = U2RXREG; // Read character from UART and
                                    // write it to the "tail" position
                                    // of the reception buffer

        rxb.tail=(rxb.tail+1) & INDEX_MASK;// Increment "tail" variable (mod BUF_SIZE)
        if (rxb.count < BUF_SIZE){           // If reception buffer is not full (e.g. count < BUF_SIZE) then
            rxb.count++;                       // increment "count" variable
        }else{                                  // Else
            rxb.head = (rxb.head+1) & INDEX_MASK;    // increment "head" variable (discard oldest character)
        }
        
        IFS1bits.U2RXIF = 0; // reset UART2 RX interrupt flag
    }
}

void comDrv_config(int baudRate, char parity, int stop){
    U2BRG = ((20000000 + 8 * baudRate) / (16 * baudRate)) - 1;
    U2MODEbits.BRGH = 0;  // divisor de 16  = 0 ;   divisor de 4 = 1;
    
    U2MODEbits.PDSEL = parity;  // 11 = 9-bit data, no parity  ; 10 = 8-bit data, odd parity  ;  01 = 8-bit data, even parity  ; 00 = 8-bit data, no parity
    U2MODEbits.STSEL = stop;    // 1 = 2 Stop bits ; 0 = 1 Stop bit

    U2STAbits.UTXEN = 1;  // transmitter
    U2STAbits.URXEN = 1;  // receiver

    // 4 - Enable interrupts
    U2STAbits.UTXSEL = 00;     // interrupts of transmitter -- PIC32 manual reference uart sect 21 pag 7
    U2STAbits.URXISEL = 00;    // interrupts of receiver -- PIC32 manual reference uart sect 21 pag 8

    IEC1bits.U2RXIE = 1;  // Enable U2RXIE interrupts
    //IEC1bits.U2TXIE = 1;  // Enable U2TXIE interrupts
    //IEC1bits.U2EIE = 1;  // Enable U2EIE interrupts dos erros

    IFS1bits.U2RXIF = 0; // clear flag receiver
    //IFS1bits.U2TXIF = 0; // clear flag transmiter
    //IFS1bits.U2EIF = 0; // clear flag error

    IPC8bits.U2IP=2;  // priority

    // 5 – Enable UART2 (see register U1MODE)
    DisableUart2TxInterrupt();
    //DisableUart2RxInterrupt();

    U2MODEbits.ON = 1;
}

char comDrv_getc(char *pchar){
    if(rxb.count == 0){// Test "count" variable (reception buffer) and return FALSE
        return 0;
    }// if it is zero

    DisableUart2RxInterrupt();      // Begin of critical section
    *pchar = rxb.data[rxb.head];   // Copy character pointed by "head" to *pchar
    rxb.count--;                    // Decrement "count" variable
    rxb.head= (rxb.head +1) & INDEX_MASK; // Increment "head" variable (mod BUF_SIZE)
    EnableUart2RxInterrupt(); // End of critical section
    return 1;
 } 
