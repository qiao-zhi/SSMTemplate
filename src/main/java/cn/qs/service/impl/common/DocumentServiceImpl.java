package cn.qs.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qs.bean.common.Document;
import cn.qs.mapper.common.DocumentMapper;
import cn.qs.service.common.DocumentService;

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
	public String getPathById(String documentId) {
		return documentMapper.findOne(documentId).getPath();
	}
}