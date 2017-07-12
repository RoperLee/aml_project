package com.antimoney.boot.utils;

import com.alibaba.fastjson.JSONObject;
import com.antimoney.boot.model.XLSModel;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangzhen on 2017/7/6.
 */
public class XLSXUtil {
    private POIFSFileSystem fs;
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private XSSFRow row;
//    private XSSFWorkbook wb;

    /**
     * 读取Excel表格表头的内容
     *
     * @param is
     * @return String 表头内容的数组
     */
    public String[] readExcelTitle(InputStream is) {
        try {
            wb = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     *
     * @param is
     * @return Map 包含单元格数据内容的Map对象
     */
    public ArrayList<List> readExcelContent(InputStream is) {
//        Map<Integer, List> content = new HashMap<Integer, List>();
        ArrayList<List> content=new ArrayList<>();
        try {
            wb = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            ArrayList<String> temp = new ArrayList<>();
            row = sheet.getRow(i);
            int tempNum = 0;
            int j = 0;
            while (j < colNum) {
                String s = getCellFormatValue(row.getCell((short) j)).trim();
                if (!s.equals("")) tempNum++;
                temp.add(s);
                j++;
            }
            if (tempNum > 0) {
                content.add(temp);
            }
        }
        return content;
    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(XSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;

            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

    /**
     * 获取单元格数据内容为日期类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getDateCellValue(XSSFCell cell) {
        String result = "";
        try {
            int cellType = cell.getCellType();
            if (cellType == XSSFCell.CELL_TYPE_NUMERIC) {
                Date date = cell.getDateCellValue();
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                        + "-" + date.getDate();
            } else if (cellType == XSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[年月]", "-").replace("日", "").trim();
            } else if (cellType == XSSFCell.CELL_TYPE_BLANK) {
                result = "";
            }
        } catch (Exception e) {
            System.out.println("日期格式不正确!");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据XSSFCell类型设置数据
     *
     * @param cell
     * @return
     */
    private String getCellFormatValue(XSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case XSSFCell.CELL_TYPE_NUMERIC:
                case XSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case XSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public XLSModel getFromStream(InputStream is) {
        XLSModel model = new XLSModel();
        XLSXUtil excelReader = new XLSXUtil();
        String[] title = excelReader.readExcelTitle(is);
        model.setTitle(title[0]);
//        Map<Integer, List> map = excelReader.readExcelContent(is);
        ArrayList<List> list=excelReader.readExcelContent(is);
        model.setContent(list);
        return model;
    }

    public XLSModel getFromPath(String path) throws FileNotFoundException {
        XLSModel model = new XLSModel();
        InputStream is = new FileInputStream(path);
        XLSXUtil excelReader = new XLSXUtil();
        String[] title = excelReader.readExcelTitle(is);
        model.setTitle(title[0]);
        ArrayList<List> list=excelReader.readExcelContent(new FileInputStream(path));
        model.setContent(list);

        return model;
    }

    public static void main(String[] args) {
        String path = "/Users/wagnzhen/Documents/myTest.xlsx";
        try {
            XLSModel model = new XLSXUtil().getFromPath(path);
            System.out.println("result:" + JSONObject.toJSONString(model));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            // 对读取Excel表格标题测试
//            InputStream is = new FileInputStream(path);
//            XLSXUtil excelReader = new XLSXUtil();
//            String[] title = excelReader.readExcelTitle(is);
//            System.out.println("获得Excel表格的标题:");
//            for (String s : title) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//            // 对读取Excel表格内容测试
//            InputStream is2 = new FileInputStream(path);
//            Map<Integer, List> map = excelReader.readExcelContent(is2);
//            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(map);
//            System.out.println("object:" + jsonObject.toString());
//        } catch (FileNotFoundException e) {
//            System.out.println("未找到指定路径的文件!");
//            e.printStackTrace();
//        }
    }
}
