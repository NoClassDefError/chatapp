package sample.comm;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("正在等待连接");
            final Socket s = serverSocket.accept();
            System.out.println("已连接");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
