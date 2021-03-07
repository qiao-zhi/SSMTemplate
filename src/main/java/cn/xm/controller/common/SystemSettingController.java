package cn.xm.controller.common;

import cn.xm.bean.common.SystemSetting;
import cn.xm.controller.AbstractSequenceController;
import cn.xm.service.BaseService;
import cn.xm.service.common.SystemSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("system-setting")
public class SystemSettingController extends AbstractSequenceController<SystemSetting> {

    @Autowired
    private SystemSettingService systemSettingService;

    @Override
    public BaseService<SystemSetting, Integer> getBaseService() {
        return systemSettingService;
    }

    @Override
    public String getViewBasePath() {
        return "system-setting";
    }
}
