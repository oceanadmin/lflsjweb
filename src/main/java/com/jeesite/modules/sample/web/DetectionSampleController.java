/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sample.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.inspectionunit.entity.InspectionUnit;
import com.jeesite.modules.inspectionunit.service.InspectionUnitService;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.testingproject.entity.TestingProject;
import com.jeesite.modules.testingproject.service.TestingProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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
import com.jeesite.modules.sample.entity.DetectionSample;
import com.jeesite.modules.sample.service.DetectionSampleService;

/**
 * 检测样本信息表Controller
 * @author zhangxr
 * @version 2019-08-22
 */
@Controller
@RequestMapping(value = "${adminPath}/sample/detectionSample")
public class DetectionSampleController extends BaseController {

	@Autowired
	private DetectionSampleService detectionSampleService;

	@Autowired
	private TestingProjectService testingProjectService;

	@Autowired
	private InspectionUnitService inspectionUnitService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DetectionSample get(String id, boolean isNewRecord) {
		return detectionSampleService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sample:detectionSample:view")
	@RequestMapping(value = {"list", ""})
	public String list(DetectionSample detectionSample, Model model) {
		model.addAttribute("detectionSample", detectionSample);
		model.addAttribute("projectList", testingProjectService.findList(new TestingProject()));
		model.addAttribute("unitList", inspectionUnitService.findList(new InspectionUnit()));
		return "modules/sample/detectionSampleList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sample:detectionSample:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DetectionSample> listData(DetectionSample detectionSample, HttpServletRequest request, HttpServletResponse response) {
		detectionSample.setPage(new Page<>(request, response));
		if(detectionSample != null) {
			if (!detectionSample.getInspectionUnitId().equals("")) {
				System.out.println("...........................unit.id:" + detectionSample.getInspectionUnitId());
				if (detectionSample.getInspectionUnitId().indexOf(',') != -1) {
					System.out.println("................单位ID存在逗号:" + detectionSample.getInspectionUnitId());
				} else {
					System.out.println("................单位ID不存在逗号:" + detectionSample.getInspectionUnitId());
				}
			}
		}
		Page<DetectionSample> page = detectionSampleService.findPage(detectionSample);
		return page;
	}

	/**
	 * 查询列表----检测结果
	 */
	@RequiresPermissions("sample:detectionSample:view")
	@RequestMapping(value = {"resultsList", ""})
	public String resultsList(DetectionSample detectionSample, Model model) {
		model.addAttribute("detectionSample", detectionSample);
		model.addAttribute("projectList", testingProjectService.findList(new TestingProject()));
		model.addAttribute("unitList", inspectionUnitService.findList(new InspectionUnit()));
		return "modules/sample/sampleResultsList";
	}

	/**
	 * 查询列表数据----检测结果
	 */
	@RequiresPermissions("sample:detectionSample:view")
	@RequestMapping(value = "resultsListData")
	@ResponseBody
	public Page<DetectionSample> resultsListData(DetectionSample detectionSample, HttpServletRequest request, HttpServletResponse response) {
		detectionSample.setPage(new Page<>(request, response));
		if(detectionSample != null) {
			if (!detectionSample.getInspectionUnitId().equals("")) {
				System.out.println("...........................unit.id:" + detectionSample.getInspectionUnitId());
				if (detectionSample.getInspectionUnitId().indexOf(',') != -1) {
					System.out.println("................单位ID存在逗号:" + detectionSample.getInspectionUnitId());
				} else {
					System.out.println("................单位ID不存在逗号:" + detectionSample.getInspectionUnitId());
				}
			}
		}
		Page<DetectionSample> page = detectionSampleService.findPage(detectionSample);
		return page;
	}

	/**
	 * 查看编辑表单----检测结果
	 */
	@RequiresPermissions("sample:detectionSample:view")
	@RequestMapping(value = "resultsform")
	public String resultsform(DetectionSample detectionSample, Model model) {


		model.addAttribute("projectList", testingProjectService.findList(new TestingProject()));
		model.addAttribute("unitList", inspectionUnitService.findList(new InspectionUnit()));

		model.addAttribute("detectionSample", detectionSample);
		return "modules/sample/sampleResultsForm";
	}

	/**
	 * 查看编辑表单----检测结果
	 */
	@RequiresPermissions("sample:detectionSample:view")
	@RequestMapping(value = "reportform")
	public String reportform(DetectionSample detectionSample, Model model) {

		model.addAttribute("projectList", testingProjectService.findList(new TestingProject()));
		model.addAttribute("unitList", inspectionUnitService.findList(new InspectionUnit()));

		model.addAttribute("detectionSample", detectionSample);
		return "modules/sample/reportForm";
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sample:detectionSample:view")
	@RequestMapping(value = "form")
	public String form(DetectionSample detectionSample, Model model) {


		model.addAttribute("projectList", testingProjectService.findList(new TestingProject()));
		model.addAttribute("unitList", inspectionUnitService.findList(new InspectionUnit()));


		model.addAttribute("detectionSample", detectionSample);
		return "modules/sample/detectionSampleForm";
	}

	/**
	 * 保存检测样本信息表
	 */
	@RequiresPermissions("sample:detectionSample:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DetectionSample detectionSample) {
		if(detectionSample != null){
			if(!detectionSample.getInspectionUnitId().equals("")){
				System.out.println("...........................unit.id:"+detectionSample.getInspectionUnitId());
				InspectionUnit tu = new InspectionUnit();
				if(detectionSample.getInspectionUnitId().indexOf(',') != -1){
					System.out.println("................单位ID存在逗号:"+detectionSample.getInspectionUnitId());
					tu.setId(detectionSample.getInspectionUnitId().replace(",","").trim());
				}else{
					System.out.println("................单位ID不存在逗号:"+detectionSample.getInspectionUnitId());
					tu.setId(detectionSample.getInspectionUnitId());
				}


				InspectionUnit unit = inspectionUnitService.get(tu);
				if(unit !=null){
					System.out.println("..................unit.name:"+unit.getUnitName());
					detectionSample.setInspectionUnitName(unit.getUnitName());
				}
			}
			if(!detectionSample.getTestingProjectId().equals("")){
				System.out.println("...........................project.id:"+detectionSample.getTestingProjectId());
				TestingProject tp = new TestingProject();
				tp.setId(detectionSample.getTestingProjectId());
				TestingProject project = testingProjectService.get(tp);
				if(project != null){
					System.out.println("...........................project.name:"+project.getProjectName());
					detectionSample.setTestingProjectName(project.getProjectName());
				}
			}
		}
		detectionSampleService.save(detectionSample);
		return renderResult(Global.TRUE, text("保存检测样本信息表成功！"));
	}
	
	/**
	 * 删除检测样本信息表
	 */
	@RequiresPermissions("sample:detectionSample:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DetectionSample detectionSample) {
		detectionSampleService.delete(detectionSample);
		return renderResult(Global.TRUE, text("删除检测样本信息表成功！"));
	}
	
}