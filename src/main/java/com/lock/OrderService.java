/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderService
 * Author:   Administrator
 * Date:     2019/2/21 11:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderService implements Runnable {

    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator(); // 定义成全局的
    private ExtLock lock = new ZookeeperDistrbuteLock();
    //private Lock lock = new ReentrantLock();

    public void run() {
        try {
            Thread.sleep(500);
            getNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized void getNumber() { // 加锁 保证线程安全问题 让一个线程操作
        try {
            lock.getLock();
           // lock.lock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",number" + number);

        } catch (Exception e) {

        } finally {
            lock.unLock();
            //lock.unlock();
        }
    }

    public static void main(String[] args) {
//        OrderService orderService = new OrderService();
       /* for (int i = 0; i < 30; i++) { // 开启100个线程
            //模拟分布式锁的场景
            new Thread(new OrderService()).start();

        }*/

        while (true) {
            Object o=new Object();
        }
    }

}
