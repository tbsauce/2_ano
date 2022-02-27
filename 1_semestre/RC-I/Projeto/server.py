
import socket
import threading
import sys
import signal

def signal_handler(sig, frame):
    print('\nDone!')
    sys.exit(0)


signal.signal(signal.SIGINT, signal_handler)
#key instruction CTRl+C to stop
def handle_client_connection(client,address):
    while True:
        
        string=client.recv(1024)
        string=string.decode("utf-8")
        print(f"\nIpv4 is {address[0]} & port is {address[1]} ")
        print(string)
    client.close()

if __name__ == "__main__":
    ip="200.134.144.133"
    port=2002


    print('If u Want to Exit press CRTL+C')
    server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    server.bind((ip,port))
    server.listen(5)
    print(f"Listening on {ip} & with port {port}")

    while True:
        client, address = server.accept()
        client_handler = threading.Thread(target=handle_client_connection,args=(client,address),daemon=True)
        client_handler.start()
    


