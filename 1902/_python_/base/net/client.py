import socket

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# socket.bind(('127.0.0.1', 9090))

socket.connect(('127.0.0.1', 9090))

socket.send("good morning.\n".encode('utf-8'))

socket.close()

