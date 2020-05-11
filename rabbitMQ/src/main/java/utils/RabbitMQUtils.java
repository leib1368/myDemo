package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Properties;

/**
 * @Author:Leib
 * @Date 2020/5/4 13:28
 */
public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory;
    private static Properties properties;
    static{
        //重量级资源  类加载执行之执行一次
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        // "/" "guest" "guest"
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

    }

    //定义提供连接对象的方法
    public static Connection getConnection() {
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭通道和关闭连接工具方法
    public static void closeConnectionAndChanel(Channel channel, Connection conn) {
        try {
            if(channel!=null) channel.close();
            if(conn!=null)   conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        //System.out.println("RabbitMQUtils.getConnection() = " + RabbitMQUtils.getConnection());
    }
}
