package com.onefly.united.notice.service;

import com.onefly.united.common.page.PageData;
import com.onefly.united.common.service.CrudService;
import com.onefly.united.notice.dto.SysNoticeDTO;
import com.onefly.united.notice.entity.SysNoticeEntity;

import java.util.Map;

/**
 * 通知管理
 *
 * @author Mark Rundon
 */
public interface SysNoticeService extends CrudService<SysNoticeEntity, SysNoticeDTO> {

    /**
     * 获取被通知的用户
     */
    PageData<SysNoticeDTO> getNoticeUserPage(Map<String, Object> params);

    /**
     * 获取我的通知列表
     */
    PageData<SysNoticeDTO> getMyNoticePage(Map<String, Object> params);
}