/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZookeeperDistrbuteLock
 * Author:   Administrator
 * Date:     2019/2/21 11:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lock;
import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * 描述〈〉
 * 作者 Administrator
 * 时间 2019/2/21
 * 版本 1.0.0
 */
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {
    private String lockPath="/lockPath";
    private CountDownLatch countDownLatch = null;
    @Override
    boolean tryLock() {
        try {
            zkClient.createEphemeral(lockPath);
//            System.out.println("#########获取锁######");
            return true;
        } catch (Exception e) {
            // 如果失败 直接catch
            return false;
        }
    }

    @Override
    void waitLock() {

        IZkDataListener iZkDataListener = new IZkDataListener() {

            // 节点被删除
            public void handleDataDeleted(String arg0) throws Exception {

                if (countDownLatch != null) {
                    countDownLatch.countDown(); // 计数器为0的情况，await 后面的继续执行
                }else{
                    System.out.println("删除了锁...");
                }

            }

            // 节点被修改
            public void handleDataChange(String arg0, Object arg1) throws Exception {

            }
        };

        // 监听事件通知
        zkClient.subscribeDataChanges(lockPath, iZkDataListener);
        // 控制程序的等待
        if (zkClient.exists(lockPath)) {  //如果 检查出 已经被创建了 就new 然后进行等待
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.wait(); //等待时候 就不往下走了   当为0 时候 后面的继续执行
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        //后面代码继续执行
        //为了不影响程序的执行 建议删除该事件监听 监听完了就删除掉
        zkClient.unsubscribeDataChanges(lockPath, iZkDataListener);

    }

}
