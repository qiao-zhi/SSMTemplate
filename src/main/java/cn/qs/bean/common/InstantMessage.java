package cn.qs.bean.common;

import javax.persistence.Entity;

import cn.qs.bean.AbstractSequenceEntity;

// 及时消息(评论)
@Entity
public class InstantMessage extends AbstractSequenceEntity {

	private String senderUsername;
	private String senderFullname;

	private String targerUsername;
	private String targetFullname;

	// 父消息ID
	private Integer parentMsgId;
	private String content;

	// 相关业务的ID
	private Integer beanId;
	private String beanStrId;

	private String type;
	private String received;

	public String getSenderUsername() {
		return senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getSenderFullname() {
		return senderFullname;
	}

	public void setSenderFullname(String senderFullname) {
		this.senderFullname = senderFullname;
	}

	public String getTargerUsername() {
		return targerUsername;
	}

	public void setTargerUsername(String targerUsername) {
		this.targerUsername = targerUsername;
	}

	public String getTargetFullname() {
		return targetFullname;
	}

	public void setTargetFullname(String targetFullname) {
		this.targetFullname = targetFullname;
	}

	public Integer getParentMsgId() {
		return parentMsgId;
	}

	public void setParentMsgId(Integer parentMsgId) {
		this.parentMsgId = parentMsgId;
	}

	public Integer getBeanId() {
		return beanId;
	}

	public void setBeanId(Integer beanId) {
		this.beanId = beanId;
	}

	public String getBeanStrId() {
		return beanStrId;
	}

	public void setBeanStrId(String beanStrId) {
		this.beanStrId = beanStrId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}