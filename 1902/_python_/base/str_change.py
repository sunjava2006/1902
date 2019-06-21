a = input('输入一个文件名：\n')
b = input('再输入一个文件名：\n')

adotat = a.rfind('.')
bdotat = b.rfind('.')

aprefex = a[0: adotat]
asurfex = a[adotat: ]

bprefex = b[0: bdotat]
bsurfex = b[bdotat:]

print(aprefex + bsurfex)
print(bprefex + asurfex)



