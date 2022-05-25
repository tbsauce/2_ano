#include <detpic32.h>

void configureAll();
void send2displays(unsigned char value);
unsigned char toBcd(unsigned char value);

volatile int voltage = 0;       // Global variable
static int num = 8;

int main(void) {
    configureAll(); // Function to configure all (digital I/O, analog
                    // input, A/D module, timers T1 and T3, interrupts)
    // Reset AD1IF, T1IF and T3IF flags
    IFS1bits.AD1IF = 0;        
    IFS0bits.T1IF = 0;  
    IFS0bits.T3IF = 0;   

    EnableInterrupts(); // Global Interrupt Enable
    while(1);
    return 0;
} 

void configureAll() {
    // Timer1
    T1CONbits.TCKPS = 6;    // 1:64 prescaler (i.e Fout_presc = 625 KHz)
    PR1 = 62499;            // Fout = 20MHz / (64 * (62499 + 1)) = 5 Hz
    TMR1 = 0;               // Reset timer T2 count register
    T1CONbits.TON = 1;      // Enable timer T2 (must be the last command of the
                            // timer configuration sequence)

    // Timer3
    T3CONbits.TCKPS = 2;        // 1:4 prescaler Fout_presc = 5Mhz;
    PR3 = 49999;                // Fout = 20Mhz / 4(49999+1) = 100Hz
    TMR3 = 0;                   // Reset timer T3 count register
    T3CONbits.TON = 1;          // Enable timer T3

    // Displays
    TRISB = TRISB & 0x80FF;     // RB14 to RB8 as output
    TRISD = TRISD & 0xFF9F;     // Displays high/low as output

    // ADC
    TRISBbits.TRISB4 = 1; // RBx digital output disconnected
    AD1PCFGbits.PCFG4= 0; // RBx configured as analog input
    AD1CON1bits.SSRC = 7; // Conversion trigger selection bits: in this
                            // mode an internal counter ends sampling and
                            // starts conversion
    AD1CON1bits.CLRASAM = 1; // Stop conversions when the 1st A/D converter
     // interrupt is generated. At the same time,
     // hardware clears the ASAM bit
    AD1CON3bits.SAMC = 16; // Sample time is 16 TAD (TAD = 100 ns)
    AD1CON2bits.SMPI = num-1; // Interrupt is generated after XX samples
                            // (replace XX by the desired number of
                            // consecutive samples)
    AD1CHSbits.CH0SA = 4; // replace x by the desired input
     // analog channel (0 to 15)
    AD1CON1bits.ON = 1; // Enable A/D converter
     // This must the last command of the A/D
     // configuration sequence 

    // Enable interrupts ADC, T1, T3
    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts
    IEC1bits.AD1IE = 1;         // Enable A/D interrupts

    IPC1bits.T1IP = 1;          // Interrupt priority 1
    IEC0bits.T1IE = 1;          // Enable timer T1 interrupts

    IPC3bits.T3IP = 3;          // Interrupt priority 2
    IEC0bits.T3IE = 1;          // Enable timer T3 interrupts
}

void _int_(4) isr_T1(void) {
    // Start A/D conversion
    AD1CON1bits.ASAM = 1;           // Start conversion
    // Reset T1IF flag
    IFS0bits.T1IF = 0;
} 

void _int_(12) isr_T3(void) {
    // Send "voltage" value to displays (global variable)
    send2displays(voltage);
    // Reset T3IF flag
    IFS0bits.T3IF = 0;
} 

void _int_(27) isr_adc(void) {
    int average = 0;
    // Calculate buffer average (8 samples)
    int *p = (int *) (&ADC1BUF0);
    int i;
        for( i = 0; i < 16; i++) {
            average +=  p[i*4];
    }
    voltage = average / num;
    // Calculate voltage amplitude
    voltage = toBcd((voltage * 33+ 511) / 1023);
    // Reset AD1IF flag
    IFS1bits.AD1IF = 0;
} 


//funcao send2displays
void send2displays(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
                                    //   0     1     2     3     4     5     6     7     8     9     A     B     C     D     E     F   
    static char displayFlag = 0; // static variable: doesn't loose its
                                // value between calls to function
    unsigned char digit_low = value & 0x0F;
    unsigned char digit_high = value >> 4;
    // if "displayFlag" is 0 then send digit_low to display_low
    if(!displayFlag){
        LATD = (LATD & 0xFF9F) | 0x0020;
        digit_low = display7Scodes[digit_low];
        LATB = (LATB & 0x80FF ) | digit_low << 8;
    }
    // else send digit_high to didplay_high
    else{
        LATD = (LATD & 0xFF9F) | 0x0040;
        digit_high = display7Scodes[digit_high];
        LATB = (LATB & 0x80FF ) | digit_high << 8;
    }
    // toggle "displayFlag" variable
    displayFlag = !displayFlag;
}

unsigned char toBcd(unsigned char value)
 {
	return ((value / 10) << 4) + (value % 10);
 } 


 