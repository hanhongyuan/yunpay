package com.yunpay.controller.common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.yunpay.permission.entity.MerchPrintLabel;

public class PrintMerchLable {
	public static MerchPrintLabel readPrintLabel(String path){
		MerchPrintLabel label = new MerchPrintLabel();
		SAXReader reader = new SAXReader();
		try{
				Document doc = reader.read(path);
				//获取根节点
				Element root = doc.getRootElement();
				label.setTitle(root.element("title").getText());
				label.setContext1(root.element("context1").getText());
				label.setContext2(root.element("context2").getText());
				label.setTelItem(root.element("tel").attributeValue("item"));
				label.setTelValue(root.element("tel").getText());
				label.setFaxItem(root.element("fax").attributeValue("item"));
				label.setFaxValue(root.element("fax").getText());
				label.setLinkManItem(root.element("link_man").attributeValue("item"));
				label.setLinkManValue(root.element("link_man").getText());
				label.setBillNoItem(root.element("bill_no").attributeValue("item"));
				label.setSetTimeItem(root.element("set_time").attributeValue("item"));
				label.setBotAddrItem(root.element("bottom_addr").attributeValue("item"));
				label.setBotAddrValue(root.element("bottom_addr").getText());
				label.setBotTelItem(root.element("bottom_tel").attributeValue("item"));
				label.setBotTelValue(root.element("bottom_tel").getText());
				label.setBotFaxItem(root.element("bottom_fax").attributeValue("item"));
				label.setBotFaxValue(root.element("bottom_fax").getText());
				label.setBotUrlItem(root.element("bottom_url").attributeValue("item"));
				label.setBotUrlValue(root.element("bottom_url").getText());
				label.setSetItem1(root.element("set_item1").getText());
				label.setTotalName(root.element("total_name").getText());
				label.setNoticeTitle(root.element("notice_title").getText());
				label.setNotice1(root.element("notice1").getText());
				label.setNotice2(root.element("notice2").getText());
				label.setCompanySign(root.element("company_sign").getText());
				label.setPersonSign(root.element("person_sign").getText());
				label.setDateSign(root.element("date_sign").getText());
			
		}catch(DocumentException e){
				e.printStackTrace();
				
		}
		return label;
	}
}
