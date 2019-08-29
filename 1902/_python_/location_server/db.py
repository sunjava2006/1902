import cx_Oracle as orl
import os
os.environ['NLS_LANG'] = 'SIMPLIFIED CHINESE_CHINA.UTF8'  

def getconn():
    dns = getdns()
    return orl.connect(dns)


def login(user_name, pwd):
    sql = 'select * from users where user_name=:user_name and pwd=:pwd and account_state=1'
    return select(sql, one=False, user_name=user_name, pwd=pwd)


def select(sql, one=True, **arg):
    data = None
    try:
        conn = getconn()
        cur = conn.cursor()
        cur.execute(sql, arg)
        if one:
            data = cur.fetchone()
        else:
            data = cur.fetchall()
        conn.commit()
    except Exception as identifier:
        if conn:
            conn.rollback()
        print(identifier)
    finally:
        if cur:
            cur.close()
        if conn:
            conn.close()
    return data



def sum(a, b, *c, **d):
    print(d)
    result = 0
    result += (a+b)
    for i in c:
        result += i
    for i in d.keys():
        result += d.get(i)
    return result




def getdns():
    path = os.path.dirname(__file__)
    ini = os.path.join(path, 'db.ini')
    file = open(ini, 'r')
    data = file.readline()
    at = data.find('=')
    url= data[at+1::]
    file.close()
    return url

if __name__=='__main__':
    print(getdns())