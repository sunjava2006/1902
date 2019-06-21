'''
题目：有四个数字：1、2、3、4，能组成多少个互不相同且无重复数字的三位数？各是多少？
程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。
'''

r = range(1, 5)
li = [a*100+b*10+c for a in r for b in r for c in r]

for x in range(len(li)-1,-1,-1):
    i = li[x]
    h = i//100
    m = i//10%10
    l = i%10

    if h==m or h==l or m==l:
        li.remove(i)

print(li)

print('有{:d}个数'.format(len(li)))

print('*'*50)

# 方法2

l = []
for a in r:
    for b in r:
        for c in r:
            if a!=b and a!=c and b!=c:
                l.append(a*100+b*10+c)

print(l)
print('有%d个数' %len(l))
