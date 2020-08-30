package _11集合;/* 2020/8/28 18:23 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*; //import java.io.*;

public class Properties配置文件 {
    // TODO: 2020/8/28 项目编码必须是utf-8 否者.properties 文件读取乱码
    @Test
    public void test() {
        InputStreamReader isr = null;
        try {
            String file = ".\\_11集合\\jdbc.properties";

            //Properties 配置文件，中文编码问题
            new Properties().load(new InputStreamReader(new FileInputStream(file), "utf-8"));//

            isr = new InputStreamReader(new FileInputStream(file), "utf-8");
            Properties pros = new Properties();
            pros.load(isr);//load

            String name = pros.getProperty("name");//getProperty
            String password = pros.getProperty("password");//getProperty
            String note = pros.getProperty("note");//getProperty
            //name = new String(name.getBytes("ISO8859-1"), "utf-8");

            System.out.println(pros.toString());//toString
            //System.out.println("name = " + name);
            //System.out.println("password = " + password);
            //System.out.println("note = " + note);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr == null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
