package common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
//将list/map/set/数组等转换成json
public class JsonDateValueProcessor implements JsonValueProcessor{

	private String datePattern = "yyyy-MM-dd HH:mm:ss";
    public JsonDateValueProcessor() {
		super();
	}
    public JsonDateValueProcessor(String format) {
		super();
		this.setDatePattern(format);
	}

    
	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return process(arg0);
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig arg2) {
		return process(value);
	}
	
	private Object process(Object value) {
		try {
			//是date类型
			if (value instanceof Date) {
				SimpleDateFormat dt=new SimpleDateFormat(datePattern,Locale.UK);
				return dt.format((Date)value);
			}
			System.out.println(value.toString());
            return value == null ? "" : value.toString();
		} catch (Exception e) {
			return "";
		}
	}
	
	public String getDatePattern() {
		return datePattern;
	}
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

}
