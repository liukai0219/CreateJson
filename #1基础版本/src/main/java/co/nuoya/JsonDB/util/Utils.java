package co.nuoya.JsonDB.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.google.gson.Gson;

import co.nuoya.JsonDB.model.Customer;

public class Utils {
	/**
	 * 输出信息
	 * @param msg
	 */
	public static void printMsg(String msg) {
		System.out.println(msg);
	}
	
	/**
	 * 从json文件中读取数据，生成list
	 * @param path
	 * @return result
	 */
	public static <T> List<T> readJsonToList(String path,Class<T> clazz) {
		String content = "";
		List<T> result = new ArrayList<T>();
		File file = new File(path);
		try {
			content = FileUtils.readFileToString(file,"UTF-8");
			Gson gson = new Gson();
			Type type = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
			result = gson.fromJson(content, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> String writeListToJson(List<T> list) {
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	
	public static Logger getFileLogger() {
		return (Logger) LogManager.getLogger(Constants.ASYN_ROLLING_FILE_LOGGER); 
	}
	
	public static Logger getsFileFormatterLogger() {
		return (Logger) LogManager.getFormatterLogger(Constants.ASYN_ROLLING_FILE_LOGGER);
	}
	
	public static Logger getConsoleLogger() {
		return (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME); 
	}
	
	public static Logger getConsoleFormatterLogger() {
		return (Logger) LogManager.getFormatterLogger(LogManager.ROOT_LOGGER_NAME); 
	}
	
}
