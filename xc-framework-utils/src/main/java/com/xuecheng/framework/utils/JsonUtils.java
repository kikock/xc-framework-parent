package com.xuecheng.framework.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @project_name: xc-framework-utils
 * @description: json工具类
 * @create_name: kikock
 * @create_date: 2021-01-21 16:23
 **/
//忽略警告
@SuppressWarnings("unchecked")
public class JsonUtils {

    //json数据校验
    private static CharacterIterator it;
    private static char c;
    private static int col;

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
     * 验证一个字符串是否是合法的JSON串
     *
     * @param input 要验证的字符串
     * @return true-合法 ，false-非法
     */
    public static boolean validate(String input) {
        input = input.trim();
        boolean ret = valid(input);
        return ret;
    }

    private static boolean valid(String input) {
        if ("".equals(input))
            return true;
        boolean ret = true;
        it = new StringCharacterIterator(input);
        c = it.first();
        col = 1;
        if (!value()) {
            ret = error("value", 1);
        } else {
            skipWhiteSpace();
            if (c != CharacterIterator.DONE) {
                ret = error("end", col);
            }
        }
        return ret;
    }

    private static boolean value() {
        return literal("true") || literal("false") || literal("null") || string() || number() || object() || array();
    }

    private static boolean literal(String text) {
        CharacterIterator ci = new StringCharacterIterator(text);
        char t = ci.first();
        if (c != t)
            return false;
        int start = col;
        boolean ret = true;
        for (t = ci.next(); t != CharacterIterator.DONE; t = ci.next()) {
            if (t != nextCharacter()) {
                ret = false;
                break;
            }
        }
        nextCharacter();
        if (!ret)
            error("literal " + text, start);
        return ret;
    }

    private static boolean array() {
        return aggregate('[', ']', false);
    }

    private static boolean object() {
        return aggregate('{', '}', true);
    }

    private static boolean aggregate(char entryCharacter, char exitCharacter, boolean prefix) {
        if (c != entryCharacter)
            return false;
        nextCharacter();
        skipWhiteSpace();
        if (c == exitCharacter) {
            nextCharacter();
            return true;
        }
        for (; ; ) {
            if (prefix) {
                int start = col;
                if (!string())
                    return error("string", start);
                skipWhiteSpace();
                if (c != ':')
                    return error("colon", col);
                nextCharacter();
                skipWhiteSpace();
            }
            if (value()) {
                skipWhiteSpace();
                if (c == ',') {
                    nextCharacter();
                } else if (c == exitCharacter) {
                    break;
                } else {
                    return error("comma or " + exitCharacter, col);
                }
            } else {
                return error("value", col);
            }
            skipWhiteSpace();
        }
        nextCharacter();
        return true;
    }

    private static boolean number() {
        if (!Character.isDigit(c) && c != '-')
            return false;
        int start = col;
        if (c == '-')
            nextCharacter();
        if (c == '0') {
            nextCharacter();
        } else if (Character.isDigit(c)) {
            while (Character.isDigit(c))
                nextCharacter();
        } else {
            return error("number", start);
        }
        if (c == '.') {
            nextCharacter();
            if (Character.isDigit(c)) {
                while (Character.isDigit(c))
                    nextCharacter();
            } else {
                return error("number", start);
            }
        }
        if (c == 'e' || c == 'E') {
            nextCharacter();
            if (c == '+' || c == '-') {
                nextCharacter();
            }
            if (Character.isDigit(c)) {
                while (Character.isDigit(c))
                    nextCharacter();
            } else {
                return error("number", start);
            }
        }
        return true;
    }

    private static boolean string() {
        if (c != '"')
            return false;
        int start = col;
        boolean escaped = false;
        for (nextCharacter(); c != CharacterIterator.DONE; nextCharacter()) {
            if (!escaped && c == '\\') {
                escaped = true;
            } else if (escaped) {
                if (!escape()) {
                    return false;
                }
                escaped = false;
            } else if (c == '"') {
                nextCharacter();
                return true;
            }
        }
        return error("quoted string", start);
    }

