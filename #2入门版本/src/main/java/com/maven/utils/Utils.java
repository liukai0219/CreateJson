package com.maven.utils;

public class Utils {
	/**
	 * 输出欢迎界面
	 */
	public static void printMenuInfo() {
		printMsg("*************************************");
		printMsg("*           欢迎使用本系统                      *");
		printMsg("*************************************");
		printMsg("* 1.导入JSON文件                                         *");
		printMsg("* 2.清空数据库                                             *");
		printMsg("* 3.查看所有数据                                         *");
		printMsg("* 4.查询年龄小于30活跃的顾客                  *");
		printMsg("* 5.自定义条件查询顾客                             *");
		printMsg("* 6.通过名字查询顾客                                 *");
		printMsg("* 7.退出                                                        *");
		printMsg("*************************************");
	}
	
	/**
	 * 导入JSON文件 时的提示
	 */
	public static void printInputJsonInfo() {
		printMsg("请输入要读取的JSON文件地址");
		printMsg("输入例如下：");
		printMsg("电脑本地的文件：d:/Workspaces/src/main/java/com/maven/ReadJson/customers.json");
		printMsg("项目目录下文件：./src/main/java/com/maven/ReadJson/customers.json");
		printMsg("请输入：");
	}
	public static void printMsg(String msg) {
		System.out.println(msg);
	}
	
}
