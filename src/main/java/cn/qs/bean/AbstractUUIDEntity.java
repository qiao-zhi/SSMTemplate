package cn.qs.bean;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 所有实体类中相同的部分(UUID类型的)
 * 
 * @author Administrator
 *
 */
@MappedSuperclass
public abstract class AbstractUUIDEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	protected String id;

	protected Date createtime;

	protected String creator;

	public AbstractUUIDEntity() {
		this.createtime = new Date();
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
