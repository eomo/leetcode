package com.hicsc.hash;

import java.util.LinkedList;
import java.util.List;

public class PhysicalNode implements Node {
    // 服务器IP
    public String ip;
    // 服务器端口
    public int port;
    // 服务器上存储数据量
    public int size;

    public PhysicalNode(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String getKey() {
        return ip + ":" + port;
    }
    // 获取数据量
    public int getDataSize() {
        return size;
    }
    public double getOffset() {
        return Math.pow((size - 100000), 2);
    }
}
