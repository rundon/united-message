/**
 * Copyright (c) 2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */
package com.onefly.united.notice.dao;

import com.onefly.united.common.dao.BaseDao;
import com.onefly.united.notice.entity.SysNoticeUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 我的通知
*
* @author Mark sunlightcs@gmail.com
*/
@Mapper
public interface SysNoticeUserDao extends BaseDao<SysNoticeUserEntity> {
    /**
     * 通知全部用户
     */
	void insertAllUser(SysNoticeUserEntity entity);

    /**
     * 未读的通知数
     * @param receiverId  接收者ID
     */
    int getUnReadNoticeCount(Long receiverId);
}