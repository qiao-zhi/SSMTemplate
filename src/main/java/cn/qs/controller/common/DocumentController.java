package cn.qs.controller.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.qs.bean.common.Document;
import cn.qs.service.common.DocumentService;
import cn.qs.utils.UUIDUtils;
import cn.qs.utils.file.FileHandleUtil;
import cn.qs.utils.file.TikaUtils;
import cn.qs.utils.system.MySystemUtils;

@Controller
@RequestMapping("document")
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private DocumentService documentService;

	/**
	 * Restful风格获取文档
	 * 
	 * @param request
	 * @param response
	 * @param documentId
	 */
	@RequestMapping("/getDocument/{documentId}")
	public void getPicture(HttpServletRequest request, HttpServletResponse response,
			@PathVariable() String documentId) {
		FileInputStream in = null;
		ServletOutputStream outputStream = null;
		try {
			Document document = documentService.getById(documentId);
			String path = document.getPath();
			String originName = document.getOriginName();

			File fileByName = FileHandleUtil.getFileByName(path);

			// 判断文件类型，image、pdf返回阅读，其他下载
			String fileType = TikaUtils.getFileType(fileByName);
			if (!TikaUtils.TYPE_IMAGE.equals(fileType) && !TikaUtils.TYPE_PDF.equals(fileType)) {
				response.setContentType("application/force-download");
				response.setHeader("Content-Disposition", "attachment;fileName=" + originName);
			}

			in = new FileInputStream(fileByName);
			outputStream = response.getOutputStream();
			IOUtils.copyLarge(in, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(outputStream);
		}
	}

	/**
	 * 文档上传
	 * 
	 * @param imgFile
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String, Object> uploadPicture(MultipartFile imgFile) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("error", 1);

		if (imgFile == null) {
			result.put("message", "文件没接到");
			return result;
		}
		logger.debug("file -> {},viewId ->{}", imgFile.getOriginalFilename());

		String fileOriName = imgFile.getOriginalFilename();// 获取原名称
		String fileNowName = UUIDUtils.getUUID2() + "." + FilenameUtils.getExtension(fileOriName);// 生成唯一的名字
		try {
			FileHandleUtil.uploadSpringMVCFile(imgFile, fileNowName);

		} catch (Exception e) {
			logger.error("uploadPicture error", e);
			return result;
		}

		String id = UUIDUtils.getUUID();
		Document document = new Document();
		document.setCreatetime(new Date());
		document.setPath(fileNowName);
		document.setId(id);
		document.setOriginName(fileOriName);
		document.setUploaderUsername(MySystemUtils.getLoginUsername());

		documentService.insert(document);

		// 回传JSON结果
		result.put("error", 0);
		result.put("url", "/document/getDocument/" + id);
		return result;
	}
}