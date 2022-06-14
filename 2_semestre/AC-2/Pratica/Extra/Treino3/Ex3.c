#include <detpic32.h>

void caseP();
void caseT();
void putstr(char *s);
void putc(char byte);

void configureAll();


int main(void){	

	configureAll();
	
	EnableInterrupts();
	
	while(1);
			
	return 0;	
	
}

void _int_(32) isr_uart2 (void){
	if(IFS1bits.U2RXIF == 1){
		char byte = U2RXREG;
		if(byte == 'p')
			caseP();
		if(byte == 't')
			caseT();

		IFS1bits.U2RXIF = 0;	
	}
	
	
}

void configureAll(){

	//Port
	TRISB = TRISB | 0x000F;
	TRISE = TRISE & 0xFFEF;
	LATE = (LATE & 0xFFEF) | 0x0010;
	
	U2BRG = 129;				//(20000000 / (16 * 9600)) - 1
	U2MODEbits.BRGH = 0;		//16 because yes
	U2MODEbits.PDSEL = 2;		//8 data odd parity -> 10
	U2MODEbits.STSEL = 1;		//2 STOP bits
	
	U2STAbits.UTXEN = 1;
	U2STAbits.URXEN = 1;
	
	U2MODEbits.ON = 1;	
	
	
	IEC1bits.U2RXIE = 1;
	IEC1bits.U2TXIE = 0;
	
	IPC8bits.U2IP = 2;
	IFS1bits.U2RXIF = 0;
	
	U2STAbits.URXISEL = 0;

	
}

void caseP(){
	putstr("DipSwitch=");
	putc(PORTBbits.RB3 + 0x30);
	putc((PORTBbits.RB2) + 0x30);
	putc((PORTBbits.RB1) + 0x30);
	putc((PORTBbits.RB0) + 0x30);

}

void caseT(){
	LATE = LATE ^ 0x0010;
}





void putstr(char *s){
	while(*s != '\0'){
		putc(*s);
		s++;
	}
}
void putc(char byte){
	while(U2STAbits.UTXBF == 1);
			U2TXREG = byte;
}


