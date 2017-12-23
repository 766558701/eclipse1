package org.java.demo;

import java.io.File;
import java.io.IOException;

public class Demo {

		public static void main(String[] args) throws IOException {
			File dir = new File("D:\\");
			listDirectory(dir);
		}

		public static void listDirectory(File dir) throws  IOException{  
			/* 
			 * exists()方法用于判断文件或目录是否存在 
			 * 当目录不存在，或存在但不是目录时抛出异常 
			 */  
			if (!dir.exists()) {  
				throw new IllegalArgumentException("目录："+dir+"不存在");  
			}  
			if (!dir.isDirectory()) {  
				throw new IllegalArgumentException(dir+"不是目录");  
			}  
			//dir.list()或dir.listFiles()用于遍历子目录  
			String[] filenames=dir.list();  
			for (String str : filenames) {  
				System.out.println(str);  
				//此结果输出的是指定文件下的子目录名或文件名，但不输出子目录下的内容
			}  
			System.out.println("-----------------------");  

			/* 
			 * 如果要遍历子目录下的内容（子目录的子目录），就需要构造成File对象做递归操作 
			 * File提供了直接返回File对象的API 
			 *下面代码能够实现对此文件目录下的子目录实现详细查询 
			 */  
			File[] files=dir.listFiles(); //返回的是直接子目录的抽象  
			//判断子目录下是否还有子目录  
			if (files!=null&&files.length>0) {  
				for (File file : files) {  
					if (file.isDirectory()) {  
						//递归操作  
						listDirectory(file);
					}else {  
						System.out.println(file);
					}  
				}  
			}  
		}

}
