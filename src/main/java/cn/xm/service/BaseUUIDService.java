package cn.xm.service;

/**
 * 公共的service接口(主键是Integer类型)
 * 
 * @author Administrator
 *
 * @param <T>
 *            bean实体
 * @param <E>
 *            ID类型
 */
public interface BaseUUIDService<T> extends BaseService<T, String> {

}
