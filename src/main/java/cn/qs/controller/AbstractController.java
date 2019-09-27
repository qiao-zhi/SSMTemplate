package cn.qs.controller;

import org.apache.commons.lang3.StringUtils;

import cn.qs.utils.file.PropertiesFileUtils;

/**
 * 所以控制层的基类
 * 
 * @author Administrator
 *
 */
public abstract class AbstractController {

	protected String productName = StringUtils
			.defaultIfBlank(PropertiesFileUtils.getPropertyValue("settings.properties", "productName"), "管理网");

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
