package ch02;

// 중간 클래스
public class Encoder {
	
	private IEncoder iEncoder;
	
	// DI 의존 주입 설정 + 디자인 패턴 (전략 패턴) <- 중요
	public Encoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}
	
	// setter 메서드까지 만들어야 전략 패턴 완성
	public void setiEncoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}

	// 기능            // 변경할 메세지
	public String encode(String message) {
		return iEncoder.encode(message);
	}
	
}
