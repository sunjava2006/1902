import cv2 as cv

#创建一个视频采集，控制摄像头0：本地摄像头，1：外接摄像头
capture = cv.VideoCapture(0)

#定义编码方式，创建一个写入对象。
fourcc = cv.VideoWriter_fourcc('*.mjpg')
