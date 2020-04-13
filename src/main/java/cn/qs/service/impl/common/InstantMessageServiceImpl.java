package cn.qs.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qs.bean.common.InstantMessage;
import cn.qs.mapper.BaseMapper;
import cn.qs.mapper.common.InstantMessageMapper;
import cn.qs.service.common.InstantMessageService;
import cn.qs.service.impl.AbastractBaseSequenceServiceImpl;

@Service
@Transactional
public class InstantMessageServiceImpl extends AbastractBaseSequenceServiceImpl<InstantMessage>
		implements InstantMessageService {

	@Autowired
	private InstantMessageMapper instantMessageMapper;

	@Override
	public BaseMapper<InstantMessage, Integer> getBaseMapper() {
		return instantMessageMapper;
	}

	@Override
	public List<InstantMessage> findByBeanId(Integer beanId) {
		return instantMessageMapper.findByBeanId(beanId);
	}

	@Override
	public List<InstantMessage> findByBeanIdAndType(Integer beanId, String type) {
		return instantMessageMapper.findByBeanIdAndType(beanId, type);
	}

}
