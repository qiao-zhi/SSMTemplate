package cn.qs.service.common;

import java.util.List;

import cn.qs.bean.common.InstantMessage;
import cn.qs.service.BaseSequenceService;

public interface InstantMessageService extends BaseSequenceService<InstantMessage> {

	List<InstantMessage> findByBeanId(Integer beanId);

	List<InstantMessage> findByBeanIdAndType(Integer beanId, String type);
}
