package kh.spring.dto;

public class SellerDTO {
	private int seq;
	private String bid;
	private String pid;
	
	public SellerDTO() {}
	public SellerDTO(int seq, String bid, String pid) {
		super();
		this.seq = seq;
		this.bid = bid;
		this.pid = pid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
}
