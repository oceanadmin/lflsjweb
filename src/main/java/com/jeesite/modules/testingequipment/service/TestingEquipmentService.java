/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingequipment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.testingequipment.entity.TestingEquipment;
import com.jeesite.modules.testingequipment.dao.TestingEquipmentDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 检测设备管理Service
 * @author zhangxr
 * @version 2019-08-09
 */
@Service
@Transactional(readOnly=true)
public class TestingEquipmentService extends CrudService<TestingEquipmentDao, TestingEquipment> {
	
	/**
	 * 获取单条数据
	 * @param testingEquipment
	 * @return
	 */
	@Override
	public TestingEquipment get(TestingEquipment testingEquipment) {
		return super.get(testingEquipment);
	}
	
	/**
	 * 查询分页数据
	 * @param testingEquipment 查询条件
	 * @param testingEquipment.page 分页对象
	 * @return
	 */
	@Override
	public Page<TestingEquipment> findPage(TestingEquipment testingEquipment) {
		return super.findPage(testingEquipment);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param testingEquipment
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TestingEquipment testingEquipment) {
		super.save(testingEquipment);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(testingEquipment.getId(), "testingEquipment_file");
	}
	
	/**
	 * 更新状态
	 * @param testingEquipment
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TestingEquipment testingEquipment) {
		super.updateStatus(testingEquipment);
	}
	
	/**
	 * 删除数据
	 * @param testingEquipment
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TestingEquipment testingEquipment) {
		super.delete(testingEquipment);
	}
	
}