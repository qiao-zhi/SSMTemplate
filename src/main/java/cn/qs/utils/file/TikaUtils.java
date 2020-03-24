package cn.qs.utils.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.tika.Tika;

public class TikaUtils {

	// 总的文件类型分为下面几类
	public static final String TYPE_OFFICE = "OFFICE";
	public static final String TYPE_PDF = "PDF";
	public static final String TYPE_IMAGE = "IMAGE";
	public static final String TYPE_VIDEO = "VIDEO";
	public static final String TYPE_OTHER = "OTHER";

	// tika解析的文件信息
	private static final String WORD_DOC = "application/msword";
	private static final String WORD_PPT = "application/vnd.ms-powerpoint";
	private static final String WORD_EXCEL = "application/vnd.ms-excel";
	private static final String WORD_DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	private static final String WORD_PPTX = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
	private static final String WORD_EXCELX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	private static final String VIDEO = "video/";
	private static final String IMAGE = "image/";
	private static final String TEXT = "text/plain";
	private static final String CSS = "text/css";
	private static final String HTML = "text/html";
	private static final String PDF = "application/pdf";
	private static final String ZIP = "application/zip";
	private static final String RAR = "application/x-rar-compressed";

	public static String getFileType(File file) {
		if (file == null || !file.exists()) {
			return "";
		}

		Tika tika = new Tika();
		String filetype = null;
		try {
			filetype = tika.detect(file);
		} catch (IOException ignore) {
			// ignore
			return "error";
		}

		if (StringUtils.isBlank(filetype)) {
			return "error";
		}

		if (WORD_DOC.equals(filetype) || WORD_PPT.equals(filetype) || WORD_EXCEL.equals(filetype)
				|| WORD_DOCX.equals(filetype) || WORD_PPTX.equals(filetype) || WORD_EXCELX.equals(filetype)) {
			return TYPE_OFFICE;
		}

		if (filetype.startsWith(VIDEO)) {
			return TYPE_VIDEO;
		}

		if (filetype.startsWith(IMAGE)) {
			return TYPE_IMAGE;
		}

		if (filetype.equals(PDF)) {
			return TYPE_PDF;
		}

		return TYPE_OTHER;
	}

}
