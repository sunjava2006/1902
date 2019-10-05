name = 'Wang'
age = 20
PI = 3.1415

s = '你的名字是{0},你今年{1:>8}岁了。\n{0}明年{3}岁。PI={2:.6f}'\
    .format(name, age, PI, age+1)
print(s)

str = ('''hello{}
hi
helo%s'''%' china').format(' XXX ')
print(str)

