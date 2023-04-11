package ch02;

import java.util.Base64;

public class Base64Encoder implements IEncoder {

	@Override
	public String encode(String message) {
		// Base64 형식으로 인코딩한 후 반환하기
		String resultEncode = Base64.getEncoder().encodeToString(message.getBytes());
		return resultEncode;
	}
	
}
