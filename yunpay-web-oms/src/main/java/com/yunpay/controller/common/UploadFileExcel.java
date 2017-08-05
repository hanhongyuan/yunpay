package com.yunpay.controller.common;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.CellStyle;

import com.yunpay.common.core.utils.DateUtils;
import com.yunpay.permission.entity.*;

@SuppressWarnings("deprecation")
public class UploadFileExcel {

    private static Log log = LogFactory.getLog(UploadFileExcel.class);
    /**
     * 提供下载表格的方法 String title 文件名 String[] headers 列名 list<String[]> list 数据内容
     * String addrss 输出地址
     * 
     * */
    public static boolean Export(OutputStream os,String title, String[] headers, List<String[]> list) {
        try {
            // 声明一个工作薄
            HSSFWorkbook wb = new HSSFWorkbook();
            // 声明一个单子并命名
            HSSFSheet sheet = wb.createSheet(title);
            // 给单子名称一个长度
            sheet.setDefaultColumnWidth((short) 15);
            // 创建第一行（也可以称为表头）
            HSSFRow row = sheet.createRow(0);
            // 定义字体
            HSSFFont font = TitleFont(wb, "黑体", 13);
            // 设置标题样式
            HSSFCellStyle titleStyle = TitleStyle(wb, font);
            // 设置边框样式
            HSSFCellStyle borderStyle = BorderStyle(wb);
            // 设置金额样式
            HSSFCellStyle moneyStyle = MoneyStyle(wb);
            // 百分比样式
            HSSFCellStyle percentStyle = PercentStyle(wb);
            
            // for循环创建表头
            HSSFCell cell = null;
            for (int i = 0; i < headers.length; i++) {
                cell = row.createCell((short) i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(titleStyle);
                row.setHeightInPoints(18);
            }
            
            // 生成数据
            for (short i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 1);
                row.setHeight((short) (128 * 3));
                for (int j = 0; j < list.get(i).length; j++) {
                    row.createCell(j);
                    if(j==5 || j >8 && j < 13){
                        row.getCell(j).setCellStyle(moneyStyle);
                        Double num = Double.valueOf(list.get(i)[j]);
                        row.getCell(j).setCellValue(num);
                    }else if(j>5 && j<9){
                        row.getCell(j).setCellStyle(percentStyle);
                        Double num = Double.valueOf(list.get(i)[j]);
                        row.getCell(j).setCellValue(num/100);
                    }else {
                        row.getCell(j).setCellStyle(borderStyle);
                        row.getCell(j).setCellValue(list.get(i)[j]);
                    }
                }
            }
            
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (HeadlessException e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }

    /**
     * 提供下载表格的方法 String title 文件名 String header 单据唯一标识(编号+结算周期{起始时间-结束时间})
     * String[] headers 列名 list<String[]> list 数据内容 String addrss 输出地址
     * 
     * */
    public static boolean InfoExport(OutputStream os,String title, String[] header, String[] headers, List<IssuerSZTEntity> list,TotalCount M) {
        try {
            // 声明一个工作薄
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet hs = wb.createSheet("日对账明细");
            // 设置标题字体
            HSSFFont titleFont = TitleFont(wb, "宋体", 16);
            // 设置边框样式
            HSSFCellStyle borderStyle = BorderStyle(wb);
            // 设置标题样式
            HSSFCellStyle titleStyle = TitleStyle(wb,titleFont);
            // 设置金额样式
            HSSFCellStyle moneyStyle = MoneyStyle(wb);
            // 百分比样式
            HSSFCellStyle percentStyle = PercentStyle(wb);
            // 左对齐无边框
            HSSFCellStyle asignLeftStyle = AsignLeftStyle(wb);
            // 左对齐有边框样式
            HSSFCellStyle leftBorderStyle = LeftBorderStyle(wb);
            // 顶部右对齐
            HSSFCellStyle asignRightStyle = AsignRightStyle(wb);
            // 签名样式
            HSSFCellStyle signStyle = SignStyle(wb);
            // 数字样式
            HSSFCellStyle numStyle = NumStyle(wb);
            // 创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for (int i = 0; i < 8; i++) {
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 10));
                titleRow.getCell(i).setCellStyle(titleStyle);

            }
            hs.setColumnWidth(0, (short) (256 * 5));
            hs.setColumnWidth(1, (short) (256 * 25));
            // 合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 7));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256 * 4));

            // 创建第一行
            v_index += 1;
            HSSFRow topRow = hs.createRow(v_index);
            topRow.setHeight((short) (128 * 5));

            // 合并第一行第1、2、3列
            hs.addMergedRegion(new Region(v_index, (short) 0, v_index, (short) 2));
            // 合并第一行第4、5、6、7列
            hs.addMergedRegion(new Region(v_index, (short) 3, v_index, (short) 7));

            for (int i = 0; i < 8; i++) {
                topRow.createCell(i);
            }
            topRow.getCell(0).setCellStyle(asignLeftStyle);
            topRow.getCell(3).setCellStyle(asignRightStyle);
            topRow.getCell(0).setCellValue("单据编号：" + header[0]);
            topRow.getCell(3).setCellValue("结算周期：" + header[1] + " 至 " + header[2]);
            
            // 创建明细项标题
            v_index += 1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128 * 3));
            for (int i = 0; i < 8; i++) {
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(borderStyle);

            }

            // for循环创建表头
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }

            int j=0;
            for(IssuerSZTEntity model : list){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<headers.length;i++){
                    row.createCell(i);
                    if(i>2 && i<headers.length){
                        row.getCell(i).setCellStyle(moneyStyle);
                    }else{
                        row.getCell(i).setCellStyle(borderStyle);
                    }
                }
                row.getCell(0).setCellValue(++j);
                row.getCell(1).setCellStyle(leftBorderStyle);
                row.getCell(1).setCellValue(model.getMerchName());
                row.getCell(2).setCellValue(model.getMccName());
                row.getCell(3).setCellStyle(percentStyle);
                row.getCell(3).setCellValue(model.getBenefitDis()/100);
                row.getCell(4).setCellStyle(numStyle);
                row.getCell(4).setCellValue(model.getTranNum());
                row.getCell(5).setCellValue(model.getTranAmt());
                row.getCell(6).setCellValue(model.getBenefitAmt());
                row.getCell(7).setCellValue(model.getSettleAmt());
            }
            
            
            if (M != null) {
                v_index += 1; // 创建商户底部合计栏 
                HSSFRow totalRow = hs.createRow(v_index);
                totalRow.setHeight((short) (128 * 3));
                for (int i = 0; i < headers.length; i++) {
                    totalRow.createCell(i);
                    if (i > 3 && i < headers.length) {
                        totalRow.getCell(i).setCellStyle(moneyStyle);
                    }else if(i == 4){
                        totalRow.getCell(i).setCellStyle(numStyle);
                    } else {
                        totalRow.getCell(i).setCellStyle(borderStyle);
                    }
                }
                totalRow.getCell(0).setCellValue("合计：");
                totalRow.getCell(headers.length-4).setCellStyle(numStyle);
                totalRow.getCell(headers.length-4).setCellValue(String.valueOf(M.getSumTotal1()));
                totalRow.getCell(headers.length-3).setCellValue(Double.parseDouble(String.valueOf(M.getSumTotal2())));
                totalRow.getCell(headers.length-2).setCellValue(Double.parseDouble(String.valueOf(M.getSumTotal3())));
                totalRow.getCell(headers.length-1).setCellValue(Double.parseDouble(String.valueOf(M.getSumTotal4())));
                hs.addMergedRegion(new Region(v_index, (short) 1, v_index,(short) 3));
            }
             
            v_index += 3;
            HSSFRow signRow = hs.createRow(v_index);
            signRow.setHeight((short) (128 * 5));
            hs.addMergedRegion(new Region(v_index, (short) 4, v_index, (short) 7));
            v_index += 1;
            HSSFRow dateRow = hs.createRow(v_index);
            dateRow.setHeight((short) (128 * 5));
            for (int i = 0; i < 8; i++) {
                signRow.createCell(i);
                signRow.getCell(i).setCellStyle(signStyle);
                dateRow.createCell(i);
                dateRow.getCell(i).setCellStyle(signStyle);
            }
            hs.addMergedRegion(new Region(v_index, (short) 4, v_index, (short) 7));
            signRow.getCell(4).setCellValue("深圳市汇商宏业商务服务有限公司");
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            String date = year + "年" + month + "月" + day + "日";
            dateRow.getCell(4).setCellValue(date);

            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }

    /**
     * 提供月消费下载表格的方法 
     * String title 文件名 
     * String[] headers 列名 
     * list<String[]> list 数据内容 
     * TotalCount M 数据统计
     * 
     * */
    public static boolean MonthExport(OutputStream os,String title, String[] headers, List<IssuerSZTEntity> list,TotalCount M) {
        try {
            // 声明一个工作薄
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet hs = wb.createSheet("月对账明细");
            // 设置标题字体
            HSSFFont titleFont = TitleFont(wb, "宋体", 14);
            // 设置边框样式
            HSSFCellStyle borderStyle = BorderStyle(wb);
            // 设置标题样式
            HSSFCellStyle titleStyle = TitleStyle(wb, titleFont);
            // 设置金额样式
            HSSFCellStyle moneyStyle = MoneyStyle(wb);
            // 百分比样式
            HSSFCellStyle percentStyle = PercentStyle(wb);
            // 左对齐有边框样式
            HSSFCellStyle leftBorderStyle = LeftBorderStyle(wb);
            // 签名样式
            HSSFCellStyle signStyle = SignStyle(wb);
            // 创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for (int i = 0; i < 8; i++) {
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 10));
                titleRow.getCell(i).setCellStyle(titleStyle);

            }
            hs.setColumnWidth(0, (short) (256 * 5));
            hs.setColumnWidth(1, (short) (256 * 25));
            // 合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) (headers.length - 1)));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256 * 4));

            // 创建明细项标题
            v_index += 1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128 * 3));
            for (int i = 0; i < headers.length; i++) {
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(borderStyle);
            }
            
            // for循环创建表头
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            int j= 0;
            // 生成数据
            for(IssuerSZTEntity model : list){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<headers.length;i++){
                    row.createCell(i);
                    if(i>2 && i<headers.length){
                        row.getCell(i).setCellStyle(moneyStyle);
                    }else{
                        row.getCell(i).setCellStyle(borderStyle);
                    }
                }
                row.getCell(0).setCellValue(++j);
                row.getCell(1).setCellStyle(leftBorderStyle);
                row.getCell(1).setCellValue(model.getBillId());
                row.getCell(2).setCellValue(model.getMerchName());
                row.getCell(3).setCellValue(model.getMccName());
                row.getCell(4).setCellStyle(percentStyle);
                row.getCell(4).setCellValue(model.getBenefitDis()/100);
                row.getCell(5).setCellValue(model.getTranNum());
                row.getCell(6).setCellValue(model.getTranAmt());
                row.getCell(7).setCellValue(model.getBenefitAmt());
                row.getCell(8).setCellValue(model.getSettleAmt());
            }

            if (M != null) {
                v_index += 1; // 创建商户底部合计栏 
                HSSFRow totalRow = hs.createRow(v_index);
                totalRow.setHeight((short) (128 * 3));
                for (int i = 0; i < headers.length; i++) {
                    totalRow.createCell(i);
                    if (i > 3 && i < headers.length) {
                        totalRow.getCell(i).setCellStyle(moneyStyle);
                    } else {
                        totalRow.getCell(i).setCellStyle(borderStyle);
                    }
                }
                totalRow.getCell(0).setCellValue("合计：");
                totalRow.getCell(5).setCellValue(String.valueOf(M.getSumTotal1()));
                totalRow.getCell(6).setCellValue(Double.parseDouble(String.valueOf(M.getSumTotal2())));
                totalRow.getCell(7).setCellValue(Double.parseDouble(String.valueOf(M.getSumTotal3())));
                totalRow.getCell(8).setCellValue(Double.parseDouble(String.valueOf(M.getSumTotal4())));
                hs.addMergedRegion(new Region(v_index, (short) 1, v_index,(short) 3));
            }
             
            v_index += 3;
            HSSFRow signRow = hs.createRow(v_index);
            signRow.setHeight((short) (128 * 5));
            hs.addMergedRegion(new Region(v_index, (short) (headers.length - 4), v_index, (short) (headers.length - 1)));
            v_index += 1;
            HSSFRow dateRow = hs.createRow(v_index);
            dateRow.setHeight((short) (128 * 5));
            for (int i = 0; i < (headers.length - 1); i++) {
                signRow.createCell(i);
                signRow.getCell(i).setCellStyle(signStyle);
                dateRow.createCell(i);
                dateRow.getCell(i).setCellStyle(signStyle);
            }
            hs.addMergedRegion(new Region(v_index, (short) (headers.length - 4), v_index, (short) (headers.length - 1)));
            signRow.getCell((headers.length - 4)).setCellValue("深圳市汇商宏业商务服务有限公司");
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            String date = year + "年" + month + "月" + day + "日";
            dateRow.getCell((headers.length - 4)).setCellValue(date);

            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }

    /**
     * 提供结算下载表格的方法 String[] title 表名+表1名+表2名 +结算公司 String[] data1
     * 表1单据标识(编号+结算周期{起始时间-结束时间}) String[] data2 表2单据标识(编号+结算周期{起始时间-结束时间})
     * String[] headers1 表1列名 String[] headers2 表2列名 list<String[]> list1 表1数据内容
     * list<String[]> list2 表2数据内容 String addrss 输出地址
     * 
     */
    public static boolean SettlementExport(OutputStream os,String[] title, String[] data1, String[] data2, String[] headers1, String[] headers2,
       List<String[]> list1, List<String[]> list2, MerchSettle merchSettle, MerchPrintLabel label) {
        try {
            // 声明一个工作薄
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sd = wb.createSheet("按门店查看对账明细");
            HSSFSheet sm = wb.createSheet("按商户查看对账明细");

            // 设置标题字体
            HSSFFont titleFont = TitleFont(wb, "宋体", 16);
            // 设置普通粗体样式
            HSSFFont blodFont = TitleFont(wb, "宋体", 11);
            // 设置标题样式
            HSSFCellStyle titleStyle = TitleStyle(wb, titleFont);
            // 设置商户申明样式
            HSSFCellStyle blodStyle = wb.createCellStyle();
            blodStyle.setFont(blodFont);
            blodStyle.setVerticalAlignment(CellStyle.VERTICAL_BOTTOM);
            // 设置边框样式
            HSSFCellStyle borderStyle = BorderStyle(wb);
            // 设置内容样式
            HSSFCellStyle contextStyle = wb.createCellStyle();
            contextStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
            // 设置金额样式
            HSSFCellStyle moneyStyle = MoneyStyle(wb);
            // 百分比样式
            HSSFCellStyle percentStyle = PercentStyle(wb);
            // 底部样式
            HSSFCellStyle bottomStyle = wb.createCellStyle();
            bottomStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
            // 左对齐
            HSSFCellStyle asignLeftStyle = AsignLeftStyle(wb);
            // 顶部右对齐
            HSSFCellStyle asignRightStyle = AsignRightStyle(wb);
            // 居中对齐
            HSSFCellStyle asignCenterStyle = AsignCenterStyle(wb);
            // 数字样式
            HSSFCellStyle numStyle = wb.createCellStyle();
            numStyle.setBorderBottom((short) 1);
            numStyle.setBorderTop((short) 1);
            numStyle.setBorderLeft((short) 1);
            numStyle.setBorderRight((short) 1);
            numStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            numStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

            // 创建标题项
            int sm_index = 0;
            int sd_index = 0;
            HSSFRow smTitleRow = sm.createRow(sm_index);
            HSSFRow sdTitleRow = sd.createRow(sd_index);
            for (int i = 0; i < 7; i++) {
                // 商户
                smTitleRow.createCell(i);
                sm.setColumnWidth(i, (short) (256 * 13));
                smTitleRow.getCell(i).setCellStyle(titleStyle);
                // 门店
                sdTitleRow.createCell(i);
                sd.setColumnWidth(i, (short) (256 * 13));
                sdTitleRow.getCell(i).setCellStyle(titleStyle);
            }
            // 合并商户标题栏
            sm.addMergedRegion(new Region(0, (short) 0, 0, (short) 6));
            smTitleRow.getCell(0).setCellValue(title[1]);
            smTitleRow.setHeight((short) (256 * 4));

            // 合并门店标题栏
            sd.addMergedRegion(new Region(0, (short) 0, 0, (short) 6));
            sdTitleRow.getCell(0).setCellValue(title[2]);
            sdTitleRow.setHeight((short) (256 * 4));

            // 创建声明行
            sm_index += 1;
            sd_index += 1;
            HSSFRow smDeclareRow = sm.createRow(sm_index);
            smDeclareRow.setHeight((short) (128 * 3));
            HSSFRow sdDeclareRow = sd.createRow(sd_index);
            sdDeclareRow.setHeight((short) (128 * 3));

            for (int i = 0; i < 7; i++) {
                smDeclareRow.createCell(i);
                smDeclareRow.getCell(i).setCellStyle(blodStyle);

                sdDeclareRow.createCell(i);
                sdDeclareRow.getCell(i).setCellStyle(blodStyle);
            }
            StringBuilder sDeclare = new StringBuilder();
            sDeclare.append("致：");
            sDeclare.append(data1[0]);

            // 合并声明行
            sm.addMergedRegion(new Region(sm_index, (short) 0, sm_index, (short) 6));
            sd.addMergedRegion(new Region(sd_index, (short) 0, sd_index, (short) 6));
            smDeclareRow.getCell(0).setCellValue(sDeclare.toString());
            sdDeclareRow.getCell(0).setCellValue(sDeclare.toString());

            // 创建第一行
            sm_index += 1;
            sd_index += 1;
            HSSFRow smTopRow = sm.createRow(sm_index);
            smTopRow.setHeight((short) (128 * 11));
            HSSFRow sdTopRow = sd.createRow(sd_index);
            sdTopRow.setHeight((short) (128 * 11));
            for (int i = 0; i < 7; i++) {
                smTopRow.createCell(i);
                smTopRow.getCell(i).setCellStyle(contextStyle);

                sdTopRow.createCell(i);
                sdTopRow.getCell(i).setCellStyle(contextStyle);
            }
            StringBuilder sContext = new StringBuilder();
            sContext.append("\r\n");
            sContext.append(label.getContext1());
            sContext.append("\r\n\r\n");
            sContext.append(label.getContext2());
            sContext.append("\r\n\r\n");
            // 合并第一行
            sm.addMergedRegion(new Region(sm_index, (short) 0, sm_index, (short) 6));
            sd.addMergedRegion(new Region(sd_index, (short) 0, sd_index, (short) 6));
            smTopRow.getCell(0).setCellValue(sContext.toString());
            sdTopRow.getCell(0).setCellValue(sContext.toString());

            // 创建联系方式行
            sm_index += 1;
            sd_index += 1;
            HSSFRow smLinkRow = sm.createRow(sm_index);
            smLinkRow.setHeight((short) (128 * 4));
            HSSFRow sdLinkRow = sd.createRow(sd_index);
            sdLinkRow.setHeight((short) (128 * 4));
            for (int i = 0; i < 7; i++) {
                smLinkRow.createCell(i);
                sdLinkRow.createCell(i);
            }
            smLinkRow.getCell(0).setCellStyle(asignLeftStyle);
            smLinkRow.getCell(2).setCellStyle(asignCenterStyle);
            smLinkRow.getCell(5).setCellStyle(asignRightStyle);
            sdLinkRow.getCell(0).setCellStyle(asignLeftStyle);
            sdLinkRow.getCell(2).setCellStyle(asignCenterStyle);
            sdLinkRow.getCell(5).setCellStyle(asignRightStyle);
            // 合并行
            sm.addMergedRegion(new Region(sm_index, (short) 0, sm_index, (short) 1));
            sm.addMergedRegion(new Region(sm_index, (short) 2, sm_index, (short) 4));
            sm.addMergedRegion(new Region(sm_index, (short) 5, sm_index, (short) 6));
            sd.addMergedRegion(new Region(sd_index, (short) 0, sd_index, (short) 1));
            sd.addMergedRegion(new Region(sm_index, (short) 2, sm_index, (short) 4));
            sd.addMergedRegion(new Region(sm_index, (short) 5, sm_index, (short) 6));

            smLinkRow.getCell(0).setCellValue( label.getTelItem() + label.getTelValue());
            sdLinkRow.getCell(0).setCellValue( label.getTelItem() + label.getTelValue());
            smLinkRow.getCell(2).setCellValue( label.getFaxItem() + label.getFaxValue());
            sdLinkRow.getCell(2).setCellValue( label.getFaxItem() + label.getFaxValue());
            smLinkRow.getCell(5).setCellValue( label.getLinkManItem() + label.getLinkManValue());
            sdLinkRow.getCell(5).setCellValue( label.getLinkManItem() + label.getLinkManValue());

            // 创建单据编号行
            sm_index += 1;
            sd_index += 1;
            HSSFRow smBillRow = sm.createRow(sm_index);
            smBillRow.setHeight((short) (128 * 4));
            HSSFRow sdBillRow = sd.createRow(sd_index);
            sdBillRow.setHeight((short) (128 * 4));
            for (int i = 0; i < 7; i++) {
                smBillRow.createCell(i);
                sdBillRow.createCell(i);
            }
            smBillRow.getCell(0).setCellStyle(asignLeftStyle);
            smBillRow.getCell(4).setCellStyle(asignRightStyle);
            sdBillRow.getCell(0).setCellStyle(asignLeftStyle);
            sdBillRow.getCell(4).setCellStyle(asignRightStyle);

            // 合并行
            sm.addMergedRegion(new Region(sm_index, (short) 0, sm_index, (short) 3));
            sm.addMergedRegion(new Region(sm_index, (short) 4, sm_index, (short) 6));
            sd.addMergedRegion(new Region(sd_index, (short) 0, sd_index, (short) 3));
            sd.addMergedRegion(new Region(sm_index, (short) 4, sm_index, (short) 6));
            smBillRow.getCell(0).setCellValue( label.getBillNoItem() + merchSettle.getMerchId());
            sdBillRow.getCell(0).setCellValue( label.getBillNoItem() + merchSettle.getMerchId());
            smBillRow.getCell(4).setCellValue( label.getSetTimeItem() + merchSettle.getSetBeginDate() + "至" + merchSettle.getSetEndDate());
            sdBillRow.getCell(4).setCellValue( label.getSetTimeItem() + merchSettle.getSetBeginDate() + "至" + merchSettle.getSetEndDate());

            // 创建明细项标题
            sm_index += 1;
            sd_index += 1;
            HSSFRow smDetailTitle = sm.createRow(sm_index);
            smDetailTitle.setHeight((short) (128 * 3));
            HSSFRow sdDetailTitle = sd.createRow(sd_index);
            sdDetailTitle.setHeight((short) (128 * 3));
            for (int i = 0; i < 7; i++) {
                smDetailTitle.createCell(i);
                smDetailTitle.getCell(i).setCellStyle(borderStyle);

                sdDetailTitle.createCell(i);
                sdDetailTitle.getCell(i).setCellStyle(borderStyle);
            }

            for (int i = 0; i < headers1.length; i++) {
                smDetailTitle.getCell(i).setCellValue(headers1[i]);
            }

            for (int i = 0; i < headers2.length; i++) {
                sdDetailTitle.getCell(i).setCellValue(headers2[i]);
            }

            sm.addMergedRegion(new Region(sm_index, (short) 5, sm_index, (short) 6));

            // 生成数据
            for (short i = 0; i < list1.size(); i++) {
                sm_index += 1;
                HSSFRow row = sm.createRow(sm_index);
                row.setHeight((short) (128 * 3));

                for (int h = 0; h < 7; h++) {
                    row.createCell(h);
                    row.getCell(h).setCellStyle(moneyStyle);
                }
                row.getCell(0).setCellStyle(borderStyle);
                row.getCell(1).setCellStyle(numStyle);
                row.getCell(3).setCellStyle(percentStyle);

                for (int j = 0; j < list1.get(i).length; j++) {
                    row.getCell(j).setCellValue(list1.get(i)[j]);
                }
                sm.addMergedRegion(new Region(sm_index, (short) 5, sm_index, (short) 6));
            }

            // 生成数据
            for (short i = 0; i < list2.size(); i++) {
                sd_index += 1;
                HSSFRow row = sd.createRow(sd_index);
                row.setHeight((short) (128 * 3));
                for (int h = 0; h < 7; h++) {
                    row.createCell(h);
                    row.getCell(h).setCellStyle(moneyStyle);
                }
                row.getCell(0).setCellStyle(borderStyle);
                row.getCell(1).setCellStyle(numStyle);
                row.getCell(4).setCellStyle(percentStyle);

                for (int j = 0; j < list2.get(i).length; j++) {
                    row.getCell(j).setCellValue(list2.get(i)[j]);
                }
            }

            // 创建声明行
            sm_index += 1;
            sd_index += 1;
            HSSFRow smRemarkRow = sm.createRow(sm_index);
            smRemarkRow.setHeight((short) (128 * 4));
            HSSFRow sdRemarkRow = sd.createRow(sd_index);
            sdRemarkRow.setHeight((short) (128 * 4));

            for (int i = 0; i < 7; i++) {
                smRemarkRow.createCell(i);
                smRemarkRow.getCell(i).setCellStyle(blodStyle);

                sdRemarkRow.createCell(i);
                sdRemarkRow.getCell(i).setCellStyle(blodStyle);
            }

            StringBuilder sRemark = new StringBuilder();
            sRemark.append("\r\n");
            sRemark.append(label.getNoticeTitle());

            // 合并声明行
            sm.addMergedRegion(new Region(sm_index, (short) 0, sm_index, (short) 6));
            sd.addMergedRegion(new Region(sd_index, (short) 0, sd_index, (short) 6));
            smRemarkRow.getCell(0).setCellValue(sRemark.toString());
            sdRemarkRow.getCell(0).setCellValue(sRemark.toString());

            // 创建底部说明行
            sm_index += 1;
            sd_index += 1;
            HSSFRow smBottomRow = sm.createRow(sm_index);
            smBottomRow.setHeight((short) (128 * 26));
            HSSFRow sdBottomRow = sd.createRow(sd_index);
            sdBottomRow.setHeight((short) (128 * 26));
            for (int i = 0; i < 7; i++) {
                smBottomRow.createCell(i);
                smBottomRow.getCell(i).setCellStyle(bottomStyle);

                sdBottomRow.createCell(i);
                sdBottomRow.getCell(i).setCellStyle(bottomStyle);
            }
            StringBuilder sBottomContext = new StringBuilder();
            sBottomContext.append("\r\n");
            sBottomContext.append(label.getNotice1());
            sBottomContext.append("\r\n\r\n\r\n\r\n\r\n\r\n");
            sBottomContext.append(label.getNotice2());
            sBottomContext.append("\r\n\r\n\r\n");
            sm.addMergedRegion(new Region(sm_index, (short) 0, sm_index, (short) 6));
            sd.addMergedRegion(new Region(sd_index, (short) 0, sd_index, (short) 6));
            smBottomRow.getCell(0).setCellValue(sBottomContext.toString());
            sdBottomRow.getCell(0).setCellValue(sBottomContext.toString());
            // 创建署名行
            sm_index += 1;
            sd_index += 1;
            HSSFRow smAsignRow = sm.createRow(sm_index);
            smAsignRow.setHeight((short) (128 * 12));
            HSSFRow sdAsignRow = sd.createRow(sd_index);
            sdAsignRow.setHeight((short) (128 * 12));

            for (int i = 0; i < 7; i++) {
                smAsignRow.createCell(i);
                sdAsignRow.createCell(i);
                smAsignRow.getCell(i).setCellStyle(asignLeftStyle);
                sdAsignRow.getCell(i).setCellStyle(asignLeftStyle);
            }

            sBottomContext = new StringBuilder();
            sBottomContext.append(title[3]);
            sBottomContext.append("\r\n\r\n");
            sBottomContext.append(label.getPersonSign());
            sBottomContext.append("\r\n\r\n");
            sBottomContext.append(label.getDateSign());
            sBottomContext.append("\r\n");
            sm.addMergedRegion(new Region(sm_index, (short) 0, sm_index, (short) 3));
            sd.addMergedRegion(new Region(sd_index, (short) 0, sd_index, (short) 3));
            sm.addMergedRegion(new Region(sm_index, (short) 4, sm_index, (short) 6));
            sd.addMergedRegion(new Region(sd_index, (short) 4, sd_index, (short) 6));
            smAsignRow.getCell(0).setCellValue(sBottomContext.toString());
            sdAsignRow.getCell(0).setCellValue(sBottomContext.toString());
            sBottomContext = new StringBuilder();
            sBottomContext.append(label.getCompanySign());
            sBottomContext.append("\r\n\r\n");
            sBottomContext.append(label.getPersonSign());
            sBottomContext.append("\r\n\r\n");
            sBottomContext.append(label.getDateSign());
            sBottomContext.append("\r\n");
            smAsignRow.getCell(4).setCellValue(sBottomContext.toString());
            sdAsignRow.getCell(4).setCellValue(sBottomContext.toString());
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (HeadlessException e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }
    
    
    public static boolean StoreTranExcel(OutputStream os,String title, String[] headers, List<StoreTranEntity> list) throws IOException {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(); 
            HSSFSheet hs = wb.createSheet(title);
            //设置标题字体
            HSSFFont titleFont = wb.createFont(); 
            titleFont.setFontName("宋体"); 
            //设置字体大小
            titleFont.setFontHeightInPoints((short) 16);
            //字体加粗
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            //表头字体
            HSSFFont headerFont = wb.createFont(); 
            headerFont.setFontName("宋体"); 
            //设置字体大小
            headerFont.setFontHeightInPoints((short) 11);
            //字体加粗
            headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            //设置边框样式
            HSSFCellStyle borderStyle = wb.createCellStyle(); 
            borderStyle.setBorderBottom((short) 1);
            borderStyle.setBorderTop((short) 1);
            borderStyle.setBorderLeft((short) 1);
            borderStyle.setBorderRight((short) 1);
            //设置标题样式
            HSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setFont(titleFont);
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            titleStyle.setBorderBottom((short) 1);
            titleStyle.setBorderTop((short) 1);
            titleStyle.setBorderLeft((short) 1);
            titleStyle.setBorderRight((short) 1);
            //表头样式
            HSSFCellStyle headerStyle = wb.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            headerStyle.setBorderBottom((short) 1);
            headerStyle.setBorderTop((short) 1);
            headerStyle.setBorderLeft((short) 1);
            headerStyle.setBorderRight((short) 1);
            //设置金额样式
            HSSFCellStyle moneyStyle = wb.createCellStyle();
            moneyStyle.setBorderBottom((short) 1);
            moneyStyle.setBorderTop((short) 1);
            moneyStyle.setBorderLeft((short) 1);
            moneyStyle.setBorderRight((short) 1);
            moneyStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            HSSFDataFormat dataFormat= wb.createDataFormat();
            moneyStyle.setDataFormat(dataFormat.getFormat("¥#,##0.00"));
            //创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for(int i=0;i<14;i++){
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 14)); 
                titleRow.getCell(i).setCellStyle(titleStyle);
                
            }
            //合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 13));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256*2));
            
            //创建明细项标题
            v_index+=1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128*3));
            for(int i=0;i<14;i++){
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(borderStyle);
                detailTitle.getCell(i).setCellStyle(headerStyle);
            }
            
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            
            //生成数据
            for(StoreTranEntity model : list){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<14;i++){
                    row.createCell(i);
                    row.getCell(i).setCellStyle(borderStyle);
                }
                row.getCell(0).setCellValue(model.getProvice()+model.getRegion());
                row.getCell(1).setCellValue(model.getMerchName());
                row.getCell(2).setCellValue(model.getTranNum());
                row.getCell(3).setCellValue(model.getTranAmount());
                row.getCell(3).setCellStyle(moneyStyle);
                row.getCell(4).setCellValue(model.getAvgAmount());
                row.getCell(4).setCellStyle(moneyStyle);
                row.getCell(5).setCellValue(model.getStartTranDate());
                
                row.getCell(6).setCellValue(model.getEndTranDate());
                row.getCell(7).setCellValue(model.getMaxTranNum());
                row.getCell(8).setCellValue(model.getNumTranDate());
                row.getCell(9).setCellValue(model.getMaxTranAmount());
                row.getCell(9).setCellStyle(moneyStyle);
                row.getCell(10).setCellValue(model.getAmountTranDate());
                row.getCell(11).setCellValue(model.getTotalTranDay());
                row.getCell(12).setCellValue(model.getTotalUntranDay());
                row.getCell(13).setCellValue(model.getContracter());
            }
            
            
//        //合计
//        v_index+=1;
//        HSSFRow row = hs.createRow(v_index);
//        row.setHeight((short) (128*3));
//        for(int i=0;i<14;i++){
//            row.createCell(i);
//            row.getCell(i).setCellStyle(borderStyle);
//        }
//        row.getCell(0).setCellValue("合计");
//        row.getCell(2).setCellValue(totalCount2.getSumTotal1()==null?"0":totalCount2.getSumTotal1().toString());
//        row.getCell(3).setCellValue(totalCount2.getSumTotal2()==null?0:totalCount2.getSumTotal2().doubleValue());
//        row.getCell(3).setCellStyle(moneyStyle);
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }

    public static boolean mccStoreExcel(OutputStream os,String title, String[] headers, List<MccStoreEntity> list) throws IOException {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(); 
            HSSFSheet hs = wb.createSheet(title);
            //设置标题字体
            HSSFFont titleFont = wb.createFont(); 
            titleFont.setFontName("宋体"); 
            //设置字体大小
            titleFont.setFontHeightInPoints((short) 16);
            //字体加粗
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            //设置边框样式
            HSSFCellStyle borderStyle = wb.createCellStyle(); 
            borderStyle.setBorderBottom((short) 1);
            borderStyle.setBorderTop((short) 1);
            borderStyle.setBorderLeft((short) 1);
            borderStyle.setBorderRight((short) 1);
            //设置标题样式
            HSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setFont(titleFont);
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            titleStyle.setBorderBottom((short) 1);
            titleStyle.setBorderTop((short) 1);
            titleStyle.setBorderLeft((short) 1);
            titleStyle.setBorderRight((short) 1);
            //设置小标题样式
            HSSFFont topTitleFont = wb.createFont(); 
            topTitleFont.setFontName("宋体"); 
            topTitleFont.setFontHeightInPoints((short) 10);
            topTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle topTitleStyle = wb.createCellStyle();
            topTitleStyle.setFont(topTitleFont);
            topTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            topTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            topTitleStyle.setBorderBottom((short) 1);
            topTitleStyle.setBorderTop((short) 1);
            topTitleStyle.setBorderLeft((short) 1);
            topTitleStyle.setBorderRight((short) 1);
            //数字样式
            HSSFCellStyle numberStyle = wb.createCellStyle(); 
            numberStyle.setBorderBottom((short) 1);
            numberStyle.setBorderTop((short) 1);
            numberStyle.setBorderLeft((short) 1);
            numberStyle.setBorderRight((short) 1);
            numberStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            //创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for(int i=0;i<8;i++){
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 14)); 
                titleRow.getCell(i).setCellStyle(titleStyle);
            }
            
            //合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 7));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256*2));
            
            //创建明细项标题
            v_index+=1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128*3));
            for(int i=0;i<8;i++){
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(topTitleStyle);
                
            }
            
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            
            //生成数据
            for(MccStoreEntity model : list){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<8;i++){
                    row.createCell(i);
                    row.getCell(i).setCellStyle(numberStyle);
                }
                row.getCell(0).setCellStyle(borderStyle);
                row.getCell(1).setCellStyle(borderStyle);
                row.getCell(0).setCellValue(model.getMakeDate());
                row.getCell(1).setCellValue(model.getProvice()+"-"+model.getRegion());
                row.getCell(2).setCellValue(model.getMccType1());
                row.getCell(3).setCellValue(model.getMccType2());
                row.getCell(4).setCellValue(model.getMccType3());
                row.getCell(5).setCellValue(model.getMccType4());
                row.getCell(6).setCellValue(model.getMccType6());
                row.getCell(7).setCellValue(model.getTotalNum());
            }
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }
    
    public static boolean termStatusExcel(OutputStream os,String title, String[] headers, List<TermStatusEntity> list) throws IOException {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(); 
            HSSFSheet hs = wb.createSheet(title);
            //设置标题字体
            HSSFFont titleFont = wb.createFont(); 
            titleFont.setFontName("宋体"); 
            //设置字体大小
            titleFont.setFontHeightInPoints((short) 16);
            //字体加粗
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            //设置表头字体
            HSSFFont headerFont = wb.createFont(); 
            headerFont.setFontName("宋体"); 
            //设置字体大小
            headerFont.setFontHeightInPoints((short) 11);
            //字体加粗
            headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            //设置边框样式
            HSSFCellStyle borderStyle = BorderStyle(wb);
            //设置标题样式
            HSSFCellStyle titleStyle = TitleStyle(wb, titleFont);
            //设置表头样式
            HSSFCellStyle headerStyle = HeaderStyle(wb, headerFont);
            //创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for(int i=0;i<9;i++){
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 14)); 
                titleRow.getCell(i).setCellStyle(titleStyle);
            }
            //合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 8));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256*2));
            
            //创建明细项标题
            v_index+=1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128*3));
            for(int i=0;i<9;i++){
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(headerStyle);
                
            }
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            //生成数据
            for(TermStatusEntity model : list){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<9;i++){
                    row.createCell(i);
                    row.getCell(i).setCellStyle(borderStyle);
                }
                row.getCell(0).setCellValue(model.getTermSeq());
                row.getCell(1).setCellValue(model.getRegion()+model.getArea());
                row.getCell(2).setCellValue(model.getMerchName());
                row.getCell(3).setCellValue(model.getStoreName());
                row.getCell(4).setCellValue(model.getContractName());
                row.getCell(5).setCellValue(model.getContractPhone());
                
                row.getCell(6).setCellValue(model.getFirstTranDate());
                row.getCell(7).setCellValue(model.getEndUseDate());
                row.getCell(8).setCellValue(model.getUnusedDays());
            }
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }
    
    public static boolean SignMerchExcel(OutputStream os,String title, String[] headers, List<SignMerch> list) throws IOException {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(); 
            HSSFSheet hs = wb.createSheet(title);
            //设置标题字体
            HSSFFont titleFont = wb.createFont(); 
            titleFont.setFontName("宋体"); 
            titleFont.setFontHeightInPoints((short) 16);
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            
            //小标题
            HSSFFont topTitleFont = wb.createFont(); 
            topTitleFont.setFontName("宋体"); 
            topTitleFont.setFontHeightInPoints((short) 10);
            topTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            
            //设置边框样式
            HSSFCellStyle borderStyle = BorderStyle(wb);
            //设置标题样式
            HSSFCellStyle titleStyle = TopTitleStyle(wb, titleFont);
            //设置小标题样式
            HSSFCellStyle topTitleStyle = TopTitleStyle(wb, topTitleFont);
            //设置金额样式
            HSSFCellStyle moneyStyle = MoneyStyle(wb);
            
            HSSFCellStyle numberStyle = NumStyle(wb);
            //创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for(int i=0;i<22;i++){
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 14)); 
                titleRow.getCell(i).setCellStyle(titleStyle);
                
            }
            //合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 21));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256*2));
            
            //创建明细项标题
            v_index+=1;
            HSSFRow topTitle = hs.createRow(v_index);
            v_index+=1;
            HSSFRow detailTitle = hs.createRow(v_index);
            topTitle.setHeight((short) (128*3));
            detailTitle.setHeight((short) (128*3));
            for(int i=0;i<22;i++){
                topTitle.createCell(i);
                topTitle.getCell(i).setCellStyle(topTitleStyle);
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(topTitleStyle);
            }
            hs.addMergedRegion(new Region(v_index-1, (short) 0, v_index-1, (short) 1));
            hs.addMergedRegion(new Region(v_index-1, (short) 2, v_index-1, (short) 4));
            hs.addMergedRegion(new Region(v_index-1, (short) 5, v_index-1, (short) 7));
            
            hs.addMergedRegion(new Region(v_index-1, (short) 8, v_index-1, (short) 10));
            hs.addMergedRegion(new Region(v_index-1, (short) 11, v_index-1, (short) 16));
            hs.addMergedRegion(new Region(v_index-1, (short) 17, v_index-1, (short) 21));
            
            topTitle.getCell(0).setCellValue("基本信息");
            topTitle.getCell(2).setCellValue("新建信息");
            topTitle.getCell(5).setCellValue("解约信息");
            topTitle.getCell(8).setCellValue("总计信息");
            topTitle.getCell(11).setCellValue("交易信息");
            topTitle.getCell(17).setCellValue("结算信息");
            
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            //数据
            for(SignMerch model : list){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                
                row.setHeight((short) (128*3));
                
                for(int i=0;i<22;i++){
                    row.createCell(i);
                    row.getCell(i).setCellStyle(numberStyle);
                }
                row.getCell(0).setCellStyle(borderStyle);
                row.getCell(1).setCellStyle(borderStyle);
                row.getCell(0).setCellValue(model.getMakeDate());
                row.getCell(1).setCellValue(model.getProvice()+"-"+model.getRegion());
                
                row.getCell(2).setCellValue(model.getMerSignNum());
                row.getCell(3).setCellValue(model.getStoreSignNum());
                row.getCell(4).setCellValue(model.getTermSignNum());
                
                row.getCell(5).setCellValue(model.getMerCancelNum());
                row.getCell(6).setCellValue(model.getStoreCancelNum());
                row.getCell(7).setCellValue(model.getTermCancelNum());
                
                row.getCell(8).setCellValue(model.getMerTotalNum());
                row.getCell(9).setCellValue(model.getStoreTotalNum());
                row.getCell(10).setCellValue(model.getTermTotalNum());
                
                row.getCell(11).setCellValue(model.getTranNum());
                row.getCell(12).setCellValue(Double.parseDouble(String.valueOf(model.getTranAmount())));
                row.getCell(12).setCellStyle(moneyStyle);
                row.getCell(13).setCellValue(model.getTranMerchNum());
                row.getCell(14).setCellValue(model.getTranStoreNum());
                row.getCell(15).setCellValue(model.getTranTermNum());
                row.getCell(16).setCellValue(model.getUseTermNum());
                
                row.getCell(17).setCellValue(model.getSendNum());
                
                row.getCell(18).setCellValue(Double.parseDouble(String.valueOf(model.getSendAmount())));
                row.getCell(18).setCellStyle(moneyStyle);
                row.getCell(19).setCellValue(model.getSendMerchNum());
                row.getCell(20).setCellValue(model.getSendStoreNum());
                row.getCell(21).setCellValue(model.getSendTermNum());
            }
