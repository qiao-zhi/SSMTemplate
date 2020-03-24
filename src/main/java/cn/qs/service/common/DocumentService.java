package cn.qs.service.common;

import cn.qs.bean.common.Document;

public interface DocumentService {

	void insert(Document document);

	Document getById(String documentId);
}
