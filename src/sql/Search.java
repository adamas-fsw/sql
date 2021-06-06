package sql;
import  java.sql.*;
public class Search {

    static Connection con; // 声明Connection对象
    static Statement sql; // 声明Statement对象
    static ResultSet res; // 声明ResultSet对象

    public static void main() { // 主方法
        try {
            sql = con.createStatement(); // 实例化Statement对象
            // 执行SQL语句，返回结果集
            res = sql.executeQuery("select * from websites");
            while (res.next()) { // 如果当前语句不是最后一条则进入循环
                String id = res.getString("id"); // 获取列名是"id"的字段值
                // 获取列名是"name"的字段值
                String name = res.getString("name");
                // 获取列名是"sex"的字段值
                String sex = res.getString("url");
                // 获取列名是"birthday"的字段值
                String birthday = res.getString("alexa");
                String country = res.getString("country");
                System.out.print("编号：" + id); // 将列值输出
                System.out.print(" 姓名:" + name);
                System.out.print(" 网址:" + sex);
                System.out.println(" 数量：" + birthday);
                System.out.println(" 国家：" + country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
