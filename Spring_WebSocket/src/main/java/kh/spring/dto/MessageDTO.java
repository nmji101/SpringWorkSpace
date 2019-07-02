package kh.spring.dto;


//Setter와 Getter 어노테이션도 있는데 라이브러리추가해야한다. -> lombok
//그런데 실제로 setter, getter를 쓸수는없다.
public class MessageDTO {
	private String name;
	private String message;
	
	public MessageDTO() {
		super();
	}

	public MessageDTO(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
