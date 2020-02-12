package com.wangrui.mulitithread.base;

public class StopThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {

				while (true) {
					System.out.println("---------------------");
					// 可以判断是否被打断。检测是否被设置了中断标记
					boolean flag = this.isInterrupted(); // 不会清除中断标记
					//Thread.interrupted(); // 会清除中断标记
					if(flag) {
						//----------做一些资源的清理工作。
						// 从容的退出线程。
						break;
					}

				}

			}
		};
		t.start();

		// 主线程等子线程，运行1000毫秒
		Thread.sleep(1000);
//		t.stop();
		t.interrupt();// 打断线程，仅是设置了一个中断标记。表示已经打断了。

	}
}
