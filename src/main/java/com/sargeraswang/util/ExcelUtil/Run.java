package com.sargeraswang.util.ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

/**
 * @Auther: kourengang
 * @Date: 2018/8/1 17:26
 * @Description: excel->java collection.
 * 文件必须有表头，Excel文件
 */
public class Run {
    public static void main(String[] args) {
        String fileName = "修正剧集缺失数据2.xlsx";
        File f=new File("src/test/resources/"+fileName);
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ExcelLogs logs =new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);
        for(Map m : importExcel){
            System.out.println(m);
        }
        int mapKeyNum = importExcel.iterator().next().keySet().size();
        System.out.println("file name："+fileName+"，rows num："+importExcel.size()+",map keys num: "+mapKeyNum);
    }
}
