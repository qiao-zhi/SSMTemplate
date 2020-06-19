package cn.xm.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xm.bean.common.InstantMessage;
import cn.xm.mapper.BaseMapper;
import cn.xm.mapper.common.InstantMessageMapper;
import cn.xm.service.common.InstantMessageService;
import cn.xm.service.impl.AbastractBaseSequenceServiceImpl;

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
