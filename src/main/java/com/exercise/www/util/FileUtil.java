package com.exercise.www.util;

import java.io.File;

public class FileUtil {
	public static String rename(String path, String oldName) {
		
		int count = 0;
		
		String tmpName = oldName;
		
		File file = new File(path, oldName);
		
		while(file.exists()) {
			count++;
			int len = tmpName.lastIndexOf(".");
			String tmp1=tmpName.substring(0, len);
			oldName = tmp1 + "_" + count + tmpName.substring(len);
			 
			file = new File(path, oldName);
		}
		
		return oldName;
	}
}
