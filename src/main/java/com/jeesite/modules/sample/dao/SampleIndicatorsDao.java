/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sample.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sample.entity.SampleIndicators;

/**
 * 检测样本信息表DAO接口
 * @author zhangxr
 * @version 2019-08-22
 */
@MyBatisDao
public interface SampleIndicatorsDao extends CrudDao<SampleIndicators> {
	
}