name = input('输入你的名字:\n')
print(name)

age = input('输入你的年龄:\n')

age = int(age)

s = '你的名字是%s, 年龄是%d' %(name, age)

s2 = '你的名字是：{:s}, 你明年就{:d}岁了。'.format(name, age+1)


print(s, s2, sep='\n')