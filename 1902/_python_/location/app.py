from flask import Flask ,jsonify
from dao import query


app = Flask(__name__)

@app.route('/')
def home():
    return "hello"

@app.route('/hi/<name>')
def hi(name):
    return 'hi:'+name.upper()

@app.route('/location/<latitude>/<longitude>/<key>/')
def location(latitude, longitude, key):
    print('key', key)
    print("lat", latitude)
    print('long', longitude)
    data = query(float(latitude),float(longitude), key)
    print(data)
    return jsonify(data)


if __name__ == "__main__":
    app.run(debug=True)

