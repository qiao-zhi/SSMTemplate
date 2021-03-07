package cn.xm.mapper.common;

import cn.xm.bean.common.SystemSetting;
import cn.xm.mapper.BaseSequenceMapper;

public interface SystemSettingMapper extends BaseSequenceMapper<SystemSetting> {

    SystemSetting getBySettingKey(String settingKey);
}