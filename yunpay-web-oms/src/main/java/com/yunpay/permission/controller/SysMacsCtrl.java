package com.yunpay.permission.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunpay.common.core.dwz.DWZ;
import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.service.TermsService;

@Controller
@RequestMapping("/sys/mac")
public class SysMacsCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysMacsCtrl.class);

    @Autowired
    private TermsService termService;

    /**
     * 分页查询
     * */
    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:mac:view")
    @RequestMapping("/list")
    public String listSysTerm(HttpServletRequest req, PageParam pageParam,
            TermEntity termEntity, Model model) {
        try {
            PageBean pageBean = termService.listPage(pageParam, termEntity);
            model.addAttribute(pageBean);
            model.addAttribute("Findselect", FindMACselect());
            model.addAttribute("MacStatus", termEntity.getMacStatus());
            return "modules/mac/macList";
        } catch (Exception e) {
            log.error("== listSysMac exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    /**
     * 进入单条数据添加页面
     * 
     * */
    @RequiresPermissions("sys:mac:add")
    @RequestMapping("/addUI")
    public String addSysmacUI(HttpServletRequest req, Model model) {
        try {
            return "modules/mac/macAdd";
        } catch (Exception e) {
            log.error("== addSysMacUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    /**
     * 单条数据添加
     * 
     * */
    @RequiresPermissions("sys:mac:add")
    @RequestMapping("/add")
    public String addSysmac(HttpServletRequest req, Model model,
            TermEntity termEntity, DwzAjax dwz) {
        try {
            // 创建人
            termEntity.setCreateUser(getSysUser().getLoginName());
            // 状态码
            termEntity.setMacStatus("1");
            if (termService.addMacTerm(termEntity) > 0) {
                return operateSuccess(model, dwz);
            }
            return operateError("机器入库失败", model);
        } catch (Exception e) {
            log.error("== addSysMac exception:", e);
            if (e.toString().indexOf("ORA-00001") > 0) {
                return operateError("机器已存在", model);
            }
            return operateError("机器入库失败", model);
        }
    }

    /**
     * 根据termSeq删除
     * 
     * */
    @RequiresPermissions("sys:mac:delete")
    @RequestMapping("/delete")
    public String delSysmac(HttpServletRequest req, Model model,
            String termSeq, DwzAjax dwz) {
        try {
            TermEntity t =  new TermEntity();
            t.setTermSeq(termSeq);
            TermEntity termEntity = termService.selectbytermSeq(t);
            if (termEntity == null) {
                return operateError("获取机器信息失败", model);
            }
            if ("1".equals(termEntity.getMacStatus())) {
                if (termService.delMacTerm(termSeq) > 0) {
                    return operateSuccess(model, dwz);
                } else {
                    return operateError("删除机器失败", model);
                }
            } else {
                return operateError("该机器已出库，不能删除！", model);
            }
        } catch (Exception e) {
            log.error("== deleteSysMac exception:", e);
            return operateError("删除机器失败", model);
        }
    }

    /**
     * 进入修改页面
     * 
     * */
    @RequiresPermissions("sys:mac:edit")
    @RequestMapping("/editUI")
    public String editSysmacUI(HttpServletRequest req, String termSeq,
            Model model) {
        try {
            TermEntity t =  new TermEntity();
            t.setTermSeq(termSeq);
            model.addAttribute("MAC", termService.selectbytermSeq(t));
            return "modules/mac/macEdit";
        } catch (Exception e) {
            log.error("== editSysMacUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    /**
     * 进行修改
     * 
     * */
    @RequiresPermissions("sys:mac:edit")
    @RequestMapping("/edit")
    public String editSysmac(HttpServletRequest req, TermEntity termEntity,
            String termSeq, Model model, DwzAjax dwz) {
        try {
            if (termService.selectbytermSeq(termEntity) != null){
                return operateError("机器信息已存在，请重新输入机器信息", model);
            }
            
            termEntity.setCreateUser(getSysUser().getLoginName());
            if (termService.editMacTerm(termEntity) > 0) {
                return operateSuccess(model, dwz);
            }
            return operateError("修改机器信息失败", model);
        } catch (Exception e) {
            log.error("== editSysMac exception:", e);
            return operateError("修改机器信息失败", model);
        }
    }

    /**
     * 进入批量添加页面
     * 
     * */
    @RequiresPermissions("sys:mac:add")
    @RequestMapping("/macInputUI")
    public String macInputUI(HttpServletRequest req, String termSeq, Model model) {
        try {
            return "modules/mac/macInput";
        } catch (Exception e) {
            log.error("== addSysMacInputUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    /**
     * 进行批量添加
     * 
     * */
    @RequiresPermissions("sys:mac:add")
    @RequestMapping("/macInput")
    public String macInput(HttpServletRequest req, TermEntity termEntity,
            Model model, DwzAjax dwz) {
        try {
            StringBuilder failureMac = new StringBuilder();
            StringBuilder exitMac = new StringBuilder();
            List<TermEntity> macInitList = null;
            int okCount = 0;
            int dataCount = 0;

            req.setCharacterEncoding("utf-8");
            String Path = req.getServletPath();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ResourceBundle systemConfig = ResourceBundle.getBundle("config/system", Locale.getDefault());
            String uploadSysUrl = systemConfig.getString("merchEleSignUrl");
//            String uploadSysUrl = "D:/xls";
            factory.setRepository(new File(uploadSysUrl));
            factory.setSizeThreshold(1024 * 1024);
            factory.setRepository(new File(Path));

            ServletFileUpload upload = new ServletFileUpload(factory);
            @SuppressWarnings("rawtypes")
            List list = upload.parseRequest(req);
            @SuppressWarnings("rawtypes")
            Iterator itr = list.iterator();

            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {
                } else {
                    if (item.getName() != null && !item.getName().equals("")) {

                        String fileName = item.getName();
                        // 上传文件的保存路径
                        String path = uploadSysUrl + "/" +"Macs_"+ fileName;
                        File file = new File(path);
                        item.write(file);

                        macInitList = readExcel(path);
                        dataCount = macInitList == null ? 0 : macInitList.size();
                        for (TermEntity mac : macInitList) {
                            try {
                                if (termService.addMacTerm(mac) < 1) {
                                    // 记录添加失败的终端序号
                                    failureMac.append(mac.getTermSeq()).append(",");
                                } else {
                                    // 记录添加成功的终端数
                                    okCount++;
                                }
                            } catch (Exception e) {
                                if (e.toString().indexOf("ORA-00001") > 0) {
                                    // 记录已存在的终端序号
                                    exitMac.append(mac.getTermSeq()).append(",");
                                } else {
                                    // 记录添加失败的终端序号
                                    failureMac.append(mac.getTermSeq()).append(",");
                                }
                            }
                        }
                        if (0 == dataCount) {
                            return operateError(fileName+"文件内的数据有误，请核对！", model);
                        }
                        
                        StringBuilder noticeMsg = new StringBuilder();
                        noticeMsg.append("导入总数：" + dataCount)
                                .append("</br>成功数:" + okCount)
                                .append("</br>导入失败终端：").append(failureMac)
                                .append("</br>已存在终端：").append(exitMac);
                        noticeMsg.deleteCharAt(noticeMsg.length()-1);
                        dwz.setStatusCode(DWZ.SUCCESS);
                        dwz.setMessage(noticeMsg.toString());
                        model.addAttribute("dwz", dwz);
                        return "notice/ajaxDone";
                        //return operateError(noticeMsg.toString(), model);
                    } else {
                        return operateError("获取数据失败", model);
                    }
                }
            }
            return operateError("获取数据失败", model);
        } catch (Exception e) {
            log.error("== addSysMacInput exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    /**
     * 读取excel文件
     * 
     * @param file
     * @return
     * @throws IOException
     */
    private List<TermEntity> readExcel(String url) throws IOException {
        List<TermEntity> macInitList = new ArrayList<TermEntity>();
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(url));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        int trLength = sheet.getLastRowNum();
        // 5.得到Excel工作表指定行的单元格
        for (int i = 1; i <= trLength; i++) {
            // 得到Excel工作表的行
            HSSFRow row = sheet.getRow(i);
            HSSFCell cell1 = row.getCell(0);
            cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
            HSSFCell cell2 = row.getCell(1);
            cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
            HSSFCell cell3 = row.getCell(2);
            cell3.setCellType(HSSFCell.CELL_TYPE_STRING);

            String appTermNo = cell2.getStringCellValue();
            if (appTermNo == null || appTermNo.length() != 9) {
                break;
            }

            TermEntity termEntity = new TermEntity();
            termEntity.setSamCardNo(cell1.getStringCellValue());
            termEntity.setAppTermNo(appTermNo.substring(1, 9));
            termEntity.setTermSeq(cell3.getStringCellValue());
            termEntity.setMacStatus("1");
            termEntity.setCreateUser(getSysUser().getLoginName());
            macInitList.add(termEntity);
        }
        return macInitList;
    }

    public List<TermEntity> FindMACselect() {
        return termService.findMacselect();
    }
    
    public static void main(String[] args) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("D:/xls/test.xls"));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            int trLength = sheet.getLastRowNum();
            // 5.得到Excel工作表指定行的单元格
            for (int i = 1; i <  trLength +1; i++) {
                // 得到Excel工作表的行
                HSSFRow row = sheet.getRow(i);
                HSSFCell cell1 = row.getCell(0);
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                
                HSSFCell cell2 = row.getCell(1);
                cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
                
                HSSFCell cell3 = row.getCell(2);
                cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}