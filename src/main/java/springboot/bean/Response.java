package springboot.bean;

public class Response {
	
	private String responseCode;
	private String responseStatus;
	private String responseMsg;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	@Override
	public String toString() {
		return "Response [responseCode=" + responseCode + ", responseStatus=" + responseStatus + ", responseMsg="
				+ responseMsg + "]";
	}
	
	
	

}
