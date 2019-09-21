package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.Document;

public class ExcelUtils {
	private static XSSFSheet ExcelSheet;
	private static XSSFSheet Testsheet;
	private static XSSFSheet TMsheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFWorkbook TestWBook;

	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static String getData(String Path, String SheetName, int RowNum, int ColNum)
			throws IOException, InvalidFormatException {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelWBook.getSheet(SheetName);
			Cell = ExcelSheet.getRow(RowNum).getCell(ColNum);
			String celldata = Cell.getStringCellValue();
			return celldata;

		} catch (Exception e) {

			throw (e);

		}

	}

	public static void setResult(String ExcelName, String Result, int RowNum, int ColNum) throws Exception {
		FileInputStream filein = new FileInputStream(new File(ExcelName));
		TestWBook = new XSSFWorkbook(filein);
		Testsheet = TestWBook.getSheet("Sheet1");
		try {

			Row = Testsheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(new File(ExcelName));

			TestWBook.write(fileOut);
			fileOut.close();
			filein.close();

		} catch (Exception e) {

			throw (e);

		}
	}

	public static void sendToWord(String imagepath) throws IOException, InvalidFormatException {
		File f = new File(System.getProperty("user.dir") + "\\Sample.docx");
		FileInputStream file = new FileInputStream(f);

		CustomXWPFDocument document = new CustomXWPFDocument(file);
		FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") + "\\Sample.docx"));

		String blipId = document.addPictureData(new FileInputStream(new File(imagepath)), Document.PICTURE_TYPE_JPEG);

		System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));

		// System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
		document.createPicture(blipId, document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 700, 500);

		document.write(fos);
		fos.flush();
		fos.close();
		file.close();

	}
}
