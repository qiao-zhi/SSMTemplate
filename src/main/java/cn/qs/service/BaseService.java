package cn.qs.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * 公共的service接口
 * 
 * @author Administrator
 *
 * @param <T>
 *            bean实体
 * @param <E>
 *            ID类型
 */
public interface BaseService<T, E> {

	void add(T t);

	void delete(E id);

	void update(T t);

	T findById(E id);

	List<T> listByCondition(Map condition);

	Page<T> pageByCondition(Map condition);

}
