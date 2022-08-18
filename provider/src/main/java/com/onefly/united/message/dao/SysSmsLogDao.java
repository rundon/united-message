package com.onefly.united.message.dao;

import com.onefly.united.common.dao.BaseDao;
import com.onefly.united.message.entity.SysSmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信日志
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysSmsLogDao extends BaseDao<SysSmsLogEntity> {
	
}