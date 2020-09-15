package Java语法;/* 2020/9/15 23:55 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class 网络编程 {//

    @Test
    public void testTCP() {

    }
}


class Client {
    //客户端发送数据给服务端
    public void client() {
        InetAddress inet;
        Socket socket = null;
        OutputStream os = null;
        try {
            //1. 创建Socket 对象，指明服务器的IP 和端口号
            inet = InetAddress.getByName("192.168.14.100");
            socket = new Socket(inet, 8899);
            //2. 获取输出流
            os = socket.getOutputStream();//
            //3. 数据的写操作
            os.write("你好，我是客户mk".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 资源的关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Server {
    //服务端从客户端接收数据
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1. 创建服务端的ServerSocket 指明自己的端口号
            ss = new ServerSocket(8899);
            //2. 接收来自客户端的Socket
            socket = ss.accept();
            //3. 获取输入流
            is = socket.getInputStream();//
            //4. 读取输入流中的数据
            baos = new ByteArrayOutputStream();//
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);//
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5. 关闭资源
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}