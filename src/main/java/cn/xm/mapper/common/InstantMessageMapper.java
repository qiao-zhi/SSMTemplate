package cn.xm.mapper.common;

import java.util.List;

import cn.xm.bean.common.InstantMessage;
import cn.xm.mapper.BaseSequenceMapper;

public interface InstantMessageMapper extends BaseSequenceMapper<InstantMessage> {

	List<InstantMessage> findByBeanId(Integer beanId);

	List<InstantMessage> findByBeanIdAndType(Integer beanId, String type);
}