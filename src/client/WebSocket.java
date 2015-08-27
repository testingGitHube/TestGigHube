package client;

import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;


/**
 * @version 2.2
 * @author amirsam bahador
 **/
public class WebSocket {

    /**
     *
     * @throws Exception
     * @return String
     */
    public static void main(String[] args)throws Exception{
        String content = "";
        int spider;
        URL hp = new URL("http://localhost:9998/javad/akbar");
        URLConnection hpcon = hp.openConnection();
            InputStream input = hpcon.getInputStream();

            while (((spider = input.read()) != -1)) {
                content = content + (char) spider;
            }

            input.close();
        System.out.println(content);
}
}
