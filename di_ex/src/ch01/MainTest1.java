package ch01;

public class MainTest1 {

	public static void main(String[] args) {
		Base64Encoder base64Encoder = new Base64Encoder();
		String result = base64Encoder.encode("안녕");
		System.out.println("Base64 방식 : " + result);
		
		UrlEncoder urlEncoder = new UrlEncoder();
		String result2 = urlEncoder.encode("안녕");
		System.out.println("URL 방식 : " + result2);
	}

}
