def sxh():
    for i in range(100,1000):
        h = i//100
        m = i%100//10
        l = i%10
        if h**3+m**3+l**3 == i:
            yield i

s = sxh()
for i in s:
    print(i , end=",")
