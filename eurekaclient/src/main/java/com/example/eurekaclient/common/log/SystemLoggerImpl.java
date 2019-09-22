package com.example.eurekaclient.common.log;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志的处理类
 */
public class SystemLoggerImpl implements SystemLogger {

    private static final String DEFAULT_CLASSNAME = "__SYS__";
    private static final String URL_LABEL = "url:%s";
    private static final String ARGS_LABEL = "args:%s";
    private static final String RETURN_LABEL = "return:%s";
    private static final String EX_LABEL = "ex:%s";

    private String className;

    private Logger logger = null;

    public SystemLoggerImpl(Class<?> cla){
        if(cla != null){
            this.className = cla.getName();
        }else{
            this.className = DEFAULT_CLASSNAME;
        }

        this.logger = LoggerFactory.getLogger(this.className);
    }

    /**
     * request url info日志
     *
     * @param infoURL
     */
    @Override
    public void infoURL(String infoURL) {
        String infoMsg = String.format(URL_LABEL,infoURL);
        logger.info(infoMsg);
    }

    /**
     * args info日志
     *
     * @param info
     */
    @Override
    public void infoArgs(String info) {
        String infoMsg = String.format(ARGS_LABEL,info);
        logger.info(infoMsg);
    }

    /**
     * return json info日志
     *
     * @param infoReturn
     */
    @Override
    public void infoReturn(Object infoReturn) {
        String infoMsg = String.format(RETURN_LABEL,JSON.toJSONString(infoReturn));
        logger.info(infoMsg);
    }

    /**
     * Info日志级别判断
     *
     * @return
     */
    @Override
    public boolean isInfoEnabled(){
        return logger.isInfoEnabled();
    }

    /**
     * debug日志
     *
     * @param debugArgs
     */
    @Override
    public void debugArgs(String debugArgs) {
        String debugMsg = String.format(ARGS_LABEL,debugArgs);
        logger.debug(debugMsg);
    }

    /**
     * debug日志
     *
     * @param debugReturn
     */
    @Override
    public void debugReturn(Object debugReturn) {
        String debugMsg = String.format(RETURN_LABEL,JSON.toJSONString(debugReturn));
        logger.debug(debugMsg);
    }

    /**
     * Debug日志级别判断
     *
     * @return
     */
    @Override
    public boolean isDebugEnabled(){
        return logger.isDebugEnabled();
    }

    /**
     * error日志
     *
     * @param error
     */
    @Override
    public void error(String error) {
        String errorMsg = String.format(EX_LABEL,error);
        logger.error(errorMsg);
    }

    /**
     * Error日志级别判断
     *
     * @return
     */
    @Override
    public boolean isErrorEnabled(){
        return logger.isErrorEnabled();
    }
}
