package cn.qs.utils.export;

import java.util.List;
import java.util.Map;

public class FileTest {

	public static void main(String[] args) {
		ExcelReader excelExporter = new ExcelReader("e:/test.xls");
		System.out.println("==========读取所有sheet数据，默认以第一行作为header==========");
		List<Map<String, Object>> readAllSheetDatas2 = excelExporter.readAllSheetDatas();
		System.out.println(readAllSheetDatas2);
	}

}