//        //合计栏
//        if(signMerchList!=null && signMerchList.size()>0)
//        {
//            v_index+=1;
//            HSSFRow totalRow = hs.createRow(v_index);
//            totalRow.setHeight((short) (128*3));
//            for(int i=0;i<22;i++){
//                totalRow.createCell(i);
//                totalRow.getCell(i).setCellStyle(numberStyle);
//            }
//            totalRow.getCell(0).setCellStyle(borderStyle);
//            totalRow.getCell(0).setCellValue("合计：");
//            
//            hs.addMergedRegion(new Region(v_index, (short) 8, v_index, (short) 10));
//            hs.addMergedRegion(new Region(v_index, (short) 13, v_index, (short) 16));
//            hs.addMergedRegion(new Region(v_index, (short) 19, v_index, (short) 21));
//            totalRow.getCell(2).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal1())));
//            totalRow.getCell(3).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal4())));
//            totalRow.getCell(4).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal7())));
//            
//            totalRow.getCell(5).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal2())));
//            totalRow.getCell(6).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal5())));
//            totalRow.getCell(7).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal8())));
//            
//            totalRow.getCell(11).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal10())));
//            totalRow.getCell(12).setCellStyle(moneyStyle);
//            totalRow.getCell(12).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal11())));
//            totalRow.getCell(17).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal12())));
//            totalRow.getCell(18).setCellStyle(moneyStyle);
//            totalRow.getCell(18).setCellValue(Double.parseDouble(String.valueOf(ctotalCount.getSumTotal13())));
//        }
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }
    
    public static boolean traninfoExcel(OutputStream os,String title, String[] headers, List<MerchTran> merch) {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(); 
            HSSFSheet hs = wb.createSheet(title);
            //设置标题字体
            HSSFFont titleFont = wb.createFont(); 
            titleFont.setFontName("宋体"); 
            //设置字体大小
            titleFont.setFontHeightInPoints((short) 16);
            //字体加粗
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            
            //设置边框样式
            HSSFCellStyle borderStyle = wb.createCellStyle(); 
            borderStyle.setBorderBottom((short) 1);
            borderStyle.setBorderTop((short) 1);
            borderStyle.setBorderLeft((short) 1);
            borderStyle.setBorderRight((short) 1);
            //设置标题样式
            HSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setFont(titleFont);
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            titleStyle.setBorderBottom((short) 1);
            titleStyle.setBorderTop((short) 1);
            titleStyle.setBorderLeft((short) 1);
            titleStyle.setBorderRight((short) 1);
            //设置小标题样式
            HSSFFont topTitleFont = wb.createFont(); 
            topTitleFont.setFontName("宋体"); 
            topTitleFont.setFontHeightInPoints((short) 10);
            topTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle topTitleStyle = wb.createCellStyle();
            topTitleStyle.setFont(topTitleFont);
            topTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            topTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            topTitleStyle.setBorderBottom((short) 1);
            topTitleStyle.setBorderTop((short) 1);
            topTitleStyle.setBorderLeft((short) 1);
            topTitleStyle.setBorderRight((short) 1);
            //设置金额样式
            HSSFCellStyle moneyStyle = wb.createCellStyle();
            moneyStyle.setBorderBottom((short) 1);
            moneyStyle.setBorderTop((short) 1);
            moneyStyle.setBorderLeft((short) 1);
            moneyStyle.setBorderRight((short) 1);
            moneyStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            HSSFDataFormat dataFormat= wb.createDataFormat();
            moneyStyle.setDataFormat(dataFormat.getFormat("¥#,##0.00"));
            //创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for(int i=0;i<12;i++){
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 14)); 
                titleRow.getCell(i).setCellStyle(titleStyle);
            }
            hs.setColumnWidth(0,  (short) (256 * 16));
            hs.setColumnWidth(1,  (short) (256 * 26));
            hs.setColumnWidth(2,  (short) (256 * 16));
            hs.setColumnWidth(7,  (short) (256 * 18));
            //合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 11));
            titleRow.getCell(0).setCellValue("交易明细报表");
            titleRow.setHeight((short) (256*2));
            
            //创建明细项标题
            v_index+=1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128*3));
            for(int i=0;i<12;i++){
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(topTitleStyle);
                
            }
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            Map<String,String> statusMap = new HashMap<String,String>();
            statusMap.put("0", "预计");
            statusMap.put("1", "成功");
            statusMap.put("2", "失败");
            //生成数据
            for(MerchTran model : merch){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<12;i++){
                    row.createCell(i);
                    row.getCell(i).setCellStyle(borderStyle);
                }
                row.getCell(0).setCellValue(model.getMerchId());
                row.getCell(1).setCellValue(model.getMerchName());
                row.getCell(2).setCellValue(model.getStoreName());
                row.getCell(3).setCellValue(model.getTermId());
                row.getCell(4).setCellValue(model.getTranType());
                
                row.getCell(5).setCellValue(Double.parseDouble(String.valueOf(model.getTranAmt())));
                row.getCell(5).setCellStyle(moneyStyle);
                row.getCell(6).setCellValue(statusMap.get(model.getTranStatus()));
                String formatTime = DateUtils.formatToformat(model.getTranDate().concat(model.getTranTime()), "yyyyMMddhhmmss", "yyyy-MM-dd HH:mm:ss");
                row.getCell(7).setCellValue(formatTime);
                row.getCell(8).setCellValue(model.getCardNo());
                row.getCell(9).setCellValue("");
                row.getCell(10).setCellValue(model.getTranSerial());
                row.getCell(11).setCellValue("");
            }
