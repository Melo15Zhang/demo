package com.example.eurekaclient.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 常用字符串处理
 */
public class StringUtil {
    /**
     * 判断字符串是否为null或者""
     *
     * @param string
     * @return
     */
    public static boolean isNullOrEmpty(String string) {
        return null == string || "".equals(string) || string.length() <= 0;
    }

    /**
     * 获取指定分隔符分隔后list
     *
     * @param string 指定的字符串
     * @param split  分隔符
     * @return list
     */
    public static List<String> getSplitList(String string, String split) {
        List<String> valueList = new ArrayList<>();
        if (!StringUtil.isNullOrEmpty(string)) {
            String[] values = string.split(split);
            for (String str : values) {
                if (str != "") {
                    valueList.add(str);
                }
            }
        }
        return valueList;
    }

    /**
     * 获取UUID字符串
     *
     * @return
     */
    public static String getTaskId() {
        return UUID.randomUUID().toString();
    }
}
