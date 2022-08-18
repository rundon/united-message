-- 短信
create table sys_sms
(
    id          bigint NOT NULL COMMENT 'id',
    sms_code    varchar(32) COMMENT '短信编码',
    platform    tinyint unsigned NOT NULL COMMENT '平台类型',
    sms_config  varchar(2000) COMMENT '短信配置',
    remark      varchar(200) COMMENT '备注',
    creator     bigint COMMENT '创建者',
    create_date datetime COMMENT '创建时间',
    updater     bigint COMMENT '更新者',
    update_date datetime COMMENT '更新时间',
    primary key (id),
    unique key uk_sms_code (sms_code),
    key         idx_create_date (create_date)
)ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='短信';

-- 短信日志
CREATE TABLE sys_sms_log
(
    id          bigint NOT NULL COMMENT 'id',
    sms_code    varchar(32) COMMENT '短信编码',
    platform    tinyint unsigned NOT NULL COMMENT '平台类型',
    mobile      varchar(20) COMMENT '手机号',
    params_1    varchar(50) COMMENT '参数1',
    params_2    varchar(50) COMMENT '参数2',
    params_3    varchar(50) COMMENT '参数3',
    params_4    varchar(50) COMMENT '参数4',
    status      tinyint unsigned COMMENT '发送状态  0：失败  1：成功',
    creator     bigint COMMENT '创建者',
    create_date datetime COMMENT '创建时间',
    PRIMARY KEY (id),
    key         idx_sms_code (sms_code)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='短信日志';

-- 邮件发送记录
CREATE TABLE sys_mail_log
(
    id          bigint NOT NULL COMMENT 'id',
    template_id bigint NOT NULL COMMENT '邮件模板ID',
    mail_from   varchar(200) COMMENT '发送者',
    mail_to     varchar(400) COMMENT '收件人',
    mail_cc     varchar(400) COMMENT '抄送者',
    subject     varchar(200) COMMENT '邮件主题',
    content     text COMMENT '邮件正文',
    status      tinyint unsigned COMMENT '发送状态  0：失败  1：成功',
    creator     bigint COMMENT '创建者',
    create_date datetime COMMENT '创建时间',
    PRIMARY KEY (id),
    key         idx_create_date (create_date)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='邮件发送记录';
-- 邮件模板
CREATE TABLE sys_mail_template
(
    id          bigint NOT NULL COMMENT 'id',
    name        varchar(100) COMMENT '模板名称',
    subject     varchar(200) COMMENT '邮件主题',
    content     text COMMENT '邮件正文',
    creator     bigint COMMENT '创建者',
    create_date datetime COMMENT '创建时间',
    updater     bigint COMMENT '更新者',
    update_date datetime COMMENT '更新时间',
    PRIMARY KEY (id),
    key         idx_create_date (create_date)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='邮件模板';

INSERT INTO sys_mail_template(id, name, subject, content, create_date)
VALUES (1067246875800000077, '验证码模板', '人人开源注册验证码', replace('<p>人人开源注册验证码：%{code}</p>','%','$'), now());

INSERT INTO sys_sms(id, sms_code, platform, sms_config, remark, creator, create_date, updater, update_date)
VALUES (1228954061084676097, '1001', 1,
        '{"aliyunAccessKeyId":"1","aliyunAccessKeySecret":"1","aliyunSignName":"1","aliyunTemplateCode":"1","qcloudAppKey":"","qcloudSignName":"","qcloudTemplateId":"","qiniuAccessKey":"","qiniuSecretKey":"","qiniuTemplateId":""}',
        '', 1067246875800000001, now(), 1067246875800000001, now());

-- 通知管理
CREATE TABLE sys_notice
(
    id                bigint NOT NULL COMMENT 'id',
    type              int    NOT NULL COMMENT '通知类型',
    title             varchar(200) COMMENT '标题',
    content           text COMMENT '内容',
    receiver_type     tinyint unsigned COMMENT '接收者  0：全部  1：部门',
    receiver_type_ids varchar(500) COMMENT '接收者ID，用逗号分开',
    status            tinyint unsigned COMMENT '发送状态  0：草稿  1：已发布',
    sender_name       varchar(50) COMMENT '发送者',
    sender_date       datetime COMMENT '发送时间',
    creator           bigint COMMENT '创建者',
    create_date       datetime COMMENT '创建时间',
    PRIMARY KEY (id),
    key               idx_create_date (create_date)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='通知管理';

-- 我的通知
CREATE TABLE sys_notice_user
(
    receiver_id bigint NOT NULL COMMENT '接收者ID',
    notice_id   bigint NOT NULL COMMENT '通知ID',
    read_status tinyint unsigned COMMENT '阅读状态  0：未读  1：已读',
    read_date   datetime COMMENT '阅读时间',
    PRIMARY KEY (receiver_id, notice_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='我的通知';

