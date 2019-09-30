package cn.qs.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qs.bean.common.Message;
import cn.qs.controller.AbstractSequenceController;
import cn.qs.service.BaseService;
import cn.qs.service.common.MessageService;

@Controller
@RequestMapping("message")
public class MessageController extends AbstractSequenceController<Message> {

	@Autowired
	private MessageService messageService;

	@Override
	public String getViewBasePath() {
		return "message";
	}

	@Override
	public BaseService<Message, Integer> getBaseService() {
		return messageService;
	}

}
