package com.maven.ReadJson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maven.DAO.CustomerDAO;
import com.maven.DAO.CustomerDAOImpl;
import com.maven.bean.Customer;
import com.maven.utils.Utils;

public class JsonRead {
	
	public static void main(String[] args) throws IOException {
		int menu;  //保存菜单序号
		
		while (true) {
			//输出菜单那界面
			Utils.printMenuInfo();
			//读取一个序号
			menu = readMenuNum();
			switch (menu) {
				case 1:
					//导入JSON文件功能
					readJsonFile();
					break;
				case 2:
					//清空数据库功能
					deleteDB();
					break;
				case 3:
					//查看所有数据功能
					findAllCustomer();
					break;
				case 4:
					//退出
					exitApplication();
					break;
			}
		}
	}
	/**
	 * 让操作者输入一个数字，
	 * 非数字则输出警告信息：禁止输入数以外的字符！，
	 * 并让重新输入
	 * @return Integer.parseInt(menu) 端末输入的序号
	 */
	private static int readMenuNum() {
		Scanner scan = new Scanner(System.in);
		String menu = "";
		boolean isNotNumber = true;
		do {
			System.out.println("请输入序号：");
			menu = scan.nextLine();
			try {
				Integer.parseInt(menu);
				isNotNumber = false;
			} catch (NumberFormatException e) {
				isNotNumber = true;
				System.out.println("禁止输入数以外的字符！");
			}
		} while (isNotNumber); 
		return Integer.parseInt(menu);
	}
	/**
	 * 读取JSON文件内容并按Operate操作
	 * Operate：add 添加顾客信息
	 * Operate：del 删除顾客信息
	 * Operate：upd 更新顾客信息
	 * @throws IOException
	 */
	private static void readJsonFile()  throws IOException{
		Scanner scan = new Scanner(System.in);
		String path = "";
		File file = null;
		do {
			Utils.printInputJsonInfo();
			path = scan.nextLine();
			file = new File(path);
		} while(!(file.exists()&&file.isFile()));
		
		String content = FileUtils.readFileToString(file,"UTF-8");
		
		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<Customer>>(){}.getType();
		List<Customer> customer = gson.fromJson(content, collectionType);
		
		CustomerDAO custdao = new CustomerDAOImpl();

		customer.forEach($->{
			switch ($.getOperate()) {
			case "add":
				if (!isCustomerExist($.getId())) {
					if (custdao.addCustomer($) == 1) {
						Utils.printMsg("ID为" + $.getId() + "的顾客添加成功！");
					}
				} else {
					Utils.printMsg("顾客添加失败！原因：ID为" + $.getId() + "的顾客已存在！");
				}
			break;
			case "del":
				if (isCustomerExist($.getId())) {
					if (custdao.deleteCustomer($.getId()) == 1) {
						Utils.printMsg("ID为" + $.getId() + "的顾客删除成功！");
					}
				} else {
					Utils.printMsg("顾客删除失败！原因：ID为" + $.getId() + "的顾客不存在！");
				}
				break;
			case "upd":
				if (isCustomerExist($.getId())) {
					if (custdao.updateCustomer($) == 1) {
						Utils.printMsg("ID为" + $.getId() + "的顾客更新成功！");
					}
				} else {
					Utils.printMsg("顾客更新失败！原因：ID为" + $.getId() + "的顾客不存在！");
				}
				break;
			}
		});

	}
	/**
	 * 查看顾客是否存在
	 * @param id 顾客ID
	 * @return true：存在    false：不存在
	 */
	private static boolean isCustomerExist(String id) {
		CustomerDAO custdao = new CustomerDAOImpl();
		List<Customer> result = custdao.findCustomer(id);
		Utils.printMsg("sise:"+String.valueOf(result.size()));
		return result.size() > 0 ? true : false;
	}
	/**
	 * 删除顾客信息
	 * 成功则输出：数据库中数据已全部删除！
	 */
	private static void deleteDB() {
		CustomerDAO custdao = new CustomerDAOImpl();
		
		Utils.printMsg("确定要删除？");
		Utils.printMsg("1.YES");
		Utils.printMsg("2.NO");
		int num = readMenuNum();
		
		if (num == 1) {
			int result = custdao.deleteCustomer(null);
			if (result >= 0) {
				Utils.printMsg("数据库中数据已全部删除！");
			} else {
				Utils.printMsg("删除失败！");
			}
		} else {
			Utils.printMsg("操作已取消！");
		}
		
	}
	/**
	 * 查询并输出所有顾客信息
	 */
	private static void findAllCustomer() {
		CustomerDAO custdao = new CustomerDAOImpl();
		List<Customer> result = custdao.findCustomer(null);
		result.forEach($->{
			Utils.printMsg($.toString());
		});
		Utils.printMsg("总共" + result.size() + "条数据");
	}
	/**
	 * 退出
	 */
	private static void exitApplication() {
		System.exit(0);
	}
}