//        //合计栏
//        if(tranInfoList!=null && tranInfoList.size()>0){
//            v_index+=1;
//            HSSFRow row = hs.createRow(v_index);
//            row.setHeight((short) (128*3));
//            for(int i=0;i<12;i++){
//                row.createCell(i);
//                row.getCell(i).setCellStyle(borderStyle);
//            }
//            row.getCell(0).setCellValue("合计：");
//            row.getCell(5).setCellValue(Double.parseDouble(String.valueOf(totalCount.getSumTotal1())));
//            row.getCell(5).setCellStyle(moneyStyle);
//            hs.addMergedRegion(new Region(v_index, (short) 1, v_index, (short) 4));
//            hs.addMergedRegion(new Region(v_index, (short) 6, v_index, (short) 11));
//        }
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    
    }
    
    public static boolean merchSetExcel(OutputStream os,String title, String[] headers, List<MerchPayment> merch) {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(); 
            HSSFSheet hs = wb.createSheet(title);
            //设置标题字体
            HSSFFont titleFont = wb.createFont(); 
            titleFont.setFontName("宋体"); 
            //设置字体大小
            titleFont.setFontHeightInPoints((short) 16);
            //字体加粗
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            
            //设置边框样式
            HSSFCellStyle borderStyle = wb.createCellStyle(); 
            borderStyle.setBorderBottom((short) 1);
            borderStyle.setBorderTop((short) 1);
            borderStyle.setBorderLeft((short) 1);
            borderStyle.setBorderRight((short) 1);
            //设置标题样式
            HSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setFont(titleFont);
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            titleStyle.setBorderBottom((short) 1);
            titleStyle.setBorderTop((short) 1);
            titleStyle.setBorderLeft((short) 1);
            titleStyle.setBorderRight((short) 1);
            //设置小标题样式
            HSSFFont topTitleFont = wb.createFont(); 
            topTitleFont.setFontName("宋体"); 
            topTitleFont.setFontHeightInPoints((short) 10);
            topTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle topTitleStyle = wb.createCellStyle();
            topTitleStyle.setFont(topTitleFont);
            topTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            topTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            topTitleStyle.setBorderBottom((short) 1);
            topTitleStyle.setBorderTop((short) 1);
            topTitleStyle.setBorderLeft((short) 1);
            topTitleStyle.setBorderRight((short) 1);
            //设置金额样式
            HSSFCellStyle moneyStyle = wb.createCellStyle();
            moneyStyle.setBorderBottom((short) 1);
            moneyStyle.setBorderTop((short) 1);
            moneyStyle.setBorderLeft((short) 1);
            moneyStyle.setBorderRight((short) 1);
            moneyStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            HSSFDataFormat dataFormat= wb.createDataFormat();
            moneyStyle.setDataFormat(dataFormat.getFormat("¥#,##0.00"));
            
            HSSFCellStyle numStyle = NumStyle(wb);
            //创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for(int i=0;i<12;i++){
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 14)); 
                titleRow.getCell(i).setCellStyle(titleStyle);
            }
            hs.setColumnWidth(0,  (short) (256 * 16));
            hs.setColumnWidth(1,  (short) (256 * 26));
            hs.setColumnWidth(2,  (short) (256 * 16));
            hs.setColumnWidth(7,  (short) (256 * 18));
            //合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 11));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256*2));
            
            //创建明细项标题
            v_index+=1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128*3));
            for(int i=0;i<12;i++){
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(topTitleStyle);
                
            }
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            //生成数据
            for(MerchPayment model : merch){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<12;i++){
                    row.createCell(i);
                    if(i==2){
                        row.getCell(i).setCellStyle(numStyle);
                    }else if(2<i && i<6){
                        row.getCell(i).setCellStyle(moneyStyle);
                    }else{
                        row.getCell(i).setCellStyle(borderStyle);
                    }
                }
                
                row.getCell(0).setCellValue(model.getMerchName());
                row.getCell(1).setCellValue(model.getBillType());
                row.getCell(2).setCellValue(model.getTranNum());
                row.getCell(3).setCellValue(model.getTranAmt().toString());
                row.getCell(4).setCellValue(model.getInFee().toString());
                
                if(model.getBillType().equals("11") || model.getBillType().equals("12")){
                    row.getCell(5).setCellValue(model.getOutFee().toString());
                }else if(model.getBillType().equals("37")) {
                    row.getCell(5).setCellValue(model.getOutAmt().toString());
                }

                row.getCell(6).setCellValue(model.getSetBeginDate());
                row.getCell(7).setCellValue(model.getSetEndDate());
                row.getCell(8).setCellValue(model.getAccountName());
                row.getCell(9).setCellValue(model.getAccountNo());
                row.getCell(10).setCellValue(model.getAccountBank());
                row.getCell(11).setCellValue(model.getFinanceTel());
            }
