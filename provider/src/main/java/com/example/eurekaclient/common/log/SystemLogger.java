package com.example.eurekaclient.common.log;

public interface SystemLogger {

    /**
     * request url info日志
     *
     * @param infoURL
     */
    void infoURL(String infoURL);

    /**
     * args info日志
     *
     * @param argsInfo
     */
    void infoArgs(String argsInfo);

    /**
     * return info日志
     *
     * @param returnInfo
     */
    void infoReturn(Object returnInfo);

    /**
     * Info日志级别判断
     *
     * @return
     */
    boolean isInfoEnabled();

    /**
     * debug日志
     *
     * @param debugArgs
     */
    void debugArgs(String debugArgs);

    /**
     * debug日志
     *
     * @param debugReturn
     */
    void debugReturn(Object debugReturn);

    /**
     * Debug日志级别判断
     *
     * @return
     */
    boolean isDebugEnabled();

    /**
     * error日志
     *
     * @param error
     */
    void error(String error);

    /**
     * Error日志级别判断
     *
     * @return
     */
    boolean isErrorEnabled();
}
