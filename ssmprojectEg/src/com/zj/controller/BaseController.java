package com.zj.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import common.HttpConstants;
import common.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/*
 *写基类只是为了方便调用方法
 *实现后台转化json对象，使用的经典的json-lib套餐包
 *但前端显示还是要配置，避免乱码出现
 */
public class BaseController {
	protected Logger log=LoggerFactory.getLogger(this.getClass());
	protected final static String DATE_FORMATE = "yyyy-MM-dd";
		
	//只用到了前两个，后面作为基类中的备用.....
	public String responseSuccess(Object obj){
		JSONObject jsonObj = null;
		if(obj != null){
		    log.info("后端返回对象：{}", obj);
		    System.out.println("后端返回对象：{}"+ obj);
		    //对于date类型转化通过config及JsonDateValueProcessor实现，该案例没有明显体现
		    JsonConfig jsonConfig = new JsonConfig(); 
		    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		    //转化为json对象：
		    jsonObj = JSONObject.fromObject(obj, jsonConfig);
		    log.info("后端返回数据：" + jsonObj);
		    System.out.println("后端返回数据：" + jsonObj);
		    jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
		    jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
		}
		log.info("输出结果：{}", jsonObj.toString());
		System.out.println("输出结果"+jsonObj.toString());
		return jsonObj.toString();
	}

	/**
     * 返回失败
     * @param errorMsg 错误信息
     * @return 输出失败的JSON格式数据
     */
    public String responseFail(String errorMsg){
    	JSONObject jsonObj = new JSONObject();
    	jsonObj.put(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, true);
    	jsonObj.put(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errorMsg);
        log.info("输出结果：{}", jsonObj.toString());
        System.out.println("输出结果：{}"+ jsonObj.toString());
        return jsonObj.toString();
    }
	
	
    /**
     * 返回服务端处理结果
     * @param obj 服务端输出对象
     * @return 输出处理结果给前端JSON格式数据
     */
	public String responseResult(Object obj){
		JSONObject jsonobj=null;
		if(obj != null){
			log.info("后端返回对象：{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			 jsonobj = JSONObject.fromObject(obj, jsonConfig);
			 log.info("后端返回数据：" + jsonobj);
			 if(HttpConstants.SERVICE_RESPONSE_SUCCESS_CODE.equals(jsonobj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_FLAG))){
			    	jsonobj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
			    	jsonobj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
			    }else{
			    	jsonobj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, true);
			    	String errMsg = jsonobj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_MSG);
			    	jsonobj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errMsg==null?HttpConstants.SERVICE_RESPONSE_NULL:errMsg);
			    }
		}
		 log.info("输出结果：{}", jsonobj.toString());
			return jsonobj.toString();	
	}
	
	public String responseArraySuccess(Object obj){
		JSONArray jsonObj = null;
		if(obj != null){
			log.info("后端返回对象：{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonObj = JSONArray.fromObject(obj, jsonConfig);
			log.info("后端返回数据：" + jsonObj);
		}
		log.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	public String responseSuccess(Object obj, String msg){
		JSONObject jsonObj = null;
		if(obj != null){
		    log.info("后端返回对象：{}", obj);
		    JsonConfig jsonConfig = new JsonConfig(); 
		    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		    jsonObj = JSONObject.fromObject(obj, jsonConfig);
		    log.info("后端返回数据：" + jsonObj);
		    jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
		    jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, msg);
		}
		log.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}
	
}
