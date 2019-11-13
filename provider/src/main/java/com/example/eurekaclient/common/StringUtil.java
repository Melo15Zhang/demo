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
                if (!"".equals(str)) {
                    valueList.add(str);
                }
            }
        }
        return valueList;
    }

    /**
     * 获取int值
     *
     * @param obj
     * @return
     */
    public static int getIntValue(Object obj) {
        int def = 0;
        if (obj != null) {
            try {
                def = Integer.parseInt(obj == null ? "" : obj.toString());
            } catch (Exception ex) {
            }
        }
        return def;
    }

    /**
     * 获取int值
     *
     * @param obj
     * @return
     */
    public static String getString(Object obj) {
        String def = null;
        if (obj != null) {
            try {
                def = obj.toString();
            } catch (Exception ex) {
            }
        }
        return def;
    }

    /**
     * 获取UUID字符串
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
