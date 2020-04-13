package cn.qs.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qs.bean.common.InstantMessage;
import cn.qs.controller.AbstractSequenceController;
import cn.qs.service.BaseService;
import cn.qs.service.common.InstantMessageService;

@Controller
@RequestMapping("instantMessage")
public class InstantMessageController extends AbstractSequenceController<InstantMessage> {

	@Autowired
	private InstantMessageService instantMessageService;

	@Override
	public String getViewBasePath() {
		return "instantMessage";
	}

	@Override
	public BaseService<InstantMessage, Integer> getBaseService() {
		return instantMessageService;
	}

}
