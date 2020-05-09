/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingequipment.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 检测设备管理Entity
 * @author zhangxr
 * @version 2019-08-09
 */
@Table(name="biz_testing_equipment", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="equipment_name", attrName="equipmentName", label="设备名称", queryType=QueryType.LIKE),
		@Column(name="equipment_type", attrName="equipmentType", label="设备类型"),
		@Column(name="equipment_purpose", attrName="equipmentPurpose", label="设备用途"),
		@Column(name="equipment_brand", attrName="equipmentBrand", label="设备品牌"),
		@Column(name="equipment_model", attrName="equipmentModel", label="设备型号"),
		@Column(name="equipment_parameter", attrName="equipmentParameter", label="设备参数"),
		@Column(name="contacts_tel", attrName="contactsTel", label="联系人电话"),
		@Column(name="unit_business", attrName="unitBusiness", label="经营情况介绍"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class TestingEquipment extends DataEntity<TestingEquipment> {
	
	private static final long serialVersionUID = 1L;
	private String equipmentName;		// 设备名称
	private String equipmentType;		// 设备类型
	private String equipmentPurpose;		// 设备用途
	private String equipmentBrand;		// 设备品牌
	private String equipmentModel;		// 设备型号
	private String equipmentParameter;		// 设备参数
	private String contactsTel;		// 联系人电话
	private String unitBusiness;		// 经营情况介绍
	
	public TestingEquipment() {
		this(null);
	}

	public TestingEquipment(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="设备名称长度不能超过 255 个字符")
	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	@Length(min=0, max=255, message="设备类型长度不能超过 255 个字符")
	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	
	@Length(min=0, max=255, message="设备用途长度不能超过 255 个字符")
	public String getEquipmentPurpose() {
		return equipmentPurpose;
	}

	public void setEquipmentPurpose(String equipmentPurpose) {
		this.equipmentPurpose = equipmentPurpose;
	}
	
	@Length(min=0, max=255, message="设备品牌长度不能超过 255 个字符")
	public String getEquipmentBrand() {
		return equipmentBrand;
	}

	public void setEquipmentBrand(String equipmentBrand) {
		this.equipmentBrand = equipmentBrand;
	}
	
	@Length(min=0, max=255, message="设备型号长度不能超过 255 个字符")
	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
	
	@Length(min=0, max=255, message="设备参数长度不能超过 255 个字符")
	public String getEquipmentParameter() {
		return equipmentParameter;
	}

	public void setEquipmentParameter(String equipmentParameter) {
		this.equipmentParameter = equipmentParameter;
	}
	
	@Length(min=0, max=255, message="联系人电话长度不能超过 255 个字符")
	public String getContactsTel() {
		return contactsTel;
	}

	public void setContactsTel(String contactsTel) {
		this.contactsTel = contactsTel;
	}
	
	@Length(min=0, max=255, message="经营情况介绍长度不能超过 255 个字符")
	public String getUnitBusiness() {
		return unitBusiness;
	}

	public void setUnitBusiness(String unitBusiness) {
		this.unitBusiness = unitBusiness;
	}
	
}