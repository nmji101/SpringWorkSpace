package kh.spring.dto;

import org.springframework.stereotype.Component;

@Component
public class MessageDTO {
	private int seq;
	private String name;
	private String msg;
	
	public MessageDTO(int seq, String name, String msg) {
		super();
		this.seq = seq;
		this.name = name;
		this.msg = msg;
	}
	public MessageDTO() {
		super();
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
