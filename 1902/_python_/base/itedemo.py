# 生成器，可以生成一个迭代器。
# 生成器，含有yield关键字的函数，称为生成器（生成器函数）

def seq(a,b, step=1):
    for i in range(a,b,step):
        yield i

s = seq(10,15, 2)
# for i in s:
#     print(i)

def fib(max):
    a = 1
    b = 1
    while a<max :
        yield a
        b = a+b
        a = b-a

# for i in fib(300):
#     print(i, end=", ")

def sxh():
    for i in range(100, 1000):
        h = i//100
        m = i%100//10
        l = i%10
        if pow(h,3)+m**3+pow(l,3) == i:
            yield i

print(type(sxh()))

for i in  sxh():
    print(i)

