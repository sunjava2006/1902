def fib():
    a, b = 1, 1
    while b <100:
        yield a
        b += a
        a = b-a 


f = fib()

print(f)
for i in f:
    print(i ,end=",")
    if i%5==0:
        print()
print('*'*50)
print(next((fib())))

