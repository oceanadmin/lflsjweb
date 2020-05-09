/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingproject.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.sys.web.CompanyController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.testingproject.entity.TestingProject;
import com.jeesite.modules.testingproject.service.TestingProjectService;

/**
 * 检测项目管理信息表Controller
 * @author zhangxr
 * @version 2019-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/testingproject/testingProject")
public class TestingProjectController extends BaseController {

	@Autowired
	private TestingProjectService testingProjectService;
	//private CompanyController
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TestingProject get(String id, boolean isNewRecord) {
		return testingProjectService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("testingproject:testingProject:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestingProject testingProject, Model model) {
		model.addAttribute("testingProject", testingProject);
		return "modules/testingproject/testingProjectList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("testingproject:testingProject:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TestingProject> listData(TestingProject testingProject, HttpServletRequest request, HttpServletResponse response) {
		testingProject.setPage(new Page<>(request, response));
		Page<TestingProject> page = testingProjectService.findPage(testingProject);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("testingproject:testingProject:view")
	@RequestMapping(value = "form")
	public String form(TestingProject testingProject, Model model) {
		model.addAttribute("testingProject", testingProject);
		return "modules/testingproject/testingProjectForm";
	}

	/**
	 * 保存检测项目管理信息表
	 */
	@RequiresPermissions("testingproject:testingProject:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TestingProject testingProject) {
		testingProjectService.save(testingProject);
		return renderResult(Global.TRUE, text("保存检测项目管理信息表成功！"));
	}
	
	/**
	 * 删除检测项目管理信息表
	 */
	@RequiresPermissions("testingproject:testingProject:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TestingProject testingProject) {
		testingProjectService.delete(testingProject);
		return renderResult(Global.TRUE, text("删除检测项目管理信息表成功！"));
	}
	
}