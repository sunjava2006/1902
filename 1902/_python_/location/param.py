from flask import request, Flask, render_template
import os

os.path.abspath('.')

app = Flask(__name__)

def notfound():
    return "<h1>not found</h1>"

@app.route('/info/', methods=['GET'])
def info():

    # usr = request.values.get('usr')
    # age = request.values.get('age')
    usr = request.args.get('usr')
    age = request.args.get('age')
    return {'usr':usr, 'age':age}

@app.route('/info/', methods=['POST'])
def infopost():

    # usr = request.values.get('usr')
    # age = request.values.get('age')
    usr = request.form.get('usr')
    age = request.form.get('age')
    return {'usr':usr, 'age':age}

@app.route('/photo/', methods=['POST'])
def photo():
    usr = request.values['usr']
    age = request.values['age']
    photo = request.files['photo']
    print('__file__', __file__)
    currfile=__file__ # 取当前文件的名字

    
    name = photo.filename #取上传文件名
    path = os.path.dirname(currfile) #取当前文件目录的绝对路径
    path = os.path.join(path,'static', name) # 用所有参数，生成一个新的路径
    photo.save(path) # 保存上传的文件
    return {"user":usr, "age":age, "photo":name}


@app.route('/a')
def a():
    li=['china','japan','usa']
    return render_template('/a.html', name='小张', age=20, li=li)


if __name__ == "__main__":
    app.run(debug=True)