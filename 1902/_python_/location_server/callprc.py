import cx_Oracle as orl
import os
os.environ['NLS_LANG'] = 'SIMPLIFIED CHINESE_CHINA.UTF8'  

# try:
# conn = orl.connect('test/test@127.0.0.1/XE')
'''
创建数据库连接池。最小1条连接，最大50条连接，每次增长一条连接。
'''
pool = orl.SessionPool('test','test','127.0.0.1/XE',min=1,max=50,increment=1)
conn = pool.acquire() # 获取一条连接。


cur = conn.cursor()
idd = cur.var(int)
idd.setvalue(0,20)
name = cur.var(str)
cur.callproc('p_get_kind',[idd, name])
print(name.getvalue())
conn.commit()
# except Exception as ex:
    # if conn:
    #     conn.rollback()
    # print(ex)
# finally:
if cur:
        cur.close()
if conn:
    pool.release(conn) # 将连接释放回连接池中
        # conn.close()
pool.close()