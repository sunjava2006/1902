class Test():
    def __init__(self, name):
        self.name = name

    def __enter__(self):
        print('enter')
        return self   # __enter__方法要返回self对象。
    
    def __exit__(self, ex_type, ex_value, ex_trackback):
        print('exit')

    def prt(self):
        print(self.name)
    

with Test("wang") as t:
    t.prt()