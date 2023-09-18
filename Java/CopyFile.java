package Java;
import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException{
        int i;
        FileInputStream fin;
        FileOutputStream fout;
        fin = new FileInputStream("/home/hervey/Code/Code/Java/myfile");
        fout = new FileOutputStream("/home/hervey/Code/Code/Java/yourfile");
        do{
            i = fin.read();
            if(i != -1)
                fout.write(i);
        }while(i != -1);
        fin.close();
        fout.close();
        System.out.println("myfile内容已经被复制到yourfile文件中");
    }    
}
