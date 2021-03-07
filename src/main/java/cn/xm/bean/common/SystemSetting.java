package cn.xm.bean.common;

import cn.xm.bean.AbstractSequenceEntity;

import javax.persistence.Entity;

//公共信息表
@Entity
public class SystemSetting extends AbstractSequenceEntity {

    /**
     * key，唯一
     */
    private String settingKey;

    /**
     * 标签
     */
    private String settingLabel;

    /**
     * 值
     */
    private String settingValue;

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getSettingLabel() {
        return settingLabel;
    }

    public void setSettingLabel(String settingLabel) {
        this.settingLabel = settingLabel;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }
}