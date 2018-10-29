package URLDemo;

import java.net.URL;


public class URLDemoDebuggerPrepped {

    public static void main(String[] args) throws Exception {
        
        int i = 4;
        int i2;

        URL aURL = new URL("http://example.com:80/docs/books/tutorial"
                           + "/index.html?name=networking#DOWNLOADING");

        System.out.println("protocol = " + aURL.getProtocol());
        i = 5;
        if (i == 5){
            System.out.println("Hepp");
        }
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        i = 6;
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        i = 7;
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());
    }
}

