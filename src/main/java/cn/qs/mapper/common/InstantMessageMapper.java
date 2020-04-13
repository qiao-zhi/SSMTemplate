package cn.qs.mapper.common;

import java.util.List;

import cn.qs.bean.common.InstantMessage;
import cn.qs.mapper.BaseSequenceMapper;

public interface InstantMessageMapper extends BaseSequenceMapper<InstantMessage> {

	List<InstantMessage> findByBeanId(Integer beanId);

	List<InstantMessage> findByBeanIdAndType(Integer beanId, String type);
}