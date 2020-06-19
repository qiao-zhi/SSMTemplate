package cn.xm.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xm.bean.common.Document;
import cn.xm.mapper.common.DocumentMapper;
import cn.xm.service.common.DocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentMapper documentMapper;

	@Override
	public void insert(Document document) {
		documentMapper.save(document);
	}

	@Override
	public Document getById(String documentId) {
		return documentMapper.findOne(documentId);
	}
}