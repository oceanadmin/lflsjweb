/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.testingproject.entity.TestingProject;
import com.jeesite.modules.testingproject.dao.TestingProjectDao;

/**
 * 检测项目管理信息表Service
 * @author zhangxr
 * @version 2019-08-12
 */
@Service
@Transactional(readOnly=true)
public class TestingProjectService extends CrudService<TestingProjectDao, TestingProject> {
	
	/**
	 * 获取单条数据
	 * @param testingProject
	 * @return
	 */
	@Override
	public TestingProject get(TestingProject testingProject) {
		return super.get(testingProject);
	}
	
	/**
	 * 查询分页数据
	 * @param testingProject 查询条件
	 * @param testingProject.page 分页对象
	 * @return
	 */
	@Override
	public Page<TestingProject> findPage(TestingProject testingProject) {
		return super.findPage(testingProject);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param testingProject
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TestingProject testingProject) {
		super.save(testingProject);
	}
	
	/**
	 * 更新状态
	 * @param testingProject
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TestingProject testingProject) {
		super.updateStatus(testingProject);
	}
	
	/**
	 * 删除数据
	 * @param testingProject
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TestingProject testingProject) {
		super.delete(testingProject);
	}
	
}