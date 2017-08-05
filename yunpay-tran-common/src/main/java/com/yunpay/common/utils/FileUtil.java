package com.yunpay.common.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUtil {
	
	/**
	 * @Description:  文件上传
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月3日下午2:34:34 
	 * @param path  保存目录
	 * @param file  文件流
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static Map<String,String> fileUpload(String path,CommonsMultipartFile file) throws IllegalStateException, IOException{
		long  startTime=System.currentTimeMillis();
        Log.info("filename="+file.getOriginalFilename());
        //自动创建目录
        File pathFolder = new File(path);
		if(!pathFolder.exists()){
			pathFolder.mkdirs();
		}
        //获取文件的后缀
        String extend = file.getOriginalFilename()
				.substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        String saveFileName = DateUtil.getNow("yyyyMMddHHmmss")+extend;
        String filePath = path+saveFileName;
        File newFile=new File(filePath);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("upload timecost:"+String.valueOf(endTime-startTime)+"ms");
        Map<String,String> fileInfo = new HashMap<String,String>();
        fileInfo.put("fileName", file.getOriginalFilename());
        fileInfo.put("extend", extend);
        fileInfo.put("fileSize", file.getSize()+"");
        fileInfo.put("savePath", filePath);
        fileInfo.put("saveName", saveFileName);
		return fileInfo;
	}
	
	/**
	 * 
	 * @Description: 将本地文件传至目标网址
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月3日下午1:58:24 
	 * @param sourceUrl
	 * @param destUrl
	 * @return
	 */
	public static String saveToFile(String sourceUrl,String destUrl) {
		//String saveFilePathName = Upload.generatorImagesFolderServerPath();
    	String saveFilePathName = sourceUrl;
		String saveFileName = "";
		String extend = destUrl.substring(destUrl.lastIndexOf(".") + 1).toLowerCase();
		if (saveFileName == null || saveFileName.trim().equals("")) {
			saveFileName = UUID.randomUUID().toString() + "." + extend;
		}
		if (saveFileName.lastIndexOf(".") < 0) {
			saveFileName = saveFileName + "." + extend;
		}
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		try {
			url = new URL(destUrl);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			fos = new FileOutputStream(saveFilePathName + File.separator + saveFileName);
			while ((size = bis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.flush();
		} catch (IOException e) {
		} catch (ClassCastException e) {
		} finally {
			try {
				fos.close();
				bis.close();
				httpUrl.disconnect();
			} catch (IOException e) {
			} catch (NullPointerException e) {
			}
		}
		return saveFilePathName + File.separator + saveFileName;
	}
}
