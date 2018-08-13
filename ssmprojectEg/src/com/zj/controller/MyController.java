package com.zj.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zj.Service.AccountService;
import com.zj.Service.UserService;
import com.zj.entities.Account;
import com.zj.entities.User;
import common.PagedResult;

/*
 * ���Դ���index.jsp��
 * Ҳ��������ҳ����
 * ����forward��redirect����
 * forward��ֻ����һ������Servlet����Ϣ��Դ�ɵڶ�����Ϣ��Դ��Ӧ������
 * ���������request�У�����Ķ������ÿ����Ϣ��Դ�ǹ����
 * redirect:ʵ��������HTTP���󣬷�����������Ӧ��һ�������ʱ�����������������һ��URL�������󣬴Ӷ��ﵽת����Ŀ�ġ�
 */

@Controller
@RequestMapping("/MVC")
public class MyController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	@RequestMapping("/GetList")
	public String GetList(Map<String,Object>map){
		map.put("user", userService.selectUserByid(2));
		System.out.println(userService.selectUserByid(2));
		return "forward:../main.jsp";
	}
	
//3��ʵ�ַ�ʽ
	@RequestMapping(value="/Pagelist")
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize ,String userName) {
		try {
			//ֱ����pageinfo����ת��jsonʱ�����⣬��Ϣ̫�࣬���Ի��Ƿ�װ�����
			System.out.println(pageNumber);
			PagedResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);
    	    return responseSuccess(pageResult);
    	} catch (Exception e) {
			return responseFail(e.getMessage());
		}
    }
	
	//ǰ��ͨ��foreachѭ��ʵ�ֵķ�ʽ������ҳ�����
	@RequestMapping(value="/Pagelist2")
	public String list2(Model model,@RequestParam(value="page") Integer pageNumber,Integer pageSize ,@RequestParam(value="name")String userName) throws Exception{
		//���Ĵ�������
		 userName=new String(userName.getBytes("ISO-8859-1"),"UTF-8");  
		PagedResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);
		//����ҳ���ʵ���ഫ��request�򣬲�δ����json������Ϊֱ�����ݳ�����
		model.addAttribute("pagehelper", pageResult);
		model.addAttribute("userlist",pageResult.getDataList());//list<User>
		model.addAttribute("canshu",userName);
		return "page2";
	}
	//ǰ��ʹ��bootstrap tableʵ�֣�����˴��Σ������װ����תjson��ǰ�˳���
	@RequestMapping(value="/Pagelist3")
	@ResponseBody
	public Map<String,Object> list3(HttpServletRequest request, Model model, Integer limit, Integer offset ,String username) throws Exception{
		username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username);
		//��ӣ����������������ҳ�룬�ҵķ�װ����ҳ��
		int hangshu=Integer.parseInt(request.getParameter("offset"));
		offset=hangshu/5+1;
		System.out.println("���ɵ�ǰҳ�룺"+offset);
		System.out.println(request.getParameter("limit"));
		PagedResult<User> pageResult = userService.queryByPage(username, offset,limit);
		Map<String, Object> result=new HashMap<String, Object>();
		//��������ҳ����total��rows ���Զ�תjson
		result.put("total",pageResult.getTotal());
		result.put("rows",pageResult.getDataList());
		return result;
	}
	
	//����û����Ƿ����
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String userName){
		int num=accountService.select(userName);
		boolean flag=false;
		if(num==1){flag=true;}//���û�������ע��}
		//������ת����json,ʹ�����ò����ֶ�תjson
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("flag", flag);		
		return map;
	}
	//ע���ύ
	@RequestMapping(value="/register")
	public String register(Model model,String username,String password){
		Account newac=new Account();
		newac.setUsername(username);
		newac.setPassword(password);
		accountService.insert(newac);
		model.addAttribute("username",username);
		return "success";
	}
	//ֱ�ӵ�¼
	@RequestMapping("/oldcus")
	public String reString(Model model,String username,String password){
		String result="error";
		Account newac=accountService.select2(username);
		if(password.equals(newac.getPassword()))//�ճ�equals...
			{model.addAttribute("username",username);
			result="success";}
		return result;
	}
	
}
