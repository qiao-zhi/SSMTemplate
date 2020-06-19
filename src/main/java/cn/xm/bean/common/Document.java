package cn.xm.bean.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

//系统文档表
@Entity
public class Document {
	@Id
	private String id;

	/**
	 * 原名字
	 */
	private String originName;

	/**
	 * 上传者
	 */
	private String uploaderUsername;

	private String name;

	private String path;

	private Date createtime;

	private String remark1;

	private String remark2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getUploaderUsername() {
		return uploaderUsername;
	}

	public void setUploaderUsername(String uploaderUsername) {
		this.uploaderUsername = uploaderUsername;
	}

}