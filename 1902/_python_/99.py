for i in range(1,10):
    for j in range(1, i+1):
        print('%d*%d=%d'%(j, i, j*i), end='\t')
    print()

for i in range(9,0,-1):
    for j in range(1, i+1):
        print('%d*%d=%d'%(j, i, j*i), end='\t')
    print()