package cn.qs.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qs.controller.AbstractController;

@Controller
public class Index extends AbstractController {

	@RequestMapping("/index")
	public String index(ModelMap map, HttpServletRequest request) {
		request.setAttribute("productName", productName);
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome(ModelMap map) {
		return "welcome";
	}

	@Override
	public String getViewBasePath() {
		return null;
	}
}
