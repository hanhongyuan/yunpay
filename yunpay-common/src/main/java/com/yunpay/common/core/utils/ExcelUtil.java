package com.yunpay.common.core.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 导出数据到Excel的通用类
 *
 */
public class ExcelUtil {
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 
	 * @author:   csdn.net kang5789
	 * @version:  1.0  
	 * @Date:     2017年4月14日上午9:56:12 
	 * 
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 * 2017年7月10日     duan zhang quan   1.0     修改
	 *
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	@SuppressWarnings("static-access")
	public static <Q> void writeExcel(HttpServletResponse response, String fileName, String agent,List<Q> list, Class<Q> cls) throws IOException, IllegalArgumentException, IllegalAccessException{    
        HSSFWorkbook wb = new HSSFWorkbook();  
        Field[] fields = cls.getDeclaredFields();  
        ArrayList<String> headList = new ArrayList<String>();  
        for (Field f : fields){  
            ExcelField field = (ExcelField)f.getAnnotation(ExcelField.class);       
            if (field != null){  
                headList.add(field.title());  
            }  
        }  
        CellStyle style = getCellStyle(wb);  
        Sheet sheet = wb.createSheet();  
        // 设置Excel的表头 
        Row row = sheet.createRow(0);  
        row.setHeight((short)(15*40));
        for (int i = 0; i < headList.size(); i++){  
            Cell headCell = row.createCell(i);  
            headCell.setCellType(Cell.CELL_TYPE_STRING);  
            headCell.setCellStyle(style);//设置表头样式    
            headCell.setCellValue(String.valueOf(headList.get(i)));  
            //sheet.autoSizeColumn((short) i);// 设置单元格自适应 
            if(i==4||i==9||i==10){
            	sheet.setColumnWidth(i, 15 * 512);
            }else{
            	sheet.setColumnWidth(i, 15 * 256);
            }              
        } 
        HSSFDataFormat df = wb.createDataFormat();
        HSSFCellStyle contextstyle =wb.createCellStyle();
        for (int i = 0; i < list.size(); i++){  
            Row rowdata = sheet.createRow(i + 1);//创建数据行    
            rowdata.setHeight((short)(15*30));
            Q q = list.get(i);  
            Field[] ff = q.getClass().getDeclaredFields();  
            int j = 0;  
            for (Field f : ff){  
                ExcelField field = (ExcelField)f.getAnnotation(ExcelField.class);  
                if (field == null){  
                    continue;  
                }  
                f.setAccessible(true);  
                Object obj = f.get(q);  
                Cell cell = rowdata.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);  
                if (obj instanceof Integer) cell.setCellValue((Integer) obj);  
                if (obj instanceof String) cell.setCellValue((String) obj);  
                if (obj instanceof Boolean) cell.setCellValue((Boolean) obj);  
                if (obj instanceof Date) cell.setCellValue(DateUtils.formatDate((Date)obj,"yyyy-MM-dd"));  
                if (obj instanceof Calendar) cell.setCellValue((Calendar) obj);  
                if (obj instanceof Float){                	
                	contextstyle.setDataFormat(df.getBuiltinFormat("#,##0.00"));
                	cell.setCellStyle(contextstyle);
                	cell.setCellValue((Float) obj);
                }   
                //将序号替换为123456  
                if (j == 0) cell.setCellValue(i + 1);  
                j++;  
            }  
        }         
		response.setContentType("application/vnd.ms-excel");
		String excelname = fileName;
		String codedFileName = java.net.URLEncoder.encode(excelname, "UTF-8");
		if (agent.contains("firefox")) {
			response.setCharacterEncoding("utf-8");
			response.setHeader("content-disposition", "attachment;filename=" + new String(excelname.getBytes(), "ISO8859-1") + ".xls");
		} else {
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
		} 
        OutputStream ouputStream = null;  
        try{  
            ouputStream = response.getOutputStream();  
            wb.write(ouputStream);  
        }  
        finally{  
            ouputStream.close();  
        }  
    }
	
	
	 /** 
     *  
     * @Description:设置表头样式 
     * @author kang 
     * @date 2016年8月24日 
     */  
    public static CellStyle getCellStyle(Workbook wb){  
        CellStyle style = wb.createCellStyle();  
        Font font = wb.createFont();  
        font.setFontName("宋体");  
        font.setFontHeightInPoints((short) 12);//设置字体大小    
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗    
        style.setFillForegroundColor(HSSFColor.LIME.index);// 设置背景色    
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style.setAlignment(HSSFCellStyle.SOLID_FOREGROUND);//让单元格居中    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中     
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中     
        style.setWrapText(true);//设置自动换行    
        style.setFont(font);  
        return style;  
    }   
}
