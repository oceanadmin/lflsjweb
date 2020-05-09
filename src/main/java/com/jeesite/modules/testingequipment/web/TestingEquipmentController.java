/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingequipment.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.Company;
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
import com.jeesite.modules.testingequipment.entity.TestingEquipment;
import com.jeesite.modules.testingequipment.service.TestingEquipmentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 检测设备管理Controller
 * @author zhangxr
 * @version 2019-08-09
 */
@Controller
@RequestMapping(value = "${adminPath}/testingequipment/testingEquipment")
public class TestingEquipmentController extends BaseController {

	@Autowired
	private TestingEquipmentService testingEquipmentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TestingEquipment get(String id, boolean isNewRecord) {
		return testingEquipmentService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("testingequipment:testingEquipment:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestingEquipment testingEquipment, Model model) {
		model.addAttribute("testingEquipment", testingEquipment);
		return "modules/testingequipment/testingEquipmentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("testingequipment:testingEquipment:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TestingEquipment> listData(TestingEquipment testingEquipment, HttpServletRequest request, HttpServletResponse response) {
		testingEquipment.setPage(new Page<>(request, response));
		Page<TestingEquipment> page = testingEquipmentService.findPage(testingEquipment);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("testingequipment:testingEquipment:view")
	@RequestMapping(value = "form")
	public String form(TestingEquipment testingEquipment, Model model) {
		model.addAttribute("testingEquipment", testingEquipment);
		return "modules/testingequipment/testingEquipmentForm";
	}

	/**
	 * 保存检测设备管理
	 */
	@RequiresPermissions("testingequipment:testingEquipment:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TestingEquipment testingEquipment) {
		testingEquipmentService.save(testingEquipment);
		return renderResult(Global.TRUE, text("保存检测设备管理成功！"));
	}
	
	/**
	 * 删除检测设备管理
	 */
	@RequiresPermissions("testingequipment:testingEquipment:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TestingEquipment testingEquipment) {
		testingEquipmentService.delete(testingEquipment);
		return renderResult(Global.TRUE, text("删除检测设备管理成功！"));
	}

	@RequestMapping({"treeData"})
	@ResponseBody
	public List<Map<String, Object>> treeData(String excludeCode, Boolean isAll, String isShowCode, String isShowFullName, String ctrlPermi) {
		ArrayList mapList = ListUtils.newArrayList();
		TestingEquipment where = new TestingEquipment();
		where.setStatus("0");

		List list = this.testingEquipmentService.findList(where);

		for(int i = 0; i < list.size(); ++i) {
			TestingEquipment e = (TestingEquipment)list.get(i);
			if("0".equals(e.getStatus())) {
				HashMap map = MapUtils.newHashMap();
				map.put("id", e.getId());
				map.put("name",e.getEquipmentName());
				map.put("title", e.getEquipmentName());
				mapList.add(map);
			}
		}

		return mapList;
	}
	
}