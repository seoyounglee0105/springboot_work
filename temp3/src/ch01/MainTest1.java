package ch01;

public class MainTest1 {

	public static void main(String[] args) {
		
		// 옵저버 패턴 설계 (콜백 메서드)
		Button button = new Button();
									// 익명 구현 클래스
		button.setIButtonListener(new IButtonListener() {
			
			@Override
			public void clickEvent(String event) {
				// 하고 싶은 동작/알고리즘을 여기서 구현
				System.out.println("콜백 ! " + event);
			}
			
		});
		
		// 필요할 때마다 click 메서드를 통해 기능 사용
		button.click("클릭");
		
	}
	
	
}
