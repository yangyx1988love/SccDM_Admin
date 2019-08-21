/**  
 * @Title:  CsvUtil.java   
 * @Package nankai.edm.util   
 * @Description:    TODO  
 * @author: grapefa  
 * @date:   2019年2月20日 下午2:37:18   
 * @version V1.0 
 * @Copyright: 2019 www.grapelet.com Inc. All rights reserved. 
 */
package nankai.xl.common.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvUtil {

	public static List<String[]> readCSV(String csvFilePath,String CharsetCode){
		List<String[]> contentlist=new ArrayList<>();
		try {
			contentlist = new ArrayList<>();
			CsvReader csvReader = new CsvReader(csvFilePath, ',', Charset.forName(CharsetCode));
			csvReader.readHeaders();
			//String[] headContent = csvReader.getHeaders();
			//contentlist.add(headContent);
			while (csvReader.readRecord()) {
				String[] csvContent =csvReader.getValues();
				contentlist.add(csvContent);
			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return contentlist;
	}
	public static boolean writeCSV(String csvFilePath,String[] headContent,List<String[]> contentlist,String CharsetCode){
		try {
			CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName(CharsetCode));
			csvWriter.writeRecord(headContent);
			for (String[] strings : contentlist) {
				csvWriter.writeRecord(strings);
			}
			csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		return true;
	}

}
