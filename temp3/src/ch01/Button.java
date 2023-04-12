package ch01;

// 옵저버 패턴 (콜백 메서드)
// 호출이 되면 돌아감
// Swing에서 사용했던 이벤트 리스너도 옵저버 패턴으로 구현되어 있던 것!

/*
 * 1. 인터페이스가 필요함
 * 2. 인터페이스를 컴포지션 관계(포함 관계)로 선언함
 * 3. 인터페이스의 구현 클래스를 받을 setter 메서드를 만들어줌
 */

// 장점 : 구현한 기능은 필요에 따라 그때그때 가져와서 사용할 수 있게 됨

public class Button {

	private IButtonListener iButtonListener;
	
	// setter
	public void setIButtonListener(IButtonListener iButtonListener) {
		this.iButtonListener = iButtonListener;
	}
	
	// 이벤트 메서드
	public void click(String message) {
		// setter 메서드로 인터페이스가 세팅되지 않았다면 이벤트 작동 X
		if (iButtonListener != null) {
			this.iButtonListener.clickEvent(message);
		}
	}
	
}
