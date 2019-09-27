package cn.qs.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * 提供一个默认的实现
 * 
 * @author Administrator
 *
 * @param <T>
 * @param <E>
 */
public abstract class AbastractBaseServiceImpl<T, E> implements BaseService<T, E> {

	@Override
	public void add(T t) {

	}

	@Override
	public void delete(E id) {

	}

	@Override
	public void update(T t) {

	}

	@Override
	public T findById(E id) {
		return null;
	}

	@Override
	public List<T> listByCondition(Map condition) {
		return null;
	}

	@Override
	public Page<T> pageByCondition(Map condition) {
		return null;
	}

}
