package com.fenghua.auto.backend.common.utils.graphValidate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 图形验证接口
 * @author chengbin
 *
 */
public class PictureCheckCode{  
      
    public PictureCheckCode() {  
        super();  
    }  
    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void validatePicCheck(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
//        存入会话session  
        HttpSession session = request.getSession(true);  
        session.setAttribute("rand", verifyCode.toLowerCase()); 
        //生成图片  request
        int w = 85, h = 35;  
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
    } 
}  