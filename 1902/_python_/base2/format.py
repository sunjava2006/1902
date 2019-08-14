name = 'Wang' #input('输入你的名字：')
age = 20  #input('输入你的年龄：')
nextage = int(age)+1

# print('你的名字是' + name +',你明年就'+ str(nextage) + '岁了。')
# print('你的名字是',name, ',你明年就', nextage, '岁了。', sep='')
s = '你的名字是%8s,你明年就%4d岁了。'%(name, nextage)
print(s, 'PI=%017.9f'%3.14159265)


