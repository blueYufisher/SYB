package cn.edu.gdut.llc.share.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class UpLoadUtils {


    @AutoLogger
    private static Logger logger;
    /**
     * @param bytes
     *            需要获取MD5的字节数组
     * @return String 计算后得到的MD5的结果 获取MD5
     * @throws NoSuchAlgorithmException
     */
    public static String getMd5(byte[] bytes) throws NoSuchAlgorithmException  {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] md5Result = messageDigest.digest(bytes);
        String result = bytesToString(md5Result);
        return result.replaceAll("-", "");
    }
    /**
     * @param bytes
     * @return String 将字节数组转换成字符串
     */
    public static String bytesToString(byte[] bytes) {
        String str = "";
        for (byte b : bytes)
            str += b;
        return str;
    }

    /**
     * 根据传入的url删除相应的文件
     * @param id
     * @throws Exception
     */
    public static  void deleteFile(String url) {
//        logger.debug("deleteFile：+"+url);
        File f = new File(url);
        System.out.println(url);
        boolean success = f.delete();
        if (success == true)
            System.out.println("删除成功");
        else {
            System.out.println("删除失败");
            throw new RuntimeException("文件删除失败！");
        }
    }


    /**
     * 将文件保存到指定位置
     * @param adress
     * @param file
     * @throws IOException
     */
    public static void storeFile(String adress, MultipartFile file) throws IOException {
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(adress));
        stream.write(file.getBytes());
        stream.close();
    }
}
