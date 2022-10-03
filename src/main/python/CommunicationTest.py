'''
usr接收用户传来的内容
后端调用ComTest函数并将返回值传回到前端

'''

def ComTest(text):
    # print(text)
    if '你好' in text or '您好' in text:
        return '您好，请问有什么需要帮助的吗？'
    elif '你说的不对' in text:
        return '不好意思，您咨询的正在补充。'
    elif '感谢' in text or '谢谢' in text:
        return '不客气，欢迎咨再次询。'
    else:
        return '我不知道你在说什么。'