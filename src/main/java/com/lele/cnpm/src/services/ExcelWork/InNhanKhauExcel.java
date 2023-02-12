package com.lele.cnpm.src.services.ExcelWork;
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lele.cnpm.src.models.NhanKhau;
 
public class InNhanKhauExcel {
    public static final int COLUMN_INDEX_STT            = 0;
    public static final int COLUMN_INDEX_HOTEN          = 1;
    public static final int COLUMN_INDEX_BIETDANH       = 2;
    public static final int COLUMN_INDEX_NGAYSINH       = 3;
    public static final int COLUMN_INDEX_GIOITINH       = 4;
    public static final int COLUMN_INDEX_NOISINH        = 5;
    public static final int COLUMN_INDEX_NGUYENQUAN     = 6;
    public static final int COLUMN_INDEX_DANTOC         = 7;
    public static final int COLUMN_INDEX_TONGIAO        = 8;
    public static final int COLUMN_INDEX_QUOCTICH       = 9;
    public static final int COLUMN_INDEX_NGHENGHIEP     = 10;
    public static final int COLUMN_INDEX_NOILAMVIEC     = 11;
    public static final int COLUMN_INDEX_SOCCCD         = 12;
    public static final int COLUMN_INDEX_NGAYCAP        = 13;
    public static final int COLUMN_INDEX_CHUYENDENNGAY  = 14;
    public static final int COLUMN_INDEX_NOITRUTRUOC    = 15;
    public static final int COLUMN_INDEX_TRANGTHAI      = 16;
    private static CellStyle cellStyleFormatNumber = null;
 
    /**
     * In nhân khẩu ra file Excel
     * @param nhanKhaus
     * @param excelFilePath
     * @throws IOException
     */
    public static void writeExcel(ArrayList<NhanKhau> nhanKhaus, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
 
        // Create sheet
        Sheet sheet = workbook.createSheet("NhanKhau"); // Create sheet with sheet name
 
        int rowIndex = 3; // In từ hàng thứ ba
         
        // Write header
        writeHeader(sheet, rowIndex);
 
        // Write data
        rowIndex++;
        for (NhanKhau nk : nhanKhaus) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeNhanKhau(nk, row);
            rowIndex++;
        }
 
        // Auto resize column witdth
        int numberOfColumn = 17;
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
    }

 
    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyle(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("STT");
 
        cell = row.createCell(COLUMN_INDEX_HOTEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ và tên");
 
        cell = row.createCell(COLUMN_INDEX_BIETDANH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Bí danh");
 
        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày sinh");
 
        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giới tính");

        cell = row.createCell(COLUMN_INDEX_NOISINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nơi sinh");
 
        cell = row.createCell(COLUMN_INDEX_NGUYENQUAN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nguyên quán");
 
        cell = row.createCell(COLUMN_INDEX_DANTOC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Dân tộc");
 
        cell = row.createCell(COLUMN_INDEX_TONGIAO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tôn giáo");
 
        cell = row.createCell(COLUMN_INDEX_QUOCTICH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Quốc tịch");

        cell = row.createCell(COLUMN_INDEX_NGHENGHIEP);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nghề nghiệp");
 
        cell = row.createCell(COLUMN_INDEX_NOILAMVIEC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nơi làm việc");
 
        cell = row.createCell(COLUMN_INDEX_SOCCCD);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số CCCD");
 
        cell = row.createCell(COLUMN_INDEX_NGAYCAP);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày cấp");
 
        cell = row.createCell(COLUMN_INDEX_CHUYENDENNGAY);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày chuyển đến");

        cell = row.createCell(COLUMN_INDEX_NOITRUTRUOC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nơi ở trước đây");
 
        cell = row.createCell(COLUMN_INDEX_TRANGTHAI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Trạng thái");
    }
 
    // Write data
    private static void writeNhanKhau(NhanKhau nk, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
             
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        // create date cellstyle
        // Create font
        Font font = row.getSheet().getWorkbook().createFont();
        font.setFontName("Sitka Display"); 
        // font.setBold(true);
        font.setFontHeightInPoints((short) 12); // font size
        font.setColor(IndexedColors.BLACK.getIndex()); // text color
        Workbook workbook = row.getSheet().getWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setFont(font);
        dateCellStyle.setDataFormat(
    createHelper.createDataFormat().getFormat("dd/mm/yyyy"));

        // create CellStyle
        CellStyle cellStyle = createStyle(row.getSheet());
        cellStyle.setFont(font);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(row.getRowNum()-3);
 
        cell = row.createCell(COLUMN_INDEX_HOTEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getHoTen());
 
        cell = row.createCell(COLUMN_INDEX_BIETDANH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getBietDanh());
 
        Cell dcell = row.createCell(COLUMN_INDEX_NGAYSINH);
        dcell.setCellStyle(dateCellStyle);
        dcell.setCellValue(nk.getNgaySinh());
 
        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getGioiTinh());

        cell = row.createCell(COLUMN_INDEX_NOISINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getNoiSinh());
 
        cell = row.createCell(COLUMN_INDEX_NGUYENQUAN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getNguyenQuan());
 
        cell = row.createCell(COLUMN_INDEX_DANTOC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getDanToc());
 
        cell = row.createCell(COLUMN_INDEX_TONGIAO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getTonGiao());
 
        cell = row.createCell(COLUMN_INDEX_QUOCTICH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getQuocTich());

        cell = row.createCell(COLUMN_INDEX_NGHENGHIEP);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getNgheNghiep());
 
        cell = row.createCell(COLUMN_INDEX_NOILAMVIEC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getNoiLamViec());
 
        cell = row.createCell(COLUMN_INDEX_SOCCCD);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getSoCCCD());
 
        dcell = row.createCell(COLUMN_INDEX_NGAYCAP);
        dcell.setCellStyle(dateCellStyle);
        dcell.setCellValue(nk.getNgayCap());
 
        dcell = row.createCell(COLUMN_INDEX_CHUYENDENNGAY);
        dcell.setCellStyle(dateCellStyle);
        dcell.setCellValue(nk.getChuyenDenNgay());

        cell = row.createCell(COLUMN_INDEX_NOITRUTRUOC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getNoiThuongTruTruoc());
 
        cell = row.createCell(COLUMN_INDEX_TRANGTHAI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(nk.getTrangThai());
    }
 
    // Create CellStyle for header
    private static CellStyle createStyle(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Sitka Display"); 
        // font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.BLACK.getIndex()); // text color
        font.setBold(true);
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        // cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        // cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     
    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    } 
}

