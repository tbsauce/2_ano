#include <detpic32.h>

//NOTAS IMPORTANTES
//
// o valor do PWM estara sempre em PORTDbits.RDx; | (T1)OC1=RD0 | (T2)OC2=RD1 | (T3)OC3=RD2
// logo devmos igualar por exemplo
// while(1){LATEbits.LATE0 = PORTDbits.RDx;}; na main para ligar o led RE0 com x de duty cycle
//
// AD1CON1bits.ASAM  = 1; //Start A/D conversion
	
//  TP04    ---------------------------------------
//    TRISx - Configura se é output[0]/input[1]
//    PORTx - Data na entrada [input]
//    LATx  - Data na saida [output]
//
//    TRISE = TRISE & 0xFFF0  #RE0-3 -> Saídas
//    TRISE = TRISE | 0x000F  #RE0-3 -> Entradas
//
//    LATE = LATE & 0xFFF0    #RE0-3 -> Output de dados
//    LATE = LATE | Data
//
//    PORT???

void delay(int ms) {
  for(; ms > 0; ms--) {
    resetCoreTimer();
    while(readCoreTimer() < 20000);
  }
}

//Função DisplaySetup:
//    LATB = (LATB & 0x80FF);
//    TRISB = (TRISB & 0x80FF);  
//    TRISDbits.TRISD5=0;
//    TRISDbits.TRISD6=0;

void send2displays(unsigned int value,unsigned int base){
	static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};							
	static char displayFlag = 0;	
	
	if( displayFlag == 0){	//display_low
        int tmp = value % base;
		LATDbits.LATD5 = 1;
		LATDbits.LATD6 = 0;		
		LATB = ( LATB & 0x80FF ) | (display7Scodes[tmp] << 8 );	
	}else{	// display_high
        int tmp = value / base;
		LATDbits.LATD5 = 0;
		LATDbits.LATD6 = 1;	
		LATB = ( LATB & 0x80FF ) | (display7Scodes[tmp] << 8 );
	}
	
	displayFlag = !displayFlag;// toggle "displayFlag"
}

//  TP05    ---------------------------------------
// AD1CON1bits.ASAM = 1; // Start conversion
//
// while( IFS1bits.AD1IF == 0 ); // Wait while conversion not done (AD1IF == 0)
//
// Output: ADC1BUF0 a ADC1BUFF

void configADC(int numSamples) {
  TRISBbits.TRISB4 = 1;	
  AD1PCFGbits.PCFG4 = 0;
  AD1CHSbits.CH0SA = 4;	
  AD1CON2bits.SMPI = numSamples - 1;
  AD1CON1bits.SSRC = 7;
  AD1CON1bits.CLRASAM = 1;
  AD1CON3bits.SAMC = 16;
  AD1CON1bits.ON = 1;
}

//  TP06    ---------------------------------------
//    *Setup:
//    //Usar PIC32MX7XX Family Data Sheet pg 74-76
//    IPCxbits.[interrupt source]IP = 1 a 6;// configure priority of interrupts 
//                                        //0- no interrupts, 7-max prio, n deve ser usado 
//    IFSxbits.[interrupt source]IF = 0;  // clear interrupt flag 
//    IECxbits.[interrupt source]IE = 1;  // enable interrupts
//
//    EnableInterrupts(); //Colocar na main sempre
//
//    // Interrupt Handler
//    void _int_(VECTOR) isr_adc(void) //Usar PIC32MX7XX Family Data Sheet pg 74-76
//    {
//        // ISR actions
//        IFSxbits.[interrupt source]IF = 0; // Reset interrupt flag
//    } 

void configIT_ADC(){ // Configure interrupts system
	IEC1bits.AD1IE = 1; // enable A/D interrputs  
	IPC6bits.AD1IP = 2; // configure priority of A/D interrupts 
	IFS1bits.AD1IF = 0; // clear A/D interrupt flag	
}

void _int_(27) isr_adc(void){
	int *p = (int *)(&ADC1BUF0);
	int i = 0;
	int soma = 0;
 	for(; i < 8; i++ ){ // pode nao ser 8 depende do nº de samples
 		soma = p[i*4] + soma;	
 	} 
	int media = soma/8; // pode nao ser 8 depende do nº de samples	
	voltage = (media*33)/1023;// volatile int voltage =0; // declarar la em cima

	IFS1bits.AD1IF = 0; // Reset AD1IF flag
}

