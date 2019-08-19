from flask import Flask ,jsonify


app = Flask(__name__)

@app.route('/')
def home():
    return "hello"

@app.route('/hi/<name>')
def hi(name):
    return 'hi:'+name.upper()

@app.route('/location/<latitude>/<longitude>/<key>')
def location(latitude, longitude, key):
    return jsonify({'latitude':latitude, 'longitude':longitude,\
                    'key':key, 'name':'便利蜂'})#,\
           #{"responseContent":"application/json;charset=utf-8"}


if __name__ == "__main__":
    app.run(debug=True)

