package cn.xm.utils;

import java.io.Serializable;

public class JSONResultUtil<T> implements Serializable {

	private static final long serialVersionUID = 3637122497350396679L;

	private boolean success;

	private T data;

	private String msg;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public JSONResultUtil(boolean success) {
		this(success, "");
	}

	public JSONResultUtil(boolean success, String msg) {
		this(success, msg, null);
	}

	public JSONResultUtil(boolean success, String msg, T data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	/********* S 返回正确的结果集 *************/

	/**
	 * 返回正确结果不带数据
	 * 
	 * @return
	 */
	public static <T> JSONResultUtil<T> ok() {
		return new JSONResultUtil<T>(true);
	}

	/**
	 * 返回正确结果不带数据带消息
	 * 
	 * @return
	 */
	public static <T> JSONResultUtil<T> okWithMsg(String msg) {
		return new JSONResultUtil<T>(true, msg);
	}

	/**
	 * 返回正确结果不带数据带消息
	 * 
	 * @return
	 */
	public static <T> JSONResultUtil<T> okWithMsgAndData(String msg, T data) {
		return new JSONResultUtil<T>(true, msg);
	}

	/********* E 返回正确的结果集 *************/

	/********* S 返回错误的结果集 *************/
	/**
	 * 返回错误的结果带错误信息
	 * 
	 * @param msg
	 * @return
	 */
	public static JSONResultUtil<Object> error(String msg) {
		return new JSONResultUtil<Object>(false, msg);
	}

	/**
	 * 返回错误的结果带错误信息、数据
	 * 
	 * @param msg
	 * @return
	 */
	public static <T> JSONResultUtil<T> errorWithData(String msg, T data) {
		return new JSONResultUtil<T>(false, msg, data);
	}
	/********* E 返回错误的结果集 *************/
}