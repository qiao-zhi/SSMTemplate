package cn.qs.controller;

/**
 * 所以控制层的基类
 * 
 * @author Administrator
 *
 */
public abstract class AbstractController {

	/**
	 * 生成带basePath的页面路径
	 * 
	 * @param path
	 * @return
	 */
	public String getViewPath(String path) {
		return getViewBasePath() + "/" + path;
	}

	/**
	 * 页面所在的目录
	 * 
	 * @return
	 */
	public abstract String getViewBasePath();

}
