package cn.xm.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xm.bean.common.InstantMessage;
import cn.xm.controller.AbstractSequenceController;
import cn.xm.service.BaseService;
import cn.xm.service.common.InstantMessageService;

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
