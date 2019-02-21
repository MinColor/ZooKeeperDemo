/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderNumGenerator
 * Author:   Administrator
 * Date:     2019/2/21 11:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lock;

/**
 * 描述〈〉
 * 作者 Administrator
 * 时间 2019/2/21
 * 版本 1.0.0
 */
import java.text.SimpleDateFormat;
import java.util.Date;

//生成订单号 时间戳
public class OrderNumGenerator {
    //区分不同的订单号
    private static int count = 0;
    //单台服务器，多个线程 同事生成订单号
    public String getNumber(){
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
        SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return simpt.format(new Date()) + "-" + ++count;  //时间戳后面加了 count

    }

}