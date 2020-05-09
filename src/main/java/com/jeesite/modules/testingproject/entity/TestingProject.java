/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingproject.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 检测项目管理信息表Entity
 * @author zhangxr
 * @version 2019-08-12
 */
@Table(name="biz_testing_project", alias="a", columns={
		@Column(name="id", attrName="id", label="project ID", isPK=true),
		@Column(name="project_name", attrName="projectName", label="检测项目名称", queryType=QueryType.LIKE),
		@Column(name="project_type", attrName="projectType", label="检测项目类型"),
		@Column(name="project_equipment_id", attrName="projectEquipmentId", label="检测设备ID"),
		@Column(name="project_equipment_name", attrName="projectEquipmentName", label="检测设备NAME", queryType=QueryType.LIKE),
		@Column(name="project_standard", attrName="projectStandard", label="项目标准"),
		@Column(name="project_norm_1", attrName="projectNorm1", label="项目指标1"),
		@Column(name="project_norm_2", attrName="projectNorm2", label="项目指标2"),
		@Column(name="project_norm_3", attrName="projectNorm3", label="项目指标3"),
		@Column(name="project_norm_4", attrName="projectNorm4", label="项目指标4"),
		@Column(name="project_norm_5", attrName="projectNorm5", label="项目指标5"),
		@Column(name="project_description", attrName="projectDescription", label="项目说明"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class TestingProject extends DataEntity<TestingProject> {
	
	private static final long serialVersionUID = 1L;
	private String projectName;		// 检测项目名称
	private String projectType;		// 检测项目类型
	private String projectEquipmentId;		// 检测设备ID
	private String projectEquipmentName;		// 检测设备NAME
	private String projectStandard;		// 项目标准
	private String projectNorm1;		// 项目指标1
	private String projectNorm2;		// 项目指标2
	private String projectNorm3;		// 项目指标3
	private String projectNorm4;		// 项目指标4
	private String projectNorm5;		// 项目指标5
	private String projectDescription;		// 项目说明
	
	public TestingProject() {
		this(null);
	}

	public TestingProject(String id){
		super(id);
	}
	
	@NotBlank(message="检测项目名称不能为空")
	@Length(min=0, max=100, message="检测项目名称长度不能超过 100 个字符")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Length(min=0, max=100, message="检测项目类型长度不能超过 100 个字符")
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	public String getProjectEquipmentId() {
		return projectEquipmentId;
	}

	public void setProjectEquipmentId(String projectEquipmentId) {
		this.projectEquipmentId = projectEquipmentId;
	}
	
	@Length(min=0, max=255, message="检测设备NAME长度不能超过 255 个字符")
	public String getProjectEquipmentName() {
		return projectEquipmentName;
	}

	public void setProjectEquipmentName(String projectEquipmentName) {
		this.projectEquipmentName = projectEquipmentName;
	}
	
	@Length(min=0, max=255, message="项目标准长度不能超过 255 个字符")
	public String getProjectStandard() {
		return projectStandard;
	}

	public void setProjectStandard(String projectStandard) {
		this.projectStandard = projectStandard;
	}
	
	@Length(min=0, max=255, message="项目指标1长度不能超过 255 个字符")
	public String getProjectNorm1() {
		return projectNorm1;
	}

	public void setProjectNorm1(String projectNorm1) {
		this.projectNorm1 = projectNorm1;
	}
	
	@Length(min=0, max=255, message="项目指标2长度不能超过 255 个字符")
	public String getProjectNorm2() {
		return projectNorm2;
	}

	public void setProjectNorm2(String projectNorm2) {
		this.projectNorm2 = projectNorm2;
	}
	
	@Length(min=0, max=255, message="项目指标3长度不能超过 255 个字符")
	public String getProjectNorm3() {
		return projectNorm3;
	}

	public void setProjectNorm3(String projectNorm3) {
		this.projectNorm3 = projectNorm3;
	}
	
	@Length(min=0, max=255, message="项目指标4长度不能超过 255 个字符")
	public String getProjectNorm4() {
		return projectNorm4;
	}

	public void setProjectNorm4(String projectNorm4) {
		this.projectNorm4 = projectNorm4;
	}
	
	@Length(min=0, max=255, message="项目指标5长度不能超过 255 个字符")
	public String getProjectNorm5() {
		return projectNorm5;
	}

	public void setProjectNorm5(String projectNorm5) {
		this.projectNorm5 = projectNorm5;
	}
	
	@Length(min=0, max=255, message="项目说明长度不能超过 255 个字符")
	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
}