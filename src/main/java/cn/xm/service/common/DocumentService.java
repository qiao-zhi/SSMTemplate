package cn.xm.service.common;

import cn.xm.bean.common.Document;

public interface DocumentService {

	void insert(Document document);

	Document getById(String documentId);
}
