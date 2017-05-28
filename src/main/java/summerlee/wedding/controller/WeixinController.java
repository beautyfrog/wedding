package summerlee.wedding.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import summerlee.wedding.Tool;

/**
 * WX小程序接入
 * 
 * @file WeixinController
 * @author libin
 * @Create 2017-05-26
 */

@Controller
public class WeixinController {

	@RequestMapping(value="wx")
	public void wxinterface(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod().toLowerCase();
		String result = null;
		switch (method) {
		case "get":
			result = handleValidation(request);
			break;
		case "post":
			result = handleMessage(request);
		}
		try {
			if(StringUtils.isBlank(result)){
				result = "error";
			}
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String handleValidation(HttpServletRequest request) {
		String echostr = request.getParameter("echostr");
		Tool.log("wixin echostr : " + echostr);
		return echostr;
	}
	
	private String handleMessage(HttpServletRequest request) {
		String result = null;
		JSONObject message = null;
		try (InputStream is = request.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			byte[] b = new byte[512];
			int len;
			while((len = is.read(b))!=-1){
				baos.write(b, 0, len);
			}
			String json = new String(baos.toByteArray());
			message = JSON.parseObject(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(message!=null){
			
		}
		return result;
	}
}
