package ch02;

public class MainTest1 {

	public static void main(String[] args) {
		
		// 중간 클래스 만들어 둔 상태
		String url = "www.naver.com/books?id=100";
		
		// IEncoder 생성자 타입 -> 의존 주입받을 수 있도록 설계
		// Base64Encoder  <- IEncoder로 볼 수 있음
		// UrlEncoder <- IEncoder로 볼 수 있음
		
		// 하고 싶은 인코더 클래스를 주입(DI)만 하면 그 구현 클래스에 맞게 기능을 처리할 수 있음
		Encoder encoder = new Encoder(new UrlEncoder());
		String result1 = encoder.encode(url);
		System.out.println("result1 : " + result1);
		
		// setter 메서드를 활용해서, 우리가 사용하고 싶은 메서드를 전략적으로 선택해서 사용 가능
		encoder.setiEncoder(new Base64Encoder());
		System.out.println(encoder.encode("반가워"));
		
	}

}
