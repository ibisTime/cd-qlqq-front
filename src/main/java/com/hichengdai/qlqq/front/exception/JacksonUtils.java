package com.hichengdai.qlqq.front.exception;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * 功能说明:
 * <p> 系统版本: v1.0<br>
 * 开发人员: xuebj xuebojie2@sina.com <br>
 * 开发时间: 14-3-26 上午10:12 <br>
 * 功能描述: 写明作用，调用方式，使用场景，以及特殊情况<br>
 */

public abstract class JacksonUtils {

    private static final Logger logger = LoggerFactory
        .getLogger(JacksonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 设置默认日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        // 提供其它默认设置
        objectMapper.setFilters(new SimpleFilterProvider()
            .setFailOnUnknownId(false));
    }

    /**
     *  转换对象到json 格式字符串，如果转换失败 返回null
     * @param object
     * @return
     */
    public final static String toJsonString(Object object, String... properties) {
        try {
            SimpleFilterProvider fileter = new SimpleFilterProvider();
            fileter.addFilter(
                AnnotationUtils.findAnnotation(object.getClass(),
                    JsonFilter.class).value(),
                SimpleBeanPropertyFilter.filterOutAllExcept(properties));
            return objectMapper.writer(fileter).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("转换对象【" + object.toString() + "】到json格式字符串失败：" + e);
            return null;
        }
    }

    public final static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("转换对象【" + object.toString() + "】到json格式字符串失败：" + e);
            return null;
        }
    }
}
