/**
 * 
 */
package cn.edu.gdut.llc.share.response;

import java.io.Serializable;


import cn.edu.gdut.llc.share.constant.ErrorCode;

/**
 * @author cpt72
 *
 */
public class ResponseMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean status;
	private String errorCode;
	private String message;
	private Object data;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCode errorCode) {
		if(errorCode!=null)
			this.errorCode = errorCode.getCode();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString()
	{
		return "{\"status\": \""+status+"\",\"errorCode\": \""+errorCode+"\",\"message\": \""+message+"\"}";
	}
}
