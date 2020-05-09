/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.inspectionunit.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 送检单位管理Entity
 * @author zhangxr
 * @version 2019-08-09
 */
@Table(name="biz_inspection_unit", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="unit_name", attrName="unitName", label="送检单位名称", queryType=QueryType.LIKE),
		@Column(name="unit_address", attrName="unitAddress", label="送检单位地址"),
		@Column(name="unit_contacts", attrName="unitContacts", label="单位联系人"),
		@Column(name="contacts_tel", attrName="contactsTel", label="联系人电话"),
		@Column(name="unit_business", attrName="unitBusiness", label="经营情况介绍", isQuery=false),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class InspectionUnit extends DataEntity<InspectionUnit> {
	
	private static final long serialVersionUID = 1L;
	private String unitName;		// 送检单位名称
	private String unitAddress;		// 送检单位地址
	private String unitContacts;		// 单位联系人
	private String contactsTel;		// 联系人电话
	private String unitBusiness;		// 经营情况介绍
	
	public InspectionUnit() {
		this(null);
	}

	public InspectionUnit(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="送检单位名称长度不能超过 255 个字符")
	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	@Length(min=0, max=255, message="送检单位地址长度不能超过 255 个字符")
	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	
	@Length(min=0, max=255, message="单位联系人长度不能超过 255 个字符")
	public String getUnitContacts() {
		return unitContacts;
	}

	public void setUnitContacts(String unitContacts) {
		this.unitContacts = unitContacts;
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