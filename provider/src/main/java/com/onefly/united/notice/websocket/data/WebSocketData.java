package com.onefly.united.notice.websocket.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.websocket.Session;

/**
 * WebSocket连接数据
 *
 * @author Mark Rundon
 */
@Data
@AllArgsConstructor
public class WebSocketData {
    private Long userId;
    private Session session;
}