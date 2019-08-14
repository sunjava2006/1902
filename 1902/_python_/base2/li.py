li = list()
li.append('hi')
li.append(100)
li.append(3.14)
li.insert(0,10)
li[0]='china'
li.insert(10, 1000)
print(li)

i=0
while i<len(li):
    print(i, li[i])
    i+=1

for i in li:
    print(i)

