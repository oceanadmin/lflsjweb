/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sample.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 检测样本信息表Entity
 * @author zhangxr
 * @version 2019-08-22
 */
@Table(name="biz_detection_sample", alias="a", columns={
		@Column(name="id", attrName="id", label="工作资料ID", isPK=true),
		@Column(name="testing_project_id", attrName="testingProjectId", label="检测项目ID"),
		@Column(name="testing_project_name", attrName="testingProjectName", label="检测项目", queryType=QueryType.LIKE),
		@Column(name="inspection_unit_id", attrName="inspectionUnitId", label="送检单位ID"),
		@Column(name="inspection_unit_name", attrName="inspectionUnitName", label="送检单位", queryType=QueryType.LIKE),
		@Column(name="sample_name", attrName="sampleName", label="样本名称", queryType=QueryType.LIKE),
		@Column(name="sample_number", attrName="sampleNumber", label="样本数量"),
		@Column(name="sample_batch", attrName="sampleBatch", label="样本批次"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class DetectionSample extends DataEntity<DetectionSample> {
	
	private static final long serialVersionUID = 1L;
	private String testingProjectId;		// 检测项目ID
	private String testingProjectName;		// 检测项目
	private String inspectionUnitId;		// 送检单位ID
	private String inspectionUnitName;		// 送检单位
	private String sampleName;		// 样本名称
	private String sampleNumber;		// 样本数量
	private String sampleBatch;		// 样本批次
	private List<SampleIndicators> sampleIndicatorsList = ListUtils.newArrayList();		// 子表列表
	
	public DetectionSample() {
		this(null);
	}

	public DetectionSample(String id){
		super(id);
	}
	
	public String getTestingProjectId() {
		return testingProjectId;
	}

	public void setTestingProjectId(String testingProjectId) {
		this.testingProjectId = testingProjectId;
	}
	
	@Length(min=0, max=100, message="检测项目长度不能超过 100 个字符")
	public String getTestingProjectName() {
		return testingProjectName;
	}

	public void setTestingProjectName(String testingProjectName) {
		this.testingProjectName = testingProjectName;
	}
	
	public String getInspectionUnitId() {
		return inspectionUnitId;
	}

	public void setInspectionUnitId(String inspectionUnitId) {
		this.inspectionUnitId = inspectionUnitId;
	}
	
	@Length(min=0, max=255, message="送检单位长度不能超过 255 个字符")
	public String getInspectionUnitName() {
		return inspectionUnitName;
	}

	public void setInspectionUnitName(String inspectionUnitName) {
		this.inspectionUnitName = inspectionUnitName;
	}
	
	@Length(min=0, max=255, message="样本名称长度不能超过 255 个字符")
	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	
	@Length(min=0, max=255, message="样本数量长度不能超过 255 个字符")
	public String getSampleNumber() {
		return sampleNumber;
	}

	public void setSampleNumber(String sampleNumber) {
		this.sampleNumber = sampleNumber;
	}
	
	@Length(min=0, max=255, message="样本批次长度不能超过 255 个字符")
	public String getSampleBatch() {
		return sampleBatch;
	}

	public void setSampleBatch(String sampleBatch) {
		this.sampleBatch = sampleBatch;
	}
	
	public List<SampleIndicators> getSampleIndicatorsList() {
		return sampleIndicatorsList;
	}

	public void setSampleIndicatorsList(List<SampleIndicators> sampleIndicatorsList) {
		this.sampleIndicatorsList = sampleIndicatorsList;
	}
	
}