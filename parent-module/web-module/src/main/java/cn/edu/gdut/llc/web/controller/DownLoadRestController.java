package cn.edu.gdut.llc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


import javax.activation.MimetypesFileTypeMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wu_lei
 */
@Controller
public class DownLoadRestController {


    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;


    /**
     * @param url 根据给出的url进行下载
     */
    @RequestMapping("/download")
    public void download(@RequestParam("url") String url) {
        File file = new File(url);
        System.out.println(url);
        //获取文件名的url编码
        String filename = fileNameEncoding(file.getName());

        System.out.println(filename);

        //设置文件在下载框当中显示的名称
        String contentDisposition = "attachment;filename=" + filename;
        String contentType = new MimetypesFileTypeMap().getContentType(file);
        System.out.println("contentType:" + contentType);

        //设置输出头
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Disposition", contentDisposition);
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {

            //获取文件的输入流
            input = new FileInputStream(file);
            //获取输出流
            output = response.getOutputStream();

            IOUtils.copy(input, output);

            //关流
            if (input != null)
                input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * @param filename
     * @return 判断浏览器的类型转换编码
     */
    @SuppressWarnings("restriction")
    private String fileNameEncoding(String filename) {
        String userAgent = request.getHeader("User-Agent");
        String framename = null;
        if (userAgent.contains("Firefox")) {
            framename = "=?utf-8?B?" + Base64.encode(filename.getBytes()) + "?=";
        } else {
            try {
                framename = URLEncoder.encode(filename, "utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return framename;
    }


}
