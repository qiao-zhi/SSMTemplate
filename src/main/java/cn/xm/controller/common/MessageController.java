package cn.xm.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xm.bean.common.InstantMessage;
import cn.xm.bean.common.Message;
import cn.xm.bean.common.SystemSetting;
import cn.xm.controller.AbstractSequenceController;
import cn.xm.service.BaseService;
import cn.xm.service.common.InstantMessageService;
import cn.xm.service.common.MessageService;
import cn.xm.service.common.SystemSettingService;
import cn.xm.utils.DefaultValue;

@Controller
@RequestMapping("message")
public class MessageController extends AbstractSequenceController<Message> {

	@Autowired
	private MessageService messageService;

	@Autowired
	private InstantMessageService instantMessageService;
	
    @Autowired
    private SystemSettingService systemSettingService;

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
	
    @RequestMapping("add-custom")
    public String addCustom(HttpServletRequest request) {
        String[] settingValues = findMessageTypeSettings();
        request.setAttribute("settingValues", settingValues);
        return getViewPath("add");
    }

    @RequestMapping("update-custom")
    public String updateCustom(Integer id, ModelMap map, HttpServletRequest request) {
        String[] settingValues = findMessageTypeSettings();
        request.setAttribute("settingValues", settingValues);
        return super.update(id, map, request);
    }

    private String[] findMessageTypeSettings() {
        SystemSetting setting = systemSettingService.getBySettingKey(DefaultValue.SYSTEM_SETTING_KEY_MESSAGE_TYPE);
        String[] settingValues = new String[0];
        if (setting != null) {
            String settingValue = setting.getSettingValue();
            settingValues = StringUtils.split(settingValue, ",|，");
        }
        return settingValues;
    }

}
