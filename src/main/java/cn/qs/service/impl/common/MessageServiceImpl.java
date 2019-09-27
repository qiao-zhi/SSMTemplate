package cn.qs.service.impl.common;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qs.bean.common.Message;
import cn.qs.mapper.common.MessageMapper;
import cn.qs.service.common.MessageService;
import cn.qs.utils.BeanUtils;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public void add(Message t) {
		messageMapper.save(t);
	}

	@Override
	public Page<Message> pageByCondition(Map condition) {
		// 构造请求参数，页号从0开始。
		int pageNum = MapUtils.getInteger(condition, "pageNum", 0);
		int pageSize = MapUtils.getInteger(condition, "pageSize", 0);
		Pageable pageRequest = new QPageRequest(pageNum, pageSize);

		Page<Message> page = messageMapper.findAll(pageRequest);
		return page;
	}

	@Override
	public void delete(Integer id) {
		messageMapper.delete(id);
	}

	@Override
	public void update(Message t) {
		Message systemMessage = messageMapper.findOne(t.getId());
		// 将修改的属性赋值到系统bean上
		BeanUtils.copyProperties(systemMessage, t);

		messageMapper.save(systemMessage);
	}

	@Override
	public Message findById(Integer id) {
		return messageMapper.findOne(id);
	}

	@Override
	public List<Message> listByCondition(Map condition) {
		return null;
	}

}
