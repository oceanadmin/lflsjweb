/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.inspectionunit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.inspectionunit.entity.InspectionUnit;
import com.jeesite.modules.inspectionunit.dao.InspectionUnitDao;

/**
 * 送检单位管理Service
 * @author zhangxr
 * @version 2019-08-09
 */
@Service
@Transactional(readOnly=true)
public class InspectionUnitService extends CrudService<InspectionUnitDao, InspectionUnit> {
	
	/**
	 * 获取单条数据
	 * @param inspectionUnit
	 * @return
	 */
	@Override
	public InspectionUnit get(InspectionUnit inspectionUnit) {
		return super.get(inspectionUnit);
	}
	
	/**
	 * 查询分页数据
	 * @param inspectionUnit 查询条件
	 * @param inspectionUnit.page 分页对象
	 * @return
	 */
	@Override
	public Page<InspectionUnit> findPage(InspectionUnit inspectionUnit) {
		return super.findPage(inspectionUnit);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param inspectionUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(InspectionUnit inspectionUnit) {
		super.save(inspectionUnit);
	}
	
	/**
	 * 更新状态
	 * @param inspectionUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(InspectionUnit inspectionUnit) {
		super.updateStatus(inspectionUnit);
	}
	
	/**
	 * 删除数据
	 * @param inspectionUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(InspectionUnit inspectionUnit) {
		super.delete(inspectionUnit);
	}
	
}