def sum(a=0, b=0, *args):
    c = a+b
    for i in args:
        c += i
    return c  # 表示，函数返回的结果。

def minus(a, b):
    return a - b

def pr(a,  *ar, **arg):
    for i in ar:
        print(i)
    print('*'*20)
    for i in arg.items():
        print(i[0], ':', i[1])



pr(10,11,12, name="ch",true="hi",o="ok")

# print(sum(1,2,3,4,5,6))

# print(minus(b=50, a=100))