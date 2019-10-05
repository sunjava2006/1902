li=[1,1]

while True:
    a = li[len(li)-1]
    b = li[len(li)-2]
    new = a+b
    if new >10000:
        break
    li.append(new)

print(li)