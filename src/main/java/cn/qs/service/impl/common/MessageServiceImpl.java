package cn.qs.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qs.bean.common.Message;
import cn.qs.mapper.BaseCRUDMapper;
import cn.qs.mapper.common.MessageMapper;
import cn.qs.service.AbastractBaseSequenceServiceImpl;
import cn.qs.service.common.MessageService;

@Service
@Transactional
public class MessageServiceImpl extends AbastractBaseSequenceServiceImpl<Message> implements MessageService {

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public BaseCRUDMapper<Message, Integer> getBaseCRUDMapper() {
		return messageMapper;
	}

}
