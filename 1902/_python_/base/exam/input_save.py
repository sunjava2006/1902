import os
try:
    print('*'*100)
    print('输入你的文章内容。输入空行，表示结束。')
    print('*'*100)

    li=[]

    while True:
        msg = input(':')
        if  not msg: # 当用户输入为空字符串时，跳出死循环。
            break
        li.append(msg)

    fileName = input('输入要保存的文件名:\n')
    
    # split将用户输入的文件名，分割成目录和文件。目录赋值给dir, 文件赋值给f
    dir, f = os.path.split(fileName)
    if not os.path.exists(dir): #判断目录是否存在。当不存在时，创建这个目录。
        os.makedirs(dir)
    
    f = open(fileName, 'w')
    for i in li:
        f.write(i)
    f.close()
    print('文件保存完毕')
except:
    print('出错了')
