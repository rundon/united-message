package com.onefly.united.notice.enums;

/**
 * 通知状态枚举
 *
 * @author Mark Rundon
 */
public enum NoticeStatusEnum {
    /**
     * 草稿
     */
    DRAFT(0),
    /**
     * 发送
     */
    SEND(1);

    private int value;

    NoticeStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