//  TP07    ---------------------------------------
//    //Timer
//    x=1->Tipo A Prescalar: 1, 8, 64 ou 256
//    x=2,3,4,5->Tipo B Prescalar: 1, 2, 4, 8, 16, 32, 64 ou 256
//
//    Output: wait until IFSybits.TxIF == 1
//    or
//    use Interrupts (check TP06^^^)
//
//  o valor do PWM estara sempre em PORTDbits.RD0; logo devmos igualar por exemplo
//  while(1){LATEbits.LATE0 = PORTDbits.RD0;}; na main para ligar o led RE0 com x de duty cycle


void config_Tx(){
	// Kprescaler = (20 000 000)/((65535+1)*Fout);
	// Kprescaler -> escolher a constante + perto arredondada para cima
	// Fout_prescale= 20 000 000/Kprescaler;
	// PRx= (Fout_prescale/Fout)-1;

	// Configure Timer Tx
    TxCONbits.TCKPS = // Tipo A Prescalar: 1, 8, 64 ou 256
                      // Tipo B Prescalar: 1, 2, 4, 8, 16, 32, 64 ou 256
    PRx = // PRx                            
    TMRx = 0; // Reset timer Tx count register           
    TxCONbits.TON = 1;// Enable timer Tx (must be the last command of the timer configuration sequence) 
}

void configInterrupts_TimerTx(){
    IPCxbits.TxIP = 2; // interrupt priority
    IEC0bits.TxIE = 1; // Enable Tx interrupts
    IFS0bits.TxIF = 0; // clear interrupt flag	
}

void _int_(4,8,12) isr_Tx(void){ // T1=4 | T2=8 | T3=12  
	// do stufs

    // Reset TxIF flag consoante o Tx
    IFS0bits.TxIF=0;
}

//! /////////////////////////////////////////////////////////////////////////////////////
//IMPORTANTE/////////////////////////////////////////////////////////////////////////////
// o valor do PWM estara sempre em PORTDbits.RDx; | (T1)OC1=RD0 | (T2)OC2=RD1 | (T3)OC3=RD2
// logo devmos igualar por exemplo
// while(1){LATEbits.LATE0 = PORTDbits.RDx;}; na main para ligar o led RE0 com x de duty cycle
///////////////////////////////////////////////////////////////////////////////////////
void config_PWM(){
	OCxCONbits.OCM = 6; // PWM mode on OCx; fault pin disabled
    OCxCONbits.OCTSEL =a;// a=0 -> using T2, a=1 -> using T3
    OCxRS = b; // Ton constant -- pode ser apagado é dado pelo setPWM
    OCxCONbits.ON = 1; // Enable OC1 module
}

void setPWM(unsigned int dutyCycle){ // PWM do Timer3
    if(dutyCycle>=0 & dutyCycle<=100){ OCxRS = ((PRx+1)*dutyCycle)/100; }// para outros timers basta mudar o PRx
} 

int configUart(int baudRate,int parity, int stop){// Configure UART2:
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

    U2MODEbits.ON = 1;

}

void putc(char byte2send){
    while(U2STAbits.UTXBF==1);// wait while UTXBF == 1
    U2TXREG=byte2send;// Copy byte2send to the UxTXREG register
}


char getc(void){
    if(U2STAbits.OERR==1){ //Overrun Error
        U2STAbits.OERR=0;
    }

    while(U2STAbits.URXDA==0);
 
    if (U2STAbits.FERR || U2STAbits.PERR){
        char tmp = U2RXREG;
        return 0;
    }
    else
        return U2RXREG;
}

void puts(char *string){
    while (*string){
        putc(*string++);
    }
}

void _int_(32) isr_uart2(void){
    if(U2STAbits.OERR==1){
        U2STAbits.OERR=0;
        char tmp=U2RXREG;
    }

    if(U2STAbits.FERR || U2STAbits.PERR){
        // read UxRXREG (to discard the character) and return 0
        char tmp=U2RXREG;
    }

    if(IFS1bits.U2RXIF==1){
        putc(U2RXREG);
        IFS1bits.U2RXIF=0;
    }
} 

