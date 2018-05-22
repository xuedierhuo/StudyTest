package com.xderhuo.vo;

/**
 * 提示消息封装数据（vo值对象）
 * @author liangtong
 *
 */
public class MessageVo {

	private String msg;			//提示信息
	private Integer flag;		//标记(用于页面标识，内容开发人员自定确定的)
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public MessageVo() {
		super();
	}
	public MessageVo(String msg, Integer flag) {
		super();
		this.msg = msg;
		this.flag = flag;
	}
	
	
}
