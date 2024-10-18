package practice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Play {
    public static void main(String[] args) throws IOException {

        String webURL = "https://finance.yahoo.com/quote/RELIANCE.NS/";

        InputStream i = new ByteArrayInputStream(webURL.getBytes());//Creating the input stream
        InputStreamReader isr = new InputStreamReader(i);
        char[] charArr = new char[512];
        int read = isr.read(charArr);
        System.out.println(isr);


    }
}
