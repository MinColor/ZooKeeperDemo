/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JvmH
 * Author:   Administrator
 * Date:     2019/2/21 14:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jvm;

/**
 * 描述〈〉
 * 作者 Administrator
 * 时间 2019/2/21
 * 版本 1.0.0
 */
public class JvmH {
    private static int count;
    public static void count(){
        try {
            count++;
            count();
        } catch (Throwable e) {
            System.out.println("最大深度:"+count);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        count();
    }
}
