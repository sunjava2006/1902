import cx_Oracle as orl
import os
os.environ['NLS_LANG'] = 'SIMPLIFIED CHINESE_CHINA.UTF8'  

def getconn():
    dns = getdns()
    return orl.connect(dns)


def login(user_name, pwd):
    sql = 'select * from users where user_name=:user_name and pwd=:pwd and account_state=1'
    return select(sql, one=False, user_name=user_name, pwd=pwd)


def listtypes():
    sql = 'select * from types'
    return select(sql, False)


def addType(typename, parentID):
    sql = 'insert into types(id,type_name, parent_id) \
          values(:id, :type_name, :parent_id)'
    id = select('select seq_types.nextval from dual')[0]

    if update(sql, id=id, type_name=typename, parent_id=parentID):
        return id, typename, parentID
    else:
        return None


def updateTypeName(typename, id):
    sql = '''update types set type_name=:name where id=:id'''
    return update(sql, name=typename, id=id)


def searchTypes(key):
    sql = 'select * from types where type_name=:key'
    return select(sql, False, key=key)

def allcount():
    sql = 'select count(*) from types'
    return select(sql)[0]

def listAllTypes(page, size):
    sql = 'SELECT * FROM \
          (select t.*, rownum ro from \
          (select * from types order by id desc) t where rownum <=:max) where ro >:min'
    return select(sql, False, max=page*size, min=(page-1)*size)


def delType(id):
    sql = 'delete from types where id=:id'
    return update(sql, id=id)

#--------------------------------------------------------------------
def update(sql, **arg):
    ok = True
    try:
        conn  = getconn()
        cur = conn.cursor()
        cur.execute(sql, arg)
        conn.commit()
    except Exception as ex:
        ok = False
        conn.rollback()
        print(ex)
    finally:
        if cur:
            cur.close()
        if conn:
            conn.close()
    return ok



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





# def sum(a, b, *c, **d):
#     print(d)
#     result = 0
#     result += (a+b)
#     for i in c:
#         result += i
#     for i in d.keys():
#         result += d.get(i)
#     return result




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
    # print(getdns())
    print(addType('type2', 2))