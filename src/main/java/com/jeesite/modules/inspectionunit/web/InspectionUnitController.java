/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.inspectionunit.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.inspectionunit.entity.InspectionUnit;
import com.jeesite.modules.inspectionunit.service.InspectionUnitService;

/**
 * 送检单位管理Controller
 * @author zhangxr
 * @version 2019-08-09
 */
@Controller
@RequestMapping(value = "${adminPath}/inspectionunit/inspectionUnit")
public class InspectionUnitController extends BaseController {

	@Autowired
	private InspectionUnitService inspectionUnitService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public InspectionUnit get(String id, boolean isNewRecord) {
		return inspectionUnitService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("inspectionunit:inspectionUnit:view")
	@RequestMapping(value = {"list", ""})
	public String list(InspectionUnit inspectionUnit, Model model) {
		model.addAttribute("inspectionUnit", inspectionUnit);
		return "modules/inspectionunit/inspectionUnitList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("inspectionunit:inspectionUnit:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<InspectionUnit> listData(InspectionUnit inspectionUnit, HttpServletRequest request, HttpServletResponse response) {
		inspectionUnit.setPage(new Page<>(request, response));
		Page<InspectionUnit> page = inspectionUnitService.findPage(inspectionUnit);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("inspectionunit:inspectionUnit:view")
	@RequestMapping(value = "form")
	public String form(InspectionUnit inspectionUnit, Model model) {
		model.addAttribute("inspectionUnit", inspectionUnit);
		return "modules/inspectionunit/inspectionUnitForm";
	}

	/**
	 * 保存送检单位管理
	 */
	@RequiresPermissions("inspectionunit:inspectionUnit:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated InspectionUnit inspectionUnit) {
		inspectionUnitService.save(inspectionUnit);
		return renderResult(Global.TRUE, text("保存送检单位管理成功！"));
	}
	
	/**
	 * 删除送检单位管理
	 */
	@RequiresPermissions("inspectionunit:inspectionUnit:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(InspectionUnit inspectionUnit) {
		inspectionUnitService.delete(inspectionUnit);
		return renderResult(Global.TRUE, text("删除送检单位管理成功！"));
	}
	
}