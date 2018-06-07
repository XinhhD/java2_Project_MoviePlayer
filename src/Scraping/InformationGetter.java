package Scraping;

import javafx.scene.text.Text;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.PropertyResourceBundle;


public class InformationGetter {
    public static void main(String[] args) {
        try {
            String name = "mivieName"+".jpg";
            imageWritter("https://upload.wikimedia.org/wikipedia/en/thumb/a/a5/Alexander_Nevsky_Poster.jpg/220px-Alexander_Nevsky_Poster.jpg"
            ,"C:\\Users\\Administrator\\Desktop\\searchformdefault\\",name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void imageWritter(String src, String dst,String name) throws IOException {
        URL imaUrl12 =new URL(
                src);
        URLConnection con = imaUrl12.openConnection();
        con.getInputStream();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst+name));
        BufferedInputStream in =  new BufferedInputStream(con.getInputStream());
        byte[] arr = new byte[in.available()];
        int read;
        while ((read = in.read(arr, 0, arr.length))!=-1) {
            out.write(arr,0,read);
        }
        in.close();
        in.close();
        out.flush();
        out.close();

    }

    public static PropertyResourceBundle PropertyReader(String PropertySourceFolder,String feature,String language) {
        PropertyResourceBundle a= null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(PropertySourceFolder+feature+"_"+language+".properties"),"UTF-8"))) {
            a = new PropertyResourceBundle(in);
        }  catch (IOException e) {
            System.err.println(" property file dose not exist : language : "+language);
            System.exit(1);
        }
        return a ;
    }

    public static InputStream openImageStream(String filePath) {
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.err.println("can not open image input stream: file can not find");
            e.printStackTrace();
        }
        return  in;
    }

}
