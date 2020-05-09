/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingproject.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.testingproject.entity.TestingProject;

/**
 * 检测项目管理信息表DAO接口
 * @author zhangxr
 * @version 2019-08-12
 */
@MyBatisDao
public interface TestingProjectDao extends CrudDao<TestingProject> {
	
}