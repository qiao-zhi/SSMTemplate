package cn.xm.service.user;

import java.util.List;

import cn.xm.bean.user.User;
import cn.xm.service.BaseService;

public interface UserService extends BaseService<User, Integer> {

	/**
	 * 根据接口查询所用的用户
	 */
	public List<User> findAllUser();

	public User findUserByUsername(String username);

	public User getUserByUserNameAndPassword(String username, String password);
}
