package com.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sample.common.JsonResult;
import com.sample.domain.User;
import com.sample.servise.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService entityService;

	// 列出所有的用户
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String list(@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {
		Map<String, String> pram = new HashMap<String, String>();
		pram.put("startDate", startDate);
		pram.put("endDate", endDate);
		List<User> users = entityService.listUser(pram);
		return JSON.toJSONString(users);
	}

	// 添加用户
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public ModelAndView createUser() {
		System.out.println("create 进来");
		ModelAndView view = new ModelAndView("user/create");
		return view;
	}

	// 添加用户
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String addUser(String name, Integer sex) {
		entityService.addUser(name, sex);
		JsonResult jsonResult = JsonResult.getInstance(0, "添加成功");
		return jsonResult.toString();
	}

	// 获取某个用户的信息
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public ModelAndView editUser(@PathVariable("userId") Integer userId) {
		User user = entityService.findUserById(userId);
		ModelAndView view = new ModelAndView("user/edit");
		view.addObject("user", user);
		return view;
	}

	// 修改某个用户的信息
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String updateUser(@PathVariable("userId") String userId, String name, Integer sex) {
		System.out.println(userId + "  " + name + " " + sex);
		JsonResult jsonResult = JsonResult.getInstance(0, "修改成功");
		return jsonResult.toString();
	}

	// 删除某个某个用户
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") String userId) {
		System.out.println(userId);
		JsonResult jsonResult = JsonResult.getInstance(0, "删除用户");
		return jsonResult.toString();
	}

}
