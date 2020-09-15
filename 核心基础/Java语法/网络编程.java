package Java语法;/* 2020/9/15 23:55 */

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
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
            //2. 获取输出流，用于输出数据
            os = socket.getOutputStream();
            //3. 数据的写操作
            os.write("你好，我是客户mk".getBytes());//
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