package cn.xm.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xm.bean.common.InstantMessage;
import cn.xm.bean.common.Message;
import cn.xm.controller.AbstractSequenceController;
import cn.xm.service.BaseService;
import cn.xm.service.common.InstantMessageService;
import cn.xm.service.common.MessageService;

@Controller
@RequestMapping("message")
public class MessageController extends AbstractSequenceController<Message> {

	@Autowired
	private MessageService messageService;

	@Autowired
	private InstantMessageService instantMessageService;

	@Override
	public String getViewBasePath() {
		return "message";
	}

	@Override
	public BaseService<Message, Integer> getBaseService() {
		return messageService;
	}

	@RequestMapping("/detail/{messageId}")
	public String getMessagedetail(ModelMap map, @PathVariable() Integer messageId, HttpServletRequest request) {
		Message message = messageService.findById(messageId);
		map.put("message", message);

		List<InstantMessage> instantMessages = instantMessageService.findByBeanIdAndType(messageId, "message");
		map.put("instantMessages", instantMessages);

		return getViewPath("detail");
	}

}
