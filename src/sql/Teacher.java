package sql;

import java.sql.*;
import java.util.*;
public class Teacher {
    static Statement sql;

    public static void main(String[] args) {
        Conn c = new Conn(); // 创建本类对象
        Connection con = c.getConnection(); // 调用连接数据库的方法
        try {
            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // 实例化Statement对象
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        TeacherInfo x = new TeacherInfo(sql);
        TeacherSearch y = new TeacherSearch(sql);
        TeacherLook z = new TeacherLook(sql);
        Scanner in = new Scanner(System.in);
        int op;
        String sno;
        String choice;
        do {
            System.out.println("1.个人信息完善");
            System.out.println("2.学生问卷查询");
            System.out.println("3.学生问题查看");
            System.out.println("0.退出");
            op = in.nextInt();
            if (op == 1) {
                x.update();
            } else if (op == 2) {
                do {
                    System.out.println("请输入你要查询的学生学号：");
                    sno = in.next();
                    y.search(sno);
                    System.out.println("是否继续查询？Y/N");
                    choice = in.next();
                }while(choice.equals("Y")||choice.equals("y"));
            } else if (op == 3) {
                z.search();
            }
            else if(op == 0){}
            else {
                System.out.println("输入错误，请重新输入！");
            }
        }while (op!=0);
    }
}
