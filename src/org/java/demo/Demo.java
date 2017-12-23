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
			 * exists()���������ж��ļ���Ŀ¼�Ƿ���� 
			 * ��Ŀ¼�����ڣ�����ڵ�����Ŀ¼ʱ�׳��쳣 
			 */  
			if (!dir.exists()) {  
				throw new IllegalArgumentException("Ŀ¼��"+dir+"������");  
			}  
			if (!dir.isDirectory()) {  
				throw new IllegalArgumentException(dir+"����Ŀ¼");  
			}  
			//dir.list()��dir.listFiles()���ڱ�����Ŀ¼  
			String[] filenames=dir.list();  
			for (String str : filenames) {  
				System.out.println(str);  
				//�˽���������ָ���ļ��µ���Ŀ¼�����ļ��������������Ŀ¼�µ�����
			}  
			System.out.println("-----------------------");  

			/* 
			 * ���Ҫ������Ŀ¼�µ����ݣ���Ŀ¼����Ŀ¼��������Ҫ�����File�������ݹ���� 
			 * File�ṩ��ֱ�ӷ���File�����API 
			 *��������ܹ�ʵ�ֶԴ��ļ�Ŀ¼�µ���Ŀ¼ʵ����ϸ��ѯ 
			 */  
			File[] files=dir.listFiles(); //���ص���ֱ����Ŀ¼�ĳ���  
			//�ж���Ŀ¼���Ƿ�����Ŀ¼  
			if (files!=null&&files.length>0) {  
				for (File file : files) {  
					if (file.isDirectory()) {  
						//�ݹ����  
						listDirectory(file);
					}else {  
						System.out.println(file);
					}  
				}  
			}  
		}

}
