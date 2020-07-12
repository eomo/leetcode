package com.hicsc.hash;

/**
 * 哈希函数
 */
public interface HashFunction {

    /**
     * 计算hash值
     */
    long hash(String key);
}
