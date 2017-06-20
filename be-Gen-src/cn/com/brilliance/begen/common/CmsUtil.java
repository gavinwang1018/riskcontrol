package cn.com.brilliance.begen.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.myfaces.custom.fileupload.UploadedFile;

public class CmsUtil {
	public static final String PATH_UPLOAD = Tools.getEnvionment("upload_path");

	public static void saveUploadedFile(String saveFile,UploadedFile uploadedFile) {
		InputStream in;
		FileOutputStream fos = null;
		try {
			in = new BufferedInputStream(uploadedFile.getInputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		File savePath = new File(PATH_UPLOAD + saveFile.substring(0,saveFile.lastIndexOf("/")));
		savePath.mkdirs();

		File file = new File(PATH_UPLOAD + saveFile);
		try {
			fos = new FileOutputStream(file);
			byte[] buffer = new byte[64 * 1024];
			int count;
			while ((count = in.read(buffer)) > 0)
				fos.write(buffer, 0, count);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				in.close();
				fos.close();
			} catch (IOException e) {
			} finally {
			}
		}
	}
	
	public static void deleteFile(String fileName){
		File file = new File(PATH_UPLOAD + fileName);
		deleteAll(file);
	}
	
	public static void deleteAll(File file){		
		if(file.exists()){
			if(file.isDirectory()){
				boolean result = false;
				if( !(result = file.delete())){
					File subs[] = file.listFiles();
					for (int i = 0; i < subs.length; i++) {
						if(subs[i].isDirectory()){
							deleteAll(subs[i]);
						}
						else{
							result = subs[i].delete();
						}
					}
					result = file.delete();
				}
			}
			else{
				file.delete();
			}
		}
	}	
	
	public static void loadFileToHttpServletResponse(String saveFile,HttpServletResponse response) {
		File file = new File(PATH_UPLOAD + saveFile);
		ServletOutputStream ops = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			response.setContentLength((int) file.length());
			byte[] buffer = new byte[64 * 1024];
			int count;
			ops = response.getOutputStream();
			while ((count = fis.read(buffer)) > 0)
				ops.write(buffer, 0, count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
				ops.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static File loadFile(String saveFile) {
		File file = new File(PATH_UPLOAD + saveFile);
		return file;
	}

	public static String getUploadedFileName(UploadedFile uploadedFile) {
		String uploadedFileName = uploadedFile.getName();
		uploadedFileName = uploadedFileName.substring(uploadedFileName.lastIndexOf("/") + 1);
		uploadedFileName = uploadedFileName.substring(uploadedFileName.lastIndexOf("\\") + 1);
		return uploadedFileName;
	}
}
