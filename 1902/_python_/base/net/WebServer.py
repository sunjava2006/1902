import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

s.bind(('127.0.0.1', 9990))
s.listen()

c, addr = s.accept()
print(s)
print(addr)

d = c.recv(2551)
print(d.decode("utf-8"))


s.close()
