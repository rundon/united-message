package com.onefly.united.message.service;

import com.onefly.united.common.service.CrudService;
import com.onefly.united.message.dto.SysSmsDTO;
import com.onefly.united.message.entity.SysSmsEntity;

/**
 * 短信
 *
 * @author Mark Rundon
 */
public interface SysSmsService extends CrudService<SysSmsEntity, SysSmsDTO> {

    /**
     * 发送短信
     * @param smsCode   短信编码
     * @param mobile   手机号
     * @param params   短信参数
     */
    void send(String smsCode, String mobile, String params);

    SysSmsEntity getBySmsCode(String smsCode);

}

