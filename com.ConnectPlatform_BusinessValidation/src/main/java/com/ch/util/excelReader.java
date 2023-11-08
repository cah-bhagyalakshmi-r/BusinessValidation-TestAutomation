package com.ch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.ch.base.TestBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelReader extends TestBase {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public excelReader(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// returns the row count in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}
	
	// returns the data from a cell
			public String getCellData(String sheetName, String colName, int rowNum) {
				try {
					if (rowNum <= 0)
						return "";

					int index = workbook.getSheetIndex(sheetName);
					int col_Num = -1;
					if (index == -1)
						return "";

					sheet = workbook.getSheetAt(index);
					row = sheet.getRow(0);
					for (int i = 0; i < row.getLastCellNum(); i++) {
						if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
							col_Num = i;
					}
					if (col_Num == -1)
						return "";

					sheet = workbook.getSheetAt(index);
					row = sheet.getRow(rowNum - 1);
					if (row == null)
						return "";
					cell = row.getCell(col_Num);

					if (cell == null)
						return "";

					if (cell.getCellType().name().equals("STRING"))
						return cell.getStringCellValue();

					else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA"))) {

						String cellText = String.valueOf(cell.getNumericCellValue());
						if (DateUtil.isCellDateFormatted(cell)) {
							// format in form of M/D/YY
							double d = cell.getNumericCellValue();

							Calendar cal = Calendar.getInstance();
							cal.setTime(DateUtil.getJavaDate(d));
							cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
							cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

						}
						return cellText;
					} else if (cell.getCellType().BLANK != null)
						return "";
					else
						return String.valueOf(cell.getBooleanCellValue());

				} catch (Exception e) {

					e.printStackTrace();
					return "row " + rowNum + " or column " + colName + " does not exist in xls";
				}
			}

	
	
}
