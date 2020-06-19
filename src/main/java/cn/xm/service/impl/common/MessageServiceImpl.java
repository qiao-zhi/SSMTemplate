package cn.xm.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xm.bean.common.Message;
import cn.xm.mapper.BaseMapper;
import cn.xm.mapper.common.MessageMapper;
import cn.xm.service.common.MessageService;
import cn.xm.service.impl.AbastractBaseSequenceServiceImpl;

@Service
@Transactional
public class MessageServiceImpl extends AbastractBaseSequenceServiceImpl<Message> implements MessageService {

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public BaseMapper<Message, Integer> getBaseMapper() {
		return messageMapper;
	}

}
