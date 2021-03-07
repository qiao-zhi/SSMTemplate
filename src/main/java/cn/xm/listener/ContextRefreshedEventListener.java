package cn.xm.listener;

import cn.xm.bean.common.SystemSetting;
import cn.xm.bean.user.User;
import cn.xm.service.common.SystemSettingService;
import cn.xm.service.user.UserService;
import cn.xm.utils.DefaultValue;
import cn.xm.utils.system.SpringBootUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(ContextRefreshedEventListener.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SystemSettingService systemSettingService;

    private volatile boolean hasInited;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (hasInited) {
            log.info("hasInited");
            return;
        }
        log.debug("init end");
        hasInited = true;

        createAdminUser();
        createSystemSetting();

        log.debug("created end");
    }

    /**
     * 创建默认的系统设置信息
     */
    private void createSystemSetting() {
    	// 1. 创建消息类型字典设置
        String messageTypeKey = DefaultValue.SYSTEM_SETTING_KEY_MESSAGE_TYPE;
        SystemSetting messageType = systemSettingService.getBySettingKey(messageTypeKey);
        if (messageType == null) {
            messageType = new SystemSetting();
            messageType.setSettingKey(messageTypeKey);
            messageType.setSettingLabel("消息类型");
            messageType.setSettingValue("生活,学习,工作,其他");
            systemSettingService.add(messageType);
            log.debug("add messageTypeKey: {}", messageTypeKey);
        }
    }

    /**
     * 创建管理员
     */
    private void createAdminUser() {
        String adminUserName = "admin";
        User findUserByUsername = userService.findUserByUsername(adminUserName);
        if (findUserByUsername == null) {
            User user = new User();
            String adminPassword = DigestUtils.md5Hex("123456");
            user.setPassword(adminPassword);
            user.setUsername(adminUserName);
            user.setFullname("系统管理员");
            user.setCreatetime(new Date());
            user.setRoles("系统管理员");

            userService.add(user);
            log.info("系统管理员创建成功");
        } else {
            log.info("系统管理员已经存在");
        }
    }

}
