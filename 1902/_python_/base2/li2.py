li = [10,20,30,40,50]
li += [60]
# print(li)

# print(li[0], li)
# print(li.pop(), li)
# li.remove(20)
# print(li)

# for i in li:
#     print(i)

itor = iter(li)

for i in range(0,len(li)):
    print(next(itor))



for i in "hello":
    print(i)