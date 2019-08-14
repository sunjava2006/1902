str = 'china is my country.'

# print(str.capitalize())
# print(str.center(50, '#'))
# print(str.count('i', 3))
# data = str.encode('utf-8')
# print(data)
# print(data.decode('utf-8'))
# print(str.startswith('i'))
# print(str.endswith('.'))
# print('I\tlike\tpython.'.expandtabs(4))
# print(str.find('i',10,40))
# try:
#     print(str.index('i', 0))
# except Exception as ex:
#     print(ex)
# print('helloworld'.isalpha())
# print(str.islower())
# print(str.title().istitle())

# li = str.split()
# print(li)
# print(','.join(li))

# print("Hello\nworld\r\n!".splitlines(True))
# print("Hello\nworld\r\n!".splitlines())
# print("Hello\nworld\r\n!".split('\n'))

# print(len(str))

chars =   'abcdefghijklmnopqrstuvwxyz '
targets = '0123456789~!@#$%^&*()_+[]|?'
tab = str.maketrans(chars, targets)
print(tab)


msg = 'i like python'

mi = msg.translate(tab)
print('密文：', mi)

tab2 = str.maketrans(targets, chars)
print('解密：', mi.translate(tab2))

print('I like Python'.swapcase())
