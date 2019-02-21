/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZookeeperAbstractLock
 * Author:   Administrator
 * Date:     2019/2/21 11:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lock;

import org.I0Itec.zkclient.ZkClient;

/**
 * 描述〈〉
 * 作者 Administrator
 * 时间 2019/2/21
 * 版本 1.0.0
 */

//将重复代码抽象到子类中（模板方法设计模式）
public abstract class ZookeeperAbstractLock implements ExtLock {
    private static final String CONNECTION="Master:2181,Slave1:2181,Slave2:2181,SNN:2181";
    protected ZkClient zkClient = new ZkClient(CONNECTION);


    //获取锁
    public void getLock() {
        //1、连接zkClient 创建一个/lock的临时节点
        // 2、 如果节点创建成果，直接执行业务逻辑，如果节点创建失败，进行等待
        if (tryLock()) {
            System.out.println("#####成功获取锁######");
        }else {
            //进行等待
            waitLock();
        }

        //3、使用事件通知监听该节点是否被删除    ，如果是，重新进入获取锁的资源

    }

    //创建失败 进行等待
    abstract void waitLock();


    abstract boolean tryLock();


    //释放锁
    public void unLock() {
        //执行完毕 直接连接
        if (zkClient != null) {
            zkClient.close();
            System.out.println("######释放锁完毕######");
        }

    }

}
