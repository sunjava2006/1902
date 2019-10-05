import random # 导入一个模块 random

score = random.randint(0, 100) # 产生0-100之间的随机整数
print("score:", score)

# if score >= 60 :
#     print('及格了')
# else:
#     print('不及格')

if score >=90:
    print('优')
elif score >= 80:
    print('良')
elif score >= 70:
    print('中')
elif score >=60:
    print('及格')
else:
    print('差')

