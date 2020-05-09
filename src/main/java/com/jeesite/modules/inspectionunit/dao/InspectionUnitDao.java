/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.inspectionunit.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.inspectionunit.entity.InspectionUnit;

/**
 * 送检单位管理DAO接口
 * @author zhangxr
 * @version 2019-08-09
 */
@MyBatisDao
public interface InspectionUnitDao extends CrudDao<InspectionUnit> {
	
}