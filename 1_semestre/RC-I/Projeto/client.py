import psutil
import socket

ip_addr = "127.0.0.1"   
tcp_port = 2002

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#print(client)
client.connect((ip_addr, tcp_port))
#print(client)
while True:
	sendv="RAM(%)---> "+ str(psutil.virtual_memory()[2])+ "\nCPU(%)---> "+ str(psutil.cpu_percent(2))#2 sec wait
	client.send(bytes(sendv,"utf-8"))
    	
    
