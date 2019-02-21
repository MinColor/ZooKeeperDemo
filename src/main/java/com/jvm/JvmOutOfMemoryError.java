/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JvmOutOfMemoryError
 * Author:   Administrator
 * Date:     2019/2/21 14:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述〈〉
 * 作者 Administrator
 * 时间 2019/2/21
 * 版本 1.0.0
 */
public class JvmOutOfMemoryError {
    public static void main(String[] args) {
        List<Object> listObject = new ArrayList<Object>();
        for (int i = 0; i < 800; i++) {
            System.out.println("i:" + i);
            Byte[] bytes = new Byte[8 * 1024 * 1024];
            listObject.add(bytes);
            System.gc();
        }

    }
}
