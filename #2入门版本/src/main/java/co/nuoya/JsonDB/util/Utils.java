package co.nuoya.JsonDB.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	public static <T> List<T> readJsonToList(String path,Type collectionType) {
		String content = "";
		List<T> result = new ArrayList<T>();
		File file = new File(path);
		try {
			content = FileUtils.readFileToString(file,"UTF-8");
			Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Customer.class, new CustomerAdapter()).create();
			result = gson.fromJson(content, collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> String writeListToJson(List<T> list) {
		Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Customer.class, new CustomerAdapter()).create();
		return gson.toJson(list);
	}
	
	public static Logger getFileLogger() {
		return (Logger) LoggerFactory.getLogger(Constants.ASYN_ROLLING_FILE_LOGGER);
	}
	
	
}
