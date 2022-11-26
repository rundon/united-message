package com.onefly.united.message.dao;

import com.onefly.united.common.dao.BaseDao;
import com.onefly.united.message.entity.SysMailLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件发送记录
 * 
 * @author Mark Rundon
 */
@Mapper
public interface SysMailLogDao extends BaseDao<SysMailLogEntity> {
	
}
