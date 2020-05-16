package leib.demo;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Author:Leib
 * @Date 2020/5/16 11:25
 */
public class Test {
    public static void main(String[] args) {
        //1 new 对象
        Jedis jedis = new Jedis("127.0.0.1",6379);

        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","leib");

        String result = jsonObject.toJSONString();

        jedis.watch(result);
        //开启事务
        Transaction multi = jedis.multi();


        try{
            multi.set("user1",result);
            multi.set("user2",result);

            //执行事务
            multi.exec();

        } catch (Exception e) {
            //取消事务
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            //关闭连接
            jedis.close();
        }
    }
}
