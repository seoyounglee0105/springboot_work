package ch01;

import java.util.Timer;
import java.util.TimerTask;

public class MainTest1 {

	public static void main(String[] args) {
		
		// 옵저버 패턴 설계 (콜백 메서드)
		Button button = new Button("button1");
									// 익명 구현 클래스
		button.setIButtonListener(new IButtonListener() {
			
			@Override
			public void clickEvent(String event) {
				// 하고 싶은 동작/알고리즘을 여기서 구현
				System.out.println("콜백 들어왔어 ! " + event);
			}
			
		});
		// 시간이 되면 알람이 울리는 것처럼
		button.click("야 집에 가");
		
	}
	
	
}
