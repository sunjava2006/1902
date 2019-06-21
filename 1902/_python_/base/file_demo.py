import os
'''
不指定字符编码的方式写文件，读取文件内容。

f = open('d:\\a.txt', 'w')
f.write('hello world.你好。')
f.close()

f = open('d:\\b.txt', 'r')
data = f.read()
print(data)
f.close()
'''

'''
以指定的编码写文件，读取文件内容
'''
fd = os.open('d:\\b.txt', os.O_RDWR | 256)
os.write(fd, 'hello world. 你好'.encode('gbk'))
os.close(fd)


fd = os.open('d:\\b.txt', os.O_RDONLY)
data = os.read(fd, 1000)
s = data.decode('gbk')
print(s)
os.close(fd)