    private static boolean escape() {
        int start = col - 1;
        if (" \\\"/bfnrtu".indexOf(c) < 0) {
            return error("escape sequence  \\\",\\\\,\\/,\\b,\\f,\\n,\\r,\\t  or  \\uxxxx ", start);
        }
        if (c == 'u') {
            if (!ishex(nextCharacter()) || !ishex(nextCharacter()) || !ishex(nextCharacter())
                    || !ishex(nextCharacter())) {
                return error("unicode escape sequence  \\uxxxx ", start);
            }
        }
        return true;
    }

    private static boolean ishex(char d) {
        return "0123456789abcdefABCDEF".indexOf(c) >= 0;
    }

    private static char nextCharacter() {
        c = it.next();
        ++col;
        return c;
    }

    private static void skipWhiteSpace() {
        while (Character.isWhitespace(c)) {
            nextCharacter();
        }
    }

    private static boolean error(String type, int col) {
        System.out.printf("type: %s, col: %s%s", type, col, System.getProperty("line.separator"));
        return false;
    }

    /**
     * 将json字符串转为Map结构
     * 如果json复杂，结果可能是map嵌套map
     *
     * @param jsonStr 入参，json格式字符串
     * @return 返回一个map
     */
    public static Map<String, Object> json2Map(String jsonStr) {
        Map<String, Object> map = new HashMap<>();
        if (jsonStr != null && !"".equals(jsonStr)) {
            //最外层解析
            JSONObject json = JSONObject.parseObject(jsonStr);
            for (Object k : json.keySet()) {
                Object v = json.get(k);
                //如果内层还是数组的话，继续解析
                if (v instanceof JSONArray) {
                    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                    Iterator<Object> it = ((JSONArray) v).iterator();
                    while (it.hasNext()) {
                        JSONObject json2 = (JSONObject) it.next();
                        list.add(json2Map(json2.toString()));
                    }
                    map.put(k.toString(), list);
                } else {
                    map.put(k.toString(), v);
                }
            }
            return map;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

        System.out.println(JsonUtils.validate("231231"));
        Map<String, Object> map3 = json2Map("231231");
        System.out.println(map3);
        String jsonp = "{\n" +
                "\"data\": [\n" +
                "        {\n" +
                "            \"IR_SRCNAME\": \"车主之家\",\n" +
                "                \"IR_SITENAME\": \"车主之家\",\n" +
                "                \"IR_AUTHORS\": null,\n" +
                "                \"IR_URLTITLE\": \"2017年4月份高尔夫销量11798台, 同比下降20.24%\",\n" +
                "                \"IR_URLNAME\": \"http://news.16888.com/a/2017/0521/8172148.html\",\n" +
                "                \"IR_ABSTRACT\": \" 2017年4月份高尔夫销量11798台 \",\n" +
                "                \"IR_URLTIME\": \"2017/05/21 23:35:00\",\n" +
                "                \"IR_HKEYBBSNUM\": \"18093721078864168420-0\",\n" +
                "                \"IR_CHANNEL\": \"新闻_汽车新闻\", \n" +
                "                \"COMPANY_RISK_CONN\": \"汽车之家股份有限公司_财务风险偿债能力营运资本_18;\",\n" +
                "                \"ZFM\": \"负面\"\n" +
                "        }\n" +
                "    ],\n" +
                "        \"path\": \"/cloud/wsu/queryByKeyword!get_by_fullname.action\",\n" +
                "                \"rstcode\": \"0000\",\n" +
                "                \"rstcount\": 19476,\n" +
                "                \"cmpname\": \"汽车之家股份有限公司\",\n" +
                "                \"shortname\": \"汽车之家\",\n" +
                "                \"rstmsg\": \"查询成功\"\n" +
                "    }\n";
        Map<String, Object> map = json2Map(jsonp);
        System.out.println(JsonUtils.toJson(map));
        // Map<String, Object> map2 = json2Map("3213123");
        // System.out.println(JsonUtils.toJson(map2));
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
}
