from aip import AipImageClassify


'''你的 APPID AK SK'''
APP_ID = '16794181'
API_KEY = 'ZfRjnGxm8Uqdfqs3YzL9XGy8'
SECRET_KEY = '1FQUf9D6qRYcd54ZEE0xKAVXYClKoXOb'

client = AipImageClassify(APP_ID, API_KEY, SECRET_KEY)

def get_file_content(filePath):
    with open(filePath, 'rb') as fp:
        return fp.read()


if __name__ == "__main__":
    filePath = input('输入图片的路径：')
    image = get_file_content(filePath)
    data = client.advancedGeneral(image)
    if data:
        print(data)
        result1 = data.get('result')[0]
        kind = result1.get('root')
        msg = result1.get('keyword')
        print(kind, msg)

        if '汽车' in kind:
            data = client.carDetect(image)
            if data:
                print(data)
                print('*'*50)
                car1 = data.get('result')[0]
                carname = car1.get('name')
                color = data.get('color_result')
                print(carname, color)
 

    


