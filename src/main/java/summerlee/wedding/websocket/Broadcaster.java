package summerlee.wedding.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Broadcaster implements Runnable {

	// 弹幕队列
	private static Queue<String> danmuQueue = new LinkedBlockingQueue<>();
	// 接收者队列
	private static Map<String,WeddingSocket> sockets = new ConcurrentHashMap<>();
	
	private boolean isRun;
	
	public Broadcaster() {
		isRun = true;
		// 启动广播
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (isRun) {
			String danmu = danmuQueue.poll();
			System.out.println("提取到的弹幕：" + danmu);
			if(StringUtils.isNotBlank(danmu)){
				// 依次发送
				for(WeddingSocket socket : sockets.values()){
					socket.send("提取到的弹幕：" + danmu);
				}
			}
		}
	}
	
	@PreDestroy
	public void destroy() {
		this.isRun = false;
	}
	
	public static void addDanmu(String danmu) {
		danmuQueue.offer(danmu);
	}
	
	public static void addSocket(String socketId, WeddingSocket socket) {
		sockets.put(socketId, socket);
	}
	
	public static void removeSocket(String socketId) {
		sockets.remove(socketId);
	}
}