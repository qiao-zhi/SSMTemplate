package cn.qs;

import java.util.List;
import java.util.Map;

import cn.qs.utils.export.ExcelReader;

public class ReadExcel {

	public static void main(String[] args) {
		ExcelReader excelReader = new ExcelReader("F:/3.xlsx");
		List<Map<String, Object>> readAllSheetDatas = excelReader.readSheetDatas(1);
		System.out.println(readAllSheetDatas);
		
		
/*		List<String> result = new ArrayList<>();
		for (Map<String, Object> map : readAllSheetDatas) {
			String string = MapUtils.getString(map, "物料编号");
			String float1 = MapUtils.getString(map, "最终单价");
			String sql = "update oitw set U_CWPrice = '" + float1 + "' where itemcode = '" + string
					+ "' and whscode = '107';";
			result.add(sql);
		}

		try {
			FileUtils.writeLines(new File("F:/2.txt"), result, "\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
