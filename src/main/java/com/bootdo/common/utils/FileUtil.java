package com.bootdo.common.utils;

import com.bootdo.common.config.BootdoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class FileUtil {

	@Autowired
	private BootdoConfig bootdoConfig;

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 修改文件名称为唯一
	 * @param fileName
	 * @return
	 */
	public static String renameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	/**
	 * 上传文件共用方法
	 * @param file
	 * @param uploadPath  原类需要注入 @Autowired
	 * 									    private BootdoConfig bootdoConfig;
	 * 				  并调用此方法获取传参 String uploadPath=bootdoConfig.getUploadPath();
	 * @return
	 */
	public static boolean uploadImg(MultipartFile file,String uploadPath){
		String fileName = file.getOriginalFilename();
		fileName = renameToUUID(fileName);
		try {
			FileUtil.uploadFile(file.getBytes(), uploadPath, fileName);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
