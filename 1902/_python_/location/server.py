import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(('127.0.0.1', 9000))
s.listen()

c, a = s.accept()
print(a)
data = c.recv(90000000)
print(data)
data = c.recv(90000000)
print(data)
data = c.recv(90000000)
print(data)

c.close()
s.close()

