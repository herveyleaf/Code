package Java;

import java.io.FileInputStream;
import java.io.IOException;

class ShowFile{
    public static void main(String[] args) throws IOException{
        int i;
        FileInputStream fin;
        fin = new FileInputStream("/home/hervey/Code/Code/Java/myfile"); 
        do{
            i = fin.read();
            if(i != -1)
                System.out.print((char) i);
        }while(i != -1);
        fin.close();
    }
}