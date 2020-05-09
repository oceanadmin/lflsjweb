/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sample.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 检测样本信息表Entity
 * @author zhangxr
 * @version 2019-08-22
 */
@Table(name="biz_sample_indicators", alias="a", columns={
		@Column(name="id", attrName="id", label="工作资料ID", isPK=true),
		@Column(name="detection_sample_id", attrName="detectionSampleId.id", label="样本ID"),
		@Column(name="testing_project_id", attrName="testingProjectId", label="项目ID"),
		@Column(name="inspection_unit_id", attrName="inspectionUnitId", label="单位ID"),
		@Column(name="indicators_name", attrName="indicatorsName", label="指标名称", queryType=QueryType.LIKE),
		@Column(name="indicators_no", attrName="indicatorsNo", label="指标值"),
		@Column(name="detection_value", attrName="detectionValue", label="检测值"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.create_date ASC"
)
public class SampleIndicators extends DataEntity<SampleIndicators> {
	
	private static final long serialVersionUID = 1L;
	private DetectionSample detectionSampleId;		// 样本ID 父类
	private String testingProjectId;		// 项目ID
	private String inspectionUnitId;		// 单位ID
	private String indicatorsName;		// 指标名称
	private String indicatorsNo;		// 指标值
	private String detectionValue;		// 检测值
	
	public SampleIndicators() {
		this(null);
	}


	public SampleIndicators(DetectionSample detectionSampleId){
		this.detectionSampleId = detectionSampleId;
	}
	
	@NotBlank(message="样本ID不能为空")
	@Length(min=0, max=100, message="样本ID长度不能超过 100 个字符")
	public DetectionSample getDetectionSampleId() {
		return detectionSampleId;
	}

	public void setDetectionSampleId(DetectionSample detectionSampleId) {
		this.detectionSampleId = detectionSampleId;
	}
	
	@Length(min=0, max=100, message="项目ID长度不能超过 100 个字符")
	public String getTestingProjectId() {
		return testingProjectId;
	}

	public void setTestingProjectId(String testingProjectId) {
		this.testingProjectId = testingProjectId;
	}
	
	@Length(min=0, max=255, message="单位ID长度不能超过 255 个字符")
	public String getInspectionUnitId() {
		return inspectionUnitId;
	}

	public void setInspectionUnitId(String inspectionUnitId) {
		this.inspectionUnitId = inspectionUnitId;
	}
	
	@Length(min=0, max=255, message="指标名称长度不能超过 255 个字符")
	public String getIndicatorsName() {
		return indicatorsName;
	}

	public void setIndicatorsName(String indicatorsName) {
		this.indicatorsName = indicatorsName;
	}
	
	@Length(min=0, max=255, message="指标值长度不能超过 255 个字符")
	public String getIndicatorsNo() {
		return indicatorsNo;
	}

	public void setIndicatorsNo(String indicatorsNo) {
		this.indicatorsNo = indicatorsNo;
	}
	
	@Length(min=0, max=255, message="检测值长度不能超过 255 个字符")
	public String getDetectionValue() {
		return detectionValue;
	}

	public void setDetectionValue(String detectionValue) {
		this.detectionValue = detectionValue;
	}
	
}