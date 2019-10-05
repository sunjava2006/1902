# coding:utf-8
import cx_Oracle as orl
import os
os.environ['NLS_LANG'] = 'SIMPLIFIED CHINESE_CHINA.UTF8'  
#或者os.environ['NLS_LANG'] = 'AMERICAN_AMERICA.AL32UTF8'

def get_id(type_name):
    '''
    根据查询类型名，查询出类型ID
    '''
    data = (None,)
    try:
        # 1、连接到数据库，获取连接
        conn = orl.connect(user='location', password='location', dsn='127.0.0.1/xe')
        print(conn)

        # 2、发送SQL语句
        sql='select id from types where type_name=:name'
        cur = conn.cursor()
        cur.execute(sql,name=type_name)

        # 3、获取并处理返回数据
        data = cur.fetchone()
        conn.commit()
    except Exception as ex:  
        conn.rollback()
    finally:
        # 4、释放资源，关闭连接
        if cur:
            cur.close()
        if conn:
            conn.close()

    # 5、返回查询结果
    return data[0]



def query(latitude, longitude, key):
    data = None
    try:
        offset = 0.001 # 100米以内
        conn = orl.connect(user='location', password="location", dsn='127.0.0.1/xe')
        cur = conn.cursor()
        if key.endswith('以内'):
            if key == '500米以内':
                offset *= 5
            elif key =='1公里以内':
                offset *= 10
            elif key =='2公里以内':
                offset *= 20
            elif key =='3公里以内':
                offset *= 30
            elif key == '5公里以内':
                offset *= 50   
            sql = 'select * from locations where latitude BETWEEN :latmin and :latmax \
                and longitude BETWEEN :lonmin and :lonmax'
            cur.execute(sql, latmin=latitude-offset, latmax=latitude+offset, lonmin=longitude-offset, lonmax=longitude+offset)
        else:
            offset = 0.01 
            sql = 'select * from locations where latitude BETWEEN :latmin and :latmax \
                   and longitude BETWEEN :lonmin and :lonmax \
                   and type_id=(select id from types where type_name=:typeName) '
            cur.execute(sql, latmin=latitude-offset, latmax=latitude+offset, lonmin=longitude-offset, lonmax=longitude+offset, typeName=key)                   
        data = cur.fetchall()
        conn.commit()
    except Exception as ex:
        conn.rollback()
    finally:
        if cur:
            cur.close()
        if conn:
            conn.close()
    return data





