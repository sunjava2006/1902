li = [30, 10, 20, 2, 1, 6, 8, 23, 9, 87, 56, 7]

for i in range(0,len(li)-1):
    for j in range(0,len(li)-1-i):
        if li[j] > li[j+1]:
            t = li[j]
            li[j] = li[j+1]
            li[j+1] = t

print(li)            

        
