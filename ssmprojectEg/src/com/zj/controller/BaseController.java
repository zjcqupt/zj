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
 *д����ֻ��Ϊ�˷�����÷���
 *ʵ�ֺ�̨ת��json����ʹ�õľ����json-lib�ײͰ�
 *��ǰ����ʾ����Ҫ���ã������������
 */
public class BaseController {
	protected Logger log=LoggerFactory.getLogger(this.getClass());
	protected final static String DATE_FORMATE = "yyyy-MM-dd";
		
	//ֻ�õ���ǰ������������Ϊ�����еı���.....
	public String responseSuccess(Object obj){
		JSONObject jsonObj = null;
		if(obj != null){
		    log.info("��˷��ض���{}", obj);
		    System.out.println("��˷��ض���{}"+ obj);
		    //����date����ת��ͨ��config��JsonDateValueProcessorʵ�֣��ð���û����������
		    JsonConfig jsonConfig = new JsonConfig(); 
		    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		    //ת��Ϊjson����
		    jsonObj = JSONObject.fromObject(obj, jsonConfig);
		    log.info("��˷������ݣ�" + jsonObj);
		    System.out.println("��˷������ݣ�" + jsonObj);
		    jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
		    jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
		}
		log.info("��������{}", jsonObj.toString());
		System.out.println("������"+jsonObj.toString());
		return jsonObj.toString();
	}

	/**
     * ����ʧ��
     * @param errorMsg ������Ϣ
     * @return ���ʧ�ܵ�JSON��ʽ����
     */
    public String responseFail(String errorMsg){
    	JSONObject jsonObj = new JSONObject();
    	jsonObj.put(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, true);
    	jsonObj.put(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errorMsg);
        log.info("��������{}", jsonObj.toString());
        System.out.println("��������{}"+ jsonObj.toString());
        return jsonObj.toString();
    }
	
	
    /**
     * ���ط���˴�����
     * @param obj ������������
     * @return �����������ǰ��JSON��ʽ����
     */
	public String responseResult(Object obj){
		JSONObject jsonobj=null;
		if(obj != null){
			log.info("��˷��ض���{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			 jsonobj = JSONObject.fromObject(obj, jsonConfig);
			 log.info("��˷������ݣ�" + jsonobj);
			 if(HttpConstants.SERVICE_RESPONSE_SUCCESS_CODE.equals(jsonobj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_FLAG))){
			    	jsonobj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
			    	jsonobj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
			    }else{
			    	jsonobj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, true);
			    	String errMsg = jsonobj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_MSG);
			    	jsonobj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errMsg==null?HttpConstants.SERVICE_RESPONSE_NULL:errMsg);
			    }
		}
		 log.info("��������{}", jsonobj.toString());
			return jsonobj.toString();	
	}
	
	public String responseArraySuccess(Object obj){
		JSONArray jsonObj = null;
		if(obj != null){
			log.info("��˷��ض���{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonObj = JSONArray.fromObject(obj, jsonConfig);
			log.info("��˷������ݣ�" + jsonObj);
		}
		log.info("��������{}", jsonObj.toString());
		return jsonObj.toString();
	}

	public String responseSuccess(Object obj, String msg){
		JSONObject jsonObj = null;
		if(obj != null){
		    log.info("��˷��ض���{}", obj);
		    JsonConfig jsonConfig = new JsonConfig(); 
		    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		    jsonObj = JSONObject.fromObject(obj, jsonConfig);
		    log.info("��˷������ݣ�" + jsonObj);
		    jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
		    jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, msg);
		}
		log.info("��������{}", jsonObj.toString());
		return jsonObj.toString();
	}
	
}
