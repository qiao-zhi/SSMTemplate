package cn.qs.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.qs.bean.user.User;
import cn.qs.controller.AbstractSequenceController;
import cn.qs.service.BaseService;
import cn.qs.service.user.UserService;
import cn.qs.utils.DefaultValue;

@Controller
@RequestMapping("user")
public class UserController extends AbstractSequenceController<User> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	public String getViewBasePath() {
		return "user";
	}

	/**
	 * Mybatis分页(重写方法)
	 * 
	 * @param condition
	 * @return
	 */
	@RequestMapping("page2")
	@ResponseBody
	@Override
	public PageInfo<User> page2(@RequestParam Map condition, HttpServletRequest request) {
		int pageNum = 1;
		if (StringUtils.isNotBlank(MapUtils.getString(condition, "pageNum"))) { // 如果不为空的话改变当前页号
			pageNum = MapUtils.getInteger(condition, "pageNum");
		}
		int pageSize = DefaultValue.PAGE_SIZE;
		if (StringUtils.isNotBlank(MapUtils.getString(condition, "pageSize"))) { // 如果不为空的话改变当前页大小
			pageSize = MapUtils.getInteger(condition, "pageSize");
		}

		// 开始分页
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = new ArrayList<User>();
		try {
			users = userService.listByCondition(condition);
		} catch (Exception e) {
			LOGGER.error("getUsers error！", e);
		}
		PageInfo<User> pageInfo = new PageInfo<User>(users);

		return pageInfo;
	}

	@Override
	public BaseService<User, Integer> getBaseService() {
		return userService;
	}
}