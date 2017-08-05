package com.yunpay.controller.exception;
import java.io.Writer;

import org.apache.log4j.Logger;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
/**
 * 文件名称:    FreemarkerExceptionHandler.java
 * 内容摘要: 
 * @author:   苏东辉
 * @version:  1.0  
 * @Date:     2016年9月8日 下午4:22:08  
 * 
 * 修改历史:  
 * 修改日期       修改人员   版本	   修改内容  
 * ----------------------------------------------  
 * 2016年9月8日    苏东辉     1.0    1.0 XXXX
 *
 * 版权:   版权所有(C)2016
 * 公司:   深圳市前海汇商惠电子商务有限公司
 */
public class FreemarkerExceptionHandler implements TemplateExceptionHandler {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public void handleTemplateException(TemplateException arg0,
			Environment arg1, Writer arg2) throws TemplateException {

	}

}
