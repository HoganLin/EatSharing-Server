package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

public class FileUpload {
	//文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
    	if (!file.isEmpty()) {  
            
    		String fileName = file.getOriginalFilename();
    		String path=request.getSession().getServletContext().getRealPath("images/");
    		File tempFile;
    		try {  
    			tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
    	        if (!tempFile.getParentFile().exists()) {
    	            tempFile.getParentFile().mkdir();
    	        }
    	        if (!tempFile.exists()) {
    	            tempFile.createNewFile();
    	        }
    	        file.transferTo(tempFile); 
    	        System.out.println("----------------------------------------------------------");
    	        System.out.println(tempFile.getName());
                return "images/" + tempFile.getName();  
               
            } catch (Exception e) {  
                e.printStackTrace();  
                return null;
            }  
        } else {
			return null;
		} 
    }
    
    //多个文件上传
    public static String uploadFiles(MultipartFile[] files, HttpServletRequest request) throws IOException {
    	if (files!=null&&files.length>0) {  
    		List<String> pathsList = new ArrayList<String>();
    		for(int i=0;i<files.length;i++) {
    			pathsList.add(uploadFile(files[i], request));
    		}
            String stepImgs = JSON.toJSONString(pathsList);
            return stepImgs;
    		
    	}else {
			return null;
		}
    }
}
