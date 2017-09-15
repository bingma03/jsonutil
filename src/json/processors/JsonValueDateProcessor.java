//******************************************************************************
// 版权所有(c) 2017，科大国创软件股份有限公司，保留所有权利。
//******************************************************************************

package json.processors;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 自定义日期处理器.
 * @author mabing
 */
public class JsonValueDateProcessor implements JsonValueProcessor {
    
    private static final String DEFUAT_DATE_PATTERN = "yyyy-MM-dd";
    private DateFormat dateFormat;
    
    /*
     * 构造函数，初始化dateFormat.
     */
    public JsonValueDateProcessor(String pattern) {
        try {
            dateFormat = new SimpleDateFormat(pattern);
        } catch (Exception e) {
            dateFormat = new SimpleDateFormat(DEFUAT_DATE_PATTERN);
        }
    }

    
    /**
     * 格式化日期.
     * 
     * @param value JSON值
     * @return 对象
     */
    private Object processor(Object value) {
        if (value == null ) {
            return "";
        }
        return dateFormat.format((Date)value);
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        // TODO Auto-generated method stub
        return processor(value);
    }

    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        // TODO Auto-generated method stub
        return processor(value);
    }
}
