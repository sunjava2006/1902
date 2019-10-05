name = 'python'

def like():
    global name
    name = 'java'
    print(name)
    def xx():
        global name
        name = "js"
        return name
    return xx

f = like()
n = f()
print(n)

print(name)