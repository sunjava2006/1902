for i in range(1, 10):
    for j in range(1, i+1):
        print('{0:d}*{1:d}={2:d}'.format(j, i, j*i), end="\t")
    print()

print('*'*50)

for i in range(9, 0, -1):
    for j in range(1, i+1, 1):
        print('{:d}*{:d}={:d}'.format(j, i, j*i),end='\t')
    print()


