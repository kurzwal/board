package com.yyr.board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// 생성자를 static으로 만들고 생성자 메서드명을 "set" 으로 지음
// ResponseDto.set(status, message, data); 로 생성가능
// new ResponseDto<>(status, message, data); 와 같은 기능
@AllArgsConstructor(staticName="set")
public class ResponseDto<D> {
	private boolean status;
	private String message;
	private D data;
	
	// 앞의 <D>는 리턴값에 D를 쓰겠다는 의미(위의 D와는 다른애임)
	public static <D> ResponseDto<D> setSuccess(String message, D data) {
		// new로 생성자 써도 되는데 spring 스럽지 못함
		return ResponseDto.set(true, message, data);
	}
	
	public static <D> ResponseDto<D> setFailed(String message) {
		return ResponseDto.set(false, message, null);
	}
}
