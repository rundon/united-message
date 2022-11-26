package com.onefly.united.message.service;

import com.onefly.united.common.service.CrudService;
import com.onefly.united.message.dto.SysMailTemplateDTO;
import com.onefly.united.message.entity.SysMailTemplateEntity;

/**
 * 邮件模板
 *
 * @author Mark Rundon
 */
public interface SysMailTemplateService extends CrudService<SysMailTemplateEntity, SysMailTemplateDTO> {

    /**
     * 发送邮件
     * @param id           邮件模板ID
     * @param mailTo       收件人
     * @param mailCc       抄送
     * @param params       模板参数
     */
    boolean sendMail(Long id, String mailTo, String mailCc, String params) throws Exception;
}