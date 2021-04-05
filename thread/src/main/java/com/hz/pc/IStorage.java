package com.hz.pc;

/**
 * @author HuZhuang
 * @description 缓冲区接口
 * @date 2021-04-05 18:14
 */
public interface IStorage {

    /**
     * 生产
     */
    void produce();

    /**
     * 消费
     */
    void consume();
}
