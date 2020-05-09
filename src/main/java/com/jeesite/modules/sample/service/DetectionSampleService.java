/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sample.entity.DetectionSample;
import com.jeesite.modules.sample.dao.DetectionSampleDao;
import com.jeesite.modules.sample.entity.SampleIndicators;
import com.jeesite.modules.sample.dao.SampleIndicatorsDao;

/**
 * 检测样本信息表Service
 * @author zhangxr
 * @version 2019-08-22
 */
@Service
@Transactional(readOnly=true)
public class DetectionSampleService extends CrudService<DetectionSampleDao, DetectionSample> {
	
	@Autowired
	private SampleIndicatorsDao sampleIndicatorsDao;
	
	/**
	 * 获取单条数据
	 * @param detectionSample
	 * @return
	 */
	@Override
	public DetectionSample get(DetectionSample detectionSample) {
		DetectionSample entity = super.get(detectionSample);
		if (entity != null){
			SampleIndicators sampleIndicators = new SampleIndicators(entity);
			sampleIndicators.setStatus(SampleIndicators.STATUS_NORMAL);
			entity.setSampleIndicatorsList(sampleIndicatorsDao.findList(sampleIndicators));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param detectionSample 查询条件
	 * @param detectionSample.page 分页对象
	 * @return
	 */
	@Override
	public Page<DetectionSample> findPage(DetectionSample detectionSample) {
		return super.findPage(detectionSample);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param detectionSample
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DetectionSample detectionSample) {
		super.save(detectionSample);
		// 保存 DetectionSample子表
		for (SampleIndicators sampleIndicators : detectionSample.getSampleIndicatorsList()){
			if (!SampleIndicators.STATUS_DELETE.equals(sampleIndicators.getStatus())){
				sampleIndicators.setDetectionSampleId(detectionSample);
				if (sampleIndicators.getIsNewRecord()){
					sampleIndicators.setInspectionUnitId(detectionSample.getInspectionUnitId());
					sampleIndicators.setTestingProjectId(detectionSample.getTestingProjectId());
					sampleIndicators.preInsert();
					sampleIndicatorsDao.insert(sampleIndicators);
				}else{
					sampleIndicators.preUpdate();
					sampleIndicatorsDao.update(sampleIndicators);
				}
			}else{
				sampleIndicatorsDao.delete(sampleIndicators);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param detectionSample
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DetectionSample detectionSample) {
		super.updateStatus(detectionSample);
	}
	
	/**
	 * 删除数据
	 * @param detectionSample
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DetectionSample detectionSample) {
		super.delete(detectionSample);
		SampleIndicators sampleIndicators = new SampleIndicators();
		sampleIndicators.setDetectionSampleId(detectionSample);
		sampleIndicatorsDao.delete(sampleIndicators);
	}
	
}