package cn.qs.mapper.common;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.qs.bean.common.Document;

public interface DocumentMapper extends JpaRepository<Document, String> {

}