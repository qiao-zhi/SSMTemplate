package cn.xm.mapper.common;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xm.bean.common.Document;

public interface DocumentMapper extends JpaRepository<Document, String> {

}