package mew.misc.distributed.communication;

public class Message {

	private String to;
	private String from;
	private String msg;
	private boolean isDelivered;
	
	
	public Message(Process prc, String to, String data) {
		this.from = prc.getID();
		this.to = to;
		this.msg = data;
		this.isDelivered = false;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	@Override
	public String toString() {
		return "Message [to=" + to + ", from=" + from + ", msg=" + msg + "]";
	}


	public void setDelivered(){
		this.isDelivered = true;
	}
	
	public boolean isDelivered() {		
		return isDelivered;
	}
}
