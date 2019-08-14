li1 = [i for i in range(1,11)]
print(li1)

# 列表中的数是3与li1中元素的积
li2 = [i*3 for i in li1]
print(li2)



# 列表中元素是li1、li2对应元素的和
li3 = [li1[i]+li2[i] for i in range(0,len(li1)) ]
print(li3)

a = [1,2,3]
b = [4,5,6]
#[[1,4],[2,5],[3,6]] 

li3 = [[a[i],b[i]] for i in range(0,len(a)) ]

#====================================
ii=[1,2,3,4]
lis = [h*100+m*10+l for h in ii for m in ii for l in ii]
print(lis)

print('*'*58)

for j in range(len(lis)-1, -1, -1):
    i = lis[j]
    h = i//100
    m = i%100//10
    l = i%10
    if h==m or h==l or m==l:
        lis.remove(i)

print(lis)      
print(len(lis))  