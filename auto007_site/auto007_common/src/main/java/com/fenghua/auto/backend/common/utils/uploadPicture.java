package com.fenghua.auto.backend.common.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class uploadPicture {
	public static String upload(MultipartFile picture,HttpServletResponse response,HttpServletRequest request, String sessionName){
		if(!picture.isEmpty()) {
			
			String pictureName = picture.getOriginalFilename();
			//验证上传文件是否为图片
			String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
	        Pattern pattern = Pattern.compile(reg);
	        Matcher matcher = pattern.matcher(pictureName);
	        //验证通过
	        if(matcher.find()){
				String logoRealPathDir = request.getSession().getServletContext()
						.getRealPath("/");
				logoRealPathDir = logoRealPathDir + "common/images/bgpicture";
				// 验证文件夹是否存在
				File logoSaveFile = new File(logoRealPathDir);
				if (!logoSaveFile.exists())
					logoSaveFile.mkdirs(); // 不存在，新建文件夹
	
				UUID uuid = UUID.randomUUID();
				//图片重命名
				String fileName = logoRealPathDir + File.separator + uuid + pictureName.substring(pictureName.lastIndexOf("."),pictureName.length());
				String name = request.getContextPath()
						+ "/common/images/bgpicture/" + uuid + pictureName.substring(pictureName.lastIndexOf("."),pictureName.length());
				// 保存上传图片路径
				@SuppressWarnings("unused")
				File file = new File(fileName);
				//缩放图片
				BufferedImage srcBufferImage = null;
				try {
					srcBufferImage = ImageIO.read(picture.getInputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}  
		        BufferedImage scaledImage;  
		        ScaleImg scaleImage = ScaleImg.getInstance();  
		        int yw = srcBufferImage.getWidth();  
		        int yh = srcBufferImage.getHeight();  
		        int w = 100, h = 100;  
		        // 如果上传图片 宽高 比 压缩的要小 则不压缩  
		        if (w > yw && h > yh)  
		        {  
		            FileOutputStream fos = null;
					try {
						fos = new FileOutputStream(fileName);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}  
		  
					ByteArrayInputStream fis = null;
					try {
						//fis = (FileInputStream) picture.getInputStream().getClass();
						fis =  (ByteArrayInputStream) picture.getInputStream();
					} catch (IOException e) {
						e.printStackTrace();
					}  
		            byte[] buffer = new byte[1024];  
		            int len = 0;  
		            try {
						while ((len = fis.read(buffer)) > 0)  
						{  
						    try {
								fos.write(buffer, 0, len);
							} catch (IOException e) {
								e.printStackTrace();
							}  
						}
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
		           
		        }  
		        else  
		        {  
		            scaledImage = scaleImage.imageZoomOut(srcBufferImage, w, h);  
		            FileOutputStream out = null;
					try {
						out = new FileOutputStream(fileName);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}  
		            try {
						ImageIO.write(scaledImage, "jpeg", out);
					} catch (IOException e) {
						e.printStackTrace();
					}  
		            finally{
		            	try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
		            }
		        }
		        HttpSession session = request.getSession(true);  
		        session.setAttribute(sessionName, name);
		        return name;
			}
	        //验证失败
	        else{
	        	return "";
			}
		}
		else{
			return "";
		}
	}
}
