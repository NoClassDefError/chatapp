package sample.comm;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        final Socket s = new Socket("localhost", 1234);
        InputStream inputStream = s.getInputStream();
        Thread sendThread = new Thread(){
            public void run(){
                try {
                    OutputStream output = s.getOutputStream();
                    IOUtils.copy(System.in,output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        sendThread.start();
        IOUtils.copy(inputStream,System.out);

    }

}
