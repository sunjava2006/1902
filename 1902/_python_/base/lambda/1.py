import random
li = list('china')
# print(li)
li.sort(key=lambda a: random.randint(0,10)-random.randint(0,10) )

print(li)


