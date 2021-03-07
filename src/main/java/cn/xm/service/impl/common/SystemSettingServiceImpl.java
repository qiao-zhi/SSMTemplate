package cn.xm.service.impl.common;

import cn.xm.bean.common.SystemSetting;
import cn.xm.mapper.BaseMapper;
import cn.xm.mapper.common.SystemSettingMapper;
import cn.xm.service.common.SystemSettingService;
import cn.xm.service.impl.AbastractBaseSequenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SystemSettingServiceImpl extends AbastractBaseSequenceServiceImpl<SystemSetting> implements SystemSettingService {

    @Autowired
    private SystemSettingMapper systemSettingMapper;

    @Override
    public BaseMapper<SystemSetting, Integer> getBaseMapper() {
        return systemSettingMapper;
    }

    @Override
    public SystemSetting getBySettingKey(String settingKey) {
        return systemSettingMapper.getBySettingKey(settingKey);
    }
}
