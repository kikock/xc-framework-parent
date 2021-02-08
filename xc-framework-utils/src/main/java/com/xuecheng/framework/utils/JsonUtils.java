package com.xuecheng.framework.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @project_name: xc-framework-utils
 * @description: json工具类
 * @create_name: kikock
 * @create_date: 2021-01-21 16:23
 **/
//忽略警告
@SuppressWarnings("unchecked")
public class JsonUtils {

    /**
     * 将json通过类型转换成对象
     *
     * @param <T>   泛型
     * @param json  json字符串
     * @param clazz 泛型类型
     * @return 返回对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (null == json || json.equals("")) {
            return null;
        } else {
            try {
                ObjectMapper om = mapper();
                return clazz.equals(String.class) ? (T) json : om.readValue(json, clazz);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /**
     * 将Json反序列化为List<T>
     *
     * @param <T>   泛型
     * @param json  json字符串
     * @param clazz 集合元素类型
     * @return 返回集合对象
     */
    public static <T> List<T> fromJson2List(String json, Class<T> clazz) {
        if (null == json || json.equals("")) {
            return null;
        } else {
            try {
                ObjectMapper om = mapper();
                JavaType javaType = om.getTypeFactory().constructParametricType(ArrayList.class, clazz);
                return om.readValue(json, javaType);
                //return om.readValue(json, new TypeReference<List<T>>() {});
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /**
     * 将对象转换成json
     *
     * @param <T> 泛型
     * @param src 对象
     * @return 返回json字符串
     */
    public static <T> String toJson(T src) {
        return toJson(src, null, (String[]) null);
    }

    /**
     * 将对象转换成json
     *
     * @param <T>        泛型
     * @param src        对象
     * @param properties 过滤属性(排除的属性)
     * @return 返回json字符串
     */
    public static <T> String toJson(T src, String... properties) {
        return toJson(src, null, properties);
    }

    /**
     * 将对象转换成json, 可以设置输出属性
     *
     * @param <T>       泛型
     * @param src       对象
     * @param inclusion 传入一个枚举值, 设置输出属性
     * @return 返回json字符串
     */
    public static <T> String toJson(T src, JsonInclude.Include inclusion, String... properties) {
        if (null == src) {
            return null;
        }

        if (src instanceof String) {
            return (String) src;
        } else {
            try {
                ObjectMapper om = generateMapper((null == inclusion) ? JsonInclude.Include.ALWAYS : inclusion);
                if (null != properties && properties.length > 0) {
                    FilterProvider fp = new SimpleFilterProvider().addFilter("customFilter", SimpleBeanPropertyFilter.serializeAllExcept(properties));
                    om.setFilterProvider(fp);
                }

                return om.writeValueAsString(src);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /**
     * 将对象转换成json, 传入配置对象
     *
     * @param <T>    泛型
     * @param src    对象
     * @param mapper 配置对象
     * @return 返回json字符串
     * @throws IOException IOException
     * @see ObjectMapper
     */
    public static <T> String toJson(T src, ObjectMapper mapper) throws IOException {
        if (null != mapper) {
            if (src instanceof String) {
                return (String) src;
            } else {
                return mapper.writeValueAsString(src);
            }
        } else {
            return null;
        }
    }

    /**
     * 通过路径获取节点值
     *
     * @param json 需处理的Json字符串
     * @param path 获取路径
     * @return 返回指定路径获取节点值
     */
    public String getNodeString(String json, String path) {
        String nodeStr;
        if (json == null || json.trim().equals("")) {
            return null;
        }
        if (path == null || path.trim().equals("")) {
            return json;
        }

        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode jn = om.readTree(json);
            nodeStr = jn.path(path).toString();
        } catch (Exception e) {
            throw new RuntimeException("解析json错误");
        }

        return nodeStr;
    }

    /**
     * 返回{@link ObjectMapper ObjectMapper}对象, 用于定制性的操作
     *
     * @return {@link ObjectMapper ObjectMapper}对象
     */
    public static ObjectMapper mapper() {
        return generateMapper(JsonInclude.Include.NON_NULL);
    }

    /**
     * 通过Inclusion创建ObjectMapper对象
     *
     * @param include 传入一个枚举值, 设置输出属性
     * @return 返回ObjectMapper对象
     */
    private static ObjectMapper generateMapper(JsonInclude.Include include) {
        ObjectMapper objectMapper = new ObjectMapper();

        // 设置输出时包含属性的风格
        objectMapper.setSerializationInclusion(include);

        //设置为中国上海时区
        //objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        //空对象不要抛异常
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        //反序列化时，属性不存在的兼容处理
        //objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        return objectMapper;
    }
}
