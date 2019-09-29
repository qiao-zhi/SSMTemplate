package cn.qs.bean;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 所有实体类中相同的部分(自增ID类型的)
 * 
 * @author Administrator
 *
 */
@MappedSuperclass
public abstract class AbstractSequenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	protected Date createtime;

	protected String creator;

	public AbstractSequenceEntity() {
		this.createtime = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}