//        //合计栏
//        if(tranInfoList!=null && tranInfoList.size()>0){
//            v_index+=1;
//            HSSFRow row = hs.createRow(v_index);
//            row.setHeight((short) (128*3));
//            for(int i=0;i<12;i++){
//                row.createCell(i);
//                row.getCell(i).setCellStyle(borderStyle);
//            }
//            row.getCell(0).setCellValue("合计：");
//            row.getCell(5).setCellValue(Double.parseDouble(String.valueOf(totalCount.getSumTotal1())));
//            row.getCell(5).setCellStyle(moneyStyle);
//            hs.addMergedRegion(new Region(v_index, (short) 1, v_index, (short) 4));
//            hs.addMergedRegion(new Region(v_index, (short) 6, v_index, (short) 11));
//        }
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    
    }
    
    /**
     * 交易明细报表导出
     * 
     * */
    public static boolean TranSetExport(OutputStream os,String title, String[] headers, List<TranSetDetail> tranSet) {
        try {
        	HSSFWorkbook wb = new HSSFWorkbook(); 
            HSSFSheet hs = wb.createSheet(title);
            //设置标题字体
            HSSFFont titleFont = wb.createFont(); 
            titleFont.setFontName("宋体"); 
            //设置字体大小
            titleFont.setFontHeightInPoints((short) 16);
            //字体加粗
            titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            
            //设置边框样式
            HSSFCellStyle borderStyle = wb.createCellStyle(); 
            borderStyle.setBorderBottom((short) 1);
            borderStyle.setBorderTop((short) 1);
            borderStyle.setBorderLeft((short) 1);
            borderStyle.setBorderRight((short) 1);
            //设置标题样式
            HSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setFont(titleFont);
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            titleStyle.setBorderBottom((short) 1);
            titleStyle.setBorderTop((short) 1);
            titleStyle.setBorderLeft((short) 1);
            titleStyle.setBorderRight((short) 1);
            //设置小标题样式
            HSSFFont topTitleFont = wb.createFont(); 
            topTitleFont.setFontName("宋体"); 
            topTitleFont.setFontHeightInPoints((short) 10);
            topTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle topTitleStyle = wb.createCellStyle();
            topTitleStyle.setFont(topTitleFont);
            topTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
            topTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            topTitleStyle.setBorderBottom((short) 1);
            topTitleStyle.setBorderTop((short) 1);
            topTitleStyle.setBorderLeft((short) 1);
            topTitleStyle.setBorderRight((short) 1);
            //设置金额样式
            HSSFCellStyle moneyStyle = wb.createCellStyle();
            moneyStyle.setBorderBottom((short) 1);
            moneyStyle.setBorderTop((short) 1);
            moneyStyle.setBorderLeft((short) 1);
            moneyStyle.setBorderRight((short) 1);
            moneyStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            HSSFDataFormat dataFormat= wb.createDataFormat();
            moneyStyle.setDataFormat(dataFormat.getFormat("¥#,##0.00"));
            
            HSSFCellStyle numStyle = NumStyle(wb);
            //创建标题项
            int v_index = 0;
            HSSFRow titleRow = hs.createRow(v_index);
            for(int i=0;i<12;i++){
                titleRow.createCell(i);
                hs.setColumnWidth(i, (short) (256 * 14)); 
                titleRow.getCell(i).setCellStyle(titleStyle);
            }
            hs.setColumnWidth(0,  (short) (256 * 16));
            hs.setColumnWidth(1,  (short) (256 * 26));
            hs.setColumnWidth(2,  (short) (256 * 16));
            hs.setColumnWidth(7,  (short) (256 * 18));
            //合并标题栏
            hs.addMergedRegion(new Region(0, (short) 0, 0, (short) 11));
            titleRow.getCell(0).setCellValue(title);
            titleRow.setHeight((short) (256*2));
            
            //创建明细项标题
            v_index+=1;
            HSSFRow detailTitle = hs.createRow(v_index);
            detailTitle.setHeight((short) (128*3));
            for(int i=0;i<12;i++){
                detailTitle.createCell(i);
                detailTitle.getCell(i).setCellStyle(topTitleStyle);
                
            }
            for (int i = 0; i < headers.length; i++) {
                detailTitle.getCell(i).setCellValue(headers[i]);
            }
            //生成数据
            for(TranSetDetail model : tranSet){
                v_index+=1;
                HSSFRow row = hs.createRow(v_index);
                row.setHeight((short) (128*3));
                for(int i=0;i<12;i++){
                    row.createCell(i);
                    if(i == 5){
                    	row.getCell(i).setCellStyle(numStyle);
                    }else if(i == 4 || (5<i && i<8)){
                        row.getCell(i).setCellStyle(moneyStyle);
                    }else{
                        row.getCell(i).setCellStyle(borderStyle);
                    }
                }
                
                row.getCell(0).setCellValue(model.getMerchId());
                row.getCell(1).setCellValue(model.getMerchName());
                row.getCell(2).setCellValue(model.getIssuerName());
                row.getCell(3).setCellValue(model.getTranType());
                row.getCell(4).setCellValue(model.getTranAmt());
                if("1".equals(model.getCdFlag())){
                    row.getCell(5).setCellValue(model.getAccepFeeDis()+"%");
                }else if("0".equals(model.getCdFlag())) {
                    row.getCell(5).setCellValue(model.getAccepFeeDis()+"%");
                }
                row.getCell(6).setCellValue(model.getTranAmt() - model.getMerchIncome());
                row.getCell(7).setCellValue(model.getMerchIncome());
                row.getCell(8).setCellValue(model.getBatNo());
                row.getCell(9).setCellValue(model.getTermLs());
                row.getCell(10).setCellValue(model.getSetDate());
                row.getCell(11).setCellValue(model.getTranDate());
            }
//        //合计栏
//        if(tranInfoList!=null && tranInfoList.size()>0){
//            v_index+=1;
//            HSSFRow row = hs.createRow(v_index);
//            row.setHeight((short) (128*3));
//            for(int i=0;i<12;i++){
//                row.createCell(i);
//                row.getCell(i).setCellStyle(borderStyle);
//            }
//            row.getCell(0).setCellValue("合计：");
//            row.getCell(5).setCellValue(Double.parseDouble(String.valueOf(totalCount.getSumTotal1())));
//            row.getCell(5).setCellStyle(moneyStyle);
//            hs.addMergedRegion(new Region(v_index, (short) 1, v_index, (short) 4));
//            hs.addMergedRegion(new Region(v_index, (short) 6, v_index, (short) 11));
//        }
            try {
                wb.write(os);
                log.info(title+"导出成功!");
                return true;
            } catch (FileNotFoundException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                log.info(title+"导出失败!");
                e.printStackTrace();
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.info(title+"导出失败!");
            return false;
        }
    }
    
    
    
    /**
     * 设置头信息
     * @throws UnsupportedEncodingException 
     */
    public static void setResponseHeader(String fileName,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0)
        {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");//firefox浏览器
        }
        else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
        {
            fileName = URLEncoder.encode(fileName, "UTF-8");//IE浏览器
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
    }
    
    // 设置标题字体
    public static HSSFFont TitleFont(HSSFWorkbook wb,String FontName,int FontSize) {
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontName(FontName);
        // 设置字体大小
        titleFont.setFontHeightInPoints((short) FontSize);
        // 字体加粗
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        return titleFont;
    }
    // 设置文字样式
    public static HSSFCellStyle BorderStyle(HSSFWorkbook wb) {
        HSSFCellStyle borderStyle = wb.createCellStyle();
        borderStyle.setBorderBottom((short) 1);
        borderStyle.setBorderTop((short) 1);
        borderStyle.setBorderLeft((short) 1);
        borderStyle.setBorderRight((short) 1);
        borderStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        borderStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return borderStyle;
    }
    
    // 设置标题样式
    public static HSSFCellStyle TitleStyle(HSSFWorkbook wb,HSSFFont titleFont) {
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        return titleStyle;
    }

    // 设置金额样式
    public static HSSFCellStyle MoneyStyle(HSSFWorkbook wb) {
        HSSFCellStyle moneyStyle = wb.createCellStyle();
        moneyStyle.setBorderBottom((short) 1);
        moneyStyle.setBorderTop((short) 1);
        moneyStyle.setBorderLeft((short) 1);
        moneyStyle.setBorderRight((short) 1);
        moneyStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        moneyStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        HSSFDataFormat dataFormat = wb.createDataFormat();
        moneyStyle.setDataFormat(dataFormat.getFormat("#,##0.00"));
        return moneyStyle;
    }

    // 百分比样式
    public static HSSFCellStyle PercentStyle(HSSFWorkbook wb) {
        HSSFCellStyle percentStyle = wb.createCellStyle();
        percentStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        percentStyle.setBorderBottom((short) 1);
        percentStyle.setBorderTop((short) 1);
        percentStyle.setBorderLeft((short) 1);
        percentStyle.setBorderRight((short) 1);
        percentStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        percentStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return percentStyle;
    }
    
    // 左对齐无边框
    public static HSSFCellStyle AsignLeftStyle(HSSFWorkbook wb) {
        HSSFCellStyle asignLeftStyle = wb.createCellStyle();
        asignLeftStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        asignLeftStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        return asignLeftStyle;
    }
 
    // 左对齐有边框样式
    public static HSSFCellStyle LeftBorderStyle(HSSFWorkbook wb) {
        HSSFCellStyle leftBorderStyle = wb.createCellStyle();
        leftBorderStyle.setBorderBottom((short) 1);
        leftBorderStyle.setBorderTop((short) 1);
        leftBorderStyle.setBorderLeft((short) 1);
        leftBorderStyle.setBorderRight((short) 1);
        leftBorderStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        leftBorderStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return leftBorderStyle;
    }
    
    // 居中对齐
    public static HSSFCellStyle AsignCenterStyle(HSSFWorkbook wb) {
        HSSFCellStyle asignCenterStyle = wb.createCellStyle();
        asignCenterStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        asignCenterStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        return asignCenterStyle;
    }
    
    // 顶部右对齐
    public static HSSFCellStyle AsignRightStyle(HSSFWorkbook wb) {
        HSSFCellStyle asignRightStyle = wb.createCellStyle();
        asignRightStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        asignRightStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        return asignRightStyle;
    }

    // 签名样式
    public static HSSFCellStyle SignStyle(HSSFWorkbook wb) {
        HSSFCellStyle signStyle = wb.createCellStyle();
        signStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        signStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return signStyle;
    }

    // 日期样式
    public static HSSFCellStyle DateStyle(HSSFWorkbook wb) {
        HSSFCellStyle dateStyle = wb.createCellStyle();
        HSSFDataFormat format = wb.createDataFormat();
        dateStyle.setDataFormat(format.getFormat("yyyy年m月d日"));
        dateStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        dateStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return dateStyle;
    }
    
    // 数字样式
    public static HSSFCellStyle NumStyle(HSSFWorkbook wb) {
        HSSFCellStyle numStyle = wb.createCellStyle();
        numStyle.setBorderBottom((short) 1);
        numStyle.setBorderTop((short) 1);
        numStyle.setBorderLeft((short) 1);
        numStyle.setBorderRight((short) 1);
        numStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        numStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return numStyle;
    }
    
    //设置表头样式
    public static HSSFCellStyle HeaderStyle(HSSFWorkbook wb,HSSFFont headerFont) {
        HSSFCellStyle headerStyle = wb.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
        headerStyle.setBorderBottom((short) 1);
        headerStyle.setBorderTop((short) 1);
        headerStyle.setBorderLeft((short) 1);
        headerStyle.setBorderRight((short) 1);
        return headerStyle;
    }
    
  //设置小标题样式
    public static HSSFCellStyle TopTitleStyle(HSSFWorkbook wb,HSSFFont Font) {
        HSSFCellStyle topTitleStyle = wb.createCellStyle();
        topTitleStyle.setFont(Font);
        topTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
        topTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        topTitleStyle.setBorderBottom((short) 1);
        topTitleStyle.setBorderTop((short) 1);
        topTitleStyle.setBorderLeft((short) 1);
        topTitleStyle.setBorderRight((short) 1);
        return topTitleStyle;
    }
}
