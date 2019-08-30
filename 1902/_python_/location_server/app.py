from flask import Flask, render_template, request, session, Response, redirect,jsonify
import db 
from datetime import timedelta
import random


app = Flask(__name__)

app.config['SECRET_KEY']='123456'   #设置为24位的字符,每次运行服务器都是不同的，所以服务器启动一次上次的session就清除。
app.config['PERMANENT_SESSION_LIFETIME']=timedelta(minutes=60) #设置session的保存时间。

@app.route('/', methods=['GET'])
def index():
    code = getcode()
    session['code']=code
    return render_template('/login.html', code=code)


@app.route('/main')
def main():
    userInfo = session.get('userInfo')
    if userInfo:
        return render_template('/main.html')
    else:
        return redirect('/')

@app.route('/type', methods=['GET'])
def typehtml():
    types = db.listtypes()
    return render_template('/type.html', types=types)


@app.route('/addtype', methods=['POST'])
def addtype():
    typ = request.values.get('type')
    parent = request.values.get('parent')
    if parent:
        array = parent.split(':')
        if array[1]:
            parent = int(array[1])
        else:
            parent = None
    else:
        parent = None
    # add to DB
    
        return jsonify({'result':"ok"})




@app.route('/login', methods=['POST'])
def login():
    try:
        print('login-----------')
        code = request.values.get('code')
        scode = session.get('code')
        if code == scode:
            userName = request.values.get('userName')
            pwd = request.values.get('pwd')
            data = db.login(userName, pwd)
            print('*'*30)
            print(data)
            print('*'*30)
            if data:
                session['userInfo']=data
                return redirect('/main')
            else:
                return render_template('/login.html', msg='登录失败，重试。')
        else:
            code = getcode()
            session['code']=code
            return render_template('/login.html', msg='校验码不正确。', code=code)
    except Exception as ex:
        print(ex)
        return 'error'
    

def getcode():
    ran = random.randint(10000,100000)  
    return str(ran)  


if __name__ == "__main__":
    app.run(debug=True)