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
 * 可以传到index.jsp中
 * 也可以在首页回显
 * 区分forward和redirect区别
 * forward：只发出一次请求，Servlet等信息资源由第二个信息资源响应该请求，
 * 在请求对象request中，保存的对象对于每个信息资源是共享的
 * redirect:实际是两次HTTP请求，服务器端在响应第一次请求的时候，让浏览器再向另外一个URL发出请求，从而达到转发的目的。
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
	
//3种实现方式
	@RequestMapping(value="/Pagelist")
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize ,String userName) {
		try {
			//直接用pageinfo可能转化json时有问题，信息太多，所以还是封装类好用
			System.out.println(pageNumber);
			PagedResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);
    	    return responseSuccess(pageResult);
    	} catch (Exception e) {
			return responseFail(e.getMessage());
		}
    }
	
	//前端通过foreach循环实现的方式，返回页面呈现
	@RequestMapping(value="/Pagelist2")
	public String list2(Model model,@RequestParam(value="page") Integer pageNumber,Integer pageSize ,@RequestParam(value="name")String userName) throws Exception{
		//中文传参问题
		 userName=new String(userName.getBytes("ISO-8859-1"),"UTF-8");  
		PagedResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);
		//将分页类和实体类传到request域，并未进行json处理，因为直接数据呈现了
		model.addAttribute("pagehelper", pageResult);
		model.addAttribute("userlist",pageResult.getDataList());//list<User>
		model.addAttribute("canshu",userName);
		return "page2";
	}
	//前端使用bootstrap table实现，往后端传参，处理封装集后转json，前端呈现
	@RequestMapping(value="/Pagelist3")
	@ResponseBody
	public Map<String,Object> list3(HttpServletRequest request, Model model, Integer limit, Integer offset ,String username) throws Exception{
		username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username);
		//深坑，这个是行数，不是页码，我的封装类是页码
		int hangshu=Integer.parseInt(request.getParameter("offset"));
		offset=hangshu/5+1;
		System.out.println("换成当前页码："+offset);
		System.out.println(request.getParameter("limit"));
		PagedResult<User> pageResult = userService.queryByPage(username, offset,limit);
		Map<String, Object> result=new HashMap<String, Object>();
		//服务器分页返回total、rows ，自动转json
		result.put("total",pageResult.getTotal());
		result.put("rows",pageResult.getDataList());
		return result;
	}
	
	//检查用户名是否存在
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String userName){
		int num=accountService.select(userName);
		boolean flag=false;
		if(num==1){flag=true;}//该用户名可以注册}
		//将数据转换成json,使用内置不用手动转json
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("flag", flag);		
		return map;
	}
	//注册提交
	@RequestMapping(value="/register")
	public String register(Model model,String username,String password){
		Account newac=new Account();
		newac.setUsername(username);
		newac.setPassword(password);
		accountService.insert(newac);
		model.addAttribute("username",username);
		return "success";
	}
	//直接登录
	@RequestMapping("/oldcus")
	public String reString(Model model,String username,String password){
		String result="error";
		Account newac=accountService.select2(username);
		if(password.equals(newac.getPassword()))//日常equals...
			{model.addAttribute("username",username);
			result="success";}
		return result;
	}
	
}
