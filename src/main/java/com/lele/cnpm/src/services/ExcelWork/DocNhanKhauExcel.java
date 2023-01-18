package com.lele.cnpm.src.services.ExcelWork;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lele.cnpm.src.models.NhanKhau;
 
public class DocNhanKhauExcel {
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
 
 
    /**
     * @param excelFilePath
     * @return list Nhân khẩu đọc được từ file excel
     * @throws IOException
     */
    public static ArrayList<NhanKhau> readExcel(String excelFilePath) throws IOException {
        ArrayList<NhanKhau> listNhanKhaus = new ArrayList<>();
 
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);
 
        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        // iterator.next(); iterator.next();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() <= 6) {
                // Ignore 7 header lines
                continue;
            }
 
            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();
 
            // Read cells and set value for book object
            NhanKhau nk = new NhanKhau();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for nk object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_INDEX_STT:
                    // nk.setId(new BigDecimal((double) cellValue).intValue());
                    break;
                case COLUMN_INDEX_HOTEN:
                    nk.setHoTen(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_BIETDANH:
                    nk.setBietDanh(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_NGAYSINH:
                    nk.setNgaySinh(new java.sql.Date(cell.getDateCellValue().getTime()));
                    break;
                case COLUMN_INDEX_GIOITINH:
                    nk.setGioiTinh(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_NOISINH:
                    nk.setNoiSinh(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_NGUYENQUAN:
                    nk.setNguyenQuan(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_DANTOC:
                    nk.setDanToc(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_TONGIAO:
                    nk.setTonGiao(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_QUOCTICH:
                    nk.setQuocTich(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_NGHENGHIEP:
                    nk.setNgheNghiep(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_NOILAMVIEC:
                    nk.setNoiLamViec(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_SOCCCD:
                    nk.setSoCCCD(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_NGAYCAP:
                    nk.setNgayCap(new java.sql.Date(cell.getDateCellValue().getTime()));
                    break;
                case COLUMN_INDEX_CHUYENDENNGAY:
                    nk.setChuyenDenNgay(new java.sql.Date(cell.getDateCellValue().getTime()));
                    break;
                case COLUMN_INDEX_NOITRUTRUOC:
                    nk.setNoiThuongTruTruoc(cell.getStringCellValue());
                    break;
                case COLUMN_INDEX_TRANGTHAI:
                    nk.setTrangThai(cell.getStringCellValue());
                    break;
                default:
                    break;
                }
            }
            if (nk.getHoTen() != null) listNhanKhaus.add(nk);
        }
    
        workbook.close();
        inputStream.close();
 
        return listNhanKhaus;
    }
 
    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }
 
    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
        case BOOLEAN:
            cellValue = cell.getBooleanCellValue();
            break;
        case FORMULA:
            Workbook workbook = cell.getSheet().getWorkbook();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            cellValue = evaluator.evaluate(cell).getNumberValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        case _NONE:
        case BLANK:
        case ERROR:
            break;
        default:
            break;
        }
 
        return cellValue;
    }
}
