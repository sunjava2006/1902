import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.setblocking(False)
s.settimeout(0.5)
s.bind(('127.0.0.1', 8888))
s.listen()
while True:
    try:
        cs, address = s.accept() # 阻塞的方法，直到有一个连接，才返回。
        print('*' * 50)
        print('address : ', address)
        data=''.encode('utf-8')
        try:
            while True:
                d = cs.recv(100)
                print(d)
                data = data+d
        finally:   
            print('finally*'*50)
            print('data: ', data.decode('utf-8'))

        res = """
        HTTP/1.1 302 REDIRECT
        Location:http://www.sina.com.cn

        <H1>hello</h1>
        """
        cs.sendall(res.encode('utf-8'))
    except Exception as ex:
        print(ex)

print('----------------------------------')
cs.close()
s.close()