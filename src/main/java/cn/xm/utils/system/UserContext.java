package cn.xm.utils.system;

import cn.xm.bean.user.User;

public class UserContext {

	private static final ThreadLocal<User> threadLocal = new InheritableThreadLocal<>();

	public static void set(User user) {
		threadLocal.set(user);
	}

	public static User get() {
		return threadLocal.get();
	}

	public static void remove() {
		threadLocal.remove();
	}

}
