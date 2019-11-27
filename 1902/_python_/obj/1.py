class People():
    def __init__(self, name):
        self.name = name

    def work(self):
        print(self.name + ' is working now')



class Student(People):
    def __init__(self, sid, name):
        self.sid = sid
        super().__init__(name)
    




stu = Student(100, 'FangFang')

print(stu.name)
stu.work();




