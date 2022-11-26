package com.onefly.united.message.service;

import com.onefly.united.common.page.PageData;
import com.onefly.united.common.service.BaseService;
import com.onefly.united.message.dto.SysMailLogDTO;
import com.onefly.united.message.entity.SysMailLogEntity;

import java.util.Map;

/**
 * 邮件发送记录
 *
 * @author Mark Rundon
 */
public interface SysMailLogService extends BaseService<SysMailLogEntity> {

    PageData<SysMailLogDTO> page(Map<String, Object> params);

    /**
     * 保存邮件发送记录
     * @param templateId  模板ID
     * @param from        发送者
     * @param to          收件人
     * @param cc          抄送
     * @param subject     主题
     * @param content     邮件正文
     * @param status      状态
     */
    void save(Long templateId, String from, String[] to, String[] cc, String subject, String content, Integer status);
}

