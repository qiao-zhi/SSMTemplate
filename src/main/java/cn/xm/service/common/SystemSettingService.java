package cn.xm.service.common;

import cn.xm.bean.common.SystemSetting;
import cn.xm.service.BaseSequenceService;

public interface SystemSettingService extends BaseSequenceService<SystemSetting> {

    SystemSetting getBySettingKey(String settingKey);
}
