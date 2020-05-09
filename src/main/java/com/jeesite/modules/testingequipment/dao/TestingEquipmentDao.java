/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.testingequipment.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.testingequipment.entity.TestingEquipment;

/**
 * 检测设备管理DAO接口
 * @author zhangxr
 * @version 2019-08-09
 */
@MyBatisDao
public interface TestingEquipmentDao extends CrudDao<TestingEquipment> {
	
}