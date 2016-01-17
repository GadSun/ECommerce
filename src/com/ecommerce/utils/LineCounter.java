package com.ecommerce.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @date 2015-12-06
 * @author HERO
 * @TODO: 遍历src中所有的文件，计算文件行数，并忽略空白行
 */
public class LineCounter{
	List<File> list = new ArrayList<File>();
	int linenumber = 0;

	FileReader fr = null;
	BufferedReader br = null;

	public void counter(String path) {
		// String path = System.getProperty("user.dir");
		//String path = LineConter.class.getResource("/").getPath(); // 同下个path
		//path = path.substring(0, path.length() - 24) + projectName + "/src";
		path = path + "\\src";
		System.out.println(path);
		File file = new File(path);
		File files[] = null;
		files = file.listFiles();
		addFile(files);
		isDirectory(files);
		readLinePerFile();
		System.out.println("Totle:" + linenumber + "行");
	}

	// 判断是否是目录
	public void isDirectory(File[] files) {
		for (File s : files) {
			if (s.isDirectory()) {
				File file[] = s.listFiles();
				addFile(file);
				isDirectory(file);
				continue;
			}
		}
	}

	// 将src下所有文件组织成list
	public void addFile(File file[]) {
		for (int index = 0; index < file.length; index++) {
			list.add(file[index]);
			// System.out.println(list.size());
		}
	}

	// 读取非空白行
	public void readLinePerFile() {
		try {
			for (File s : list) {
				int yuan = linenumber;
				if (s.isDirectory()) {
					continue;
				}
				fr = new FileReader(s);
				br = new BufferedReader(fr);
				String i = "";
				while ((i = br.readLine()) != null) {
					if (isBlankLine(i))
						linenumber++;
				}
				System.out.print(s.getName());
				System.out.println("\t\t有" + (linenumber - yuan) + "行");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (Exception e) {
				}
			}
		}
	}

	// 是否是空行
	public boolean isBlankLine(String i) {
		if (i.trim().length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String args[]) {
		LineCounter lc = new LineCounter();
		String projectName = "\\ecommerce"; // 这里传入你的项目名称
		//System.out.println(LineConter.class.getResource("").getPath());
		String workspace = "C:\\My Files\\MyEclipse2015\\WorkSpace";// 这里传入你的workspace地址
		lc.counter(workspace + projectName);
	}
}
