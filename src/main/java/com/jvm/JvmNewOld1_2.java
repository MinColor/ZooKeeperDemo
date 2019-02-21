/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JvmNewOld1_2
 * Author:   Administrator
 * Date:     2019/2/21 14:51
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
public class JvmNewOld1_2 {
    public static void main(String[] args) {
        byte[] b = new byte[13 * 1024 * 1024];  //4M
        System.out.print("最大内存");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
        System.out.print("可用内存");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
        System.out.print("已经使用内存");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    }
}
