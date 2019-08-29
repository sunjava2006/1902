from flask import Flask, render_template, request, session, Response, redirect
import db 


app = Flask(__name__)

@app.route('/', methods=['GET'])
def index():
    return render_template('/login.html')


@app.route('/main')
def main():
    return render_template('/main.html')


@app.route('/login', methods=['POST'])
def login():
    print('login-----------')
    userName = request.values.get('userName')
    pwd = request.values.get('pwd')
    data = db.login(userName, pwd)
    if data:
        return redirect('/main')
    else:
        return render_template('/login.html', msg='登录失败，重试。')



if __name__ == "__main__":
    app.run(debug=True)