package cn.xm.service.common;

import java.util.List;

import cn.xm.bean.common.InstantMessage;
import cn.xm.service.BaseSequenceService;

public interface InstantMessageService extends BaseSequenceService<InstantMessage> {

	List<InstantMessage> findByBeanId(Integer beanId);

	List<InstantMessage> findByBeanIdAndType(Integer beanId, String type);
}
