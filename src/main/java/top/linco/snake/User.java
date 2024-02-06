package top.linco.snake;

import java.sql.*;
import java.util.ArrayList;

public class User {
    int num = -1;
    String name;
    ArrayList<Diary> arrayList = new ArrayList<>();

    public User(int num,String name){
        this.num = num;
        this.name = name;
        getAllText();
    }
    public void getAllText(){
        arrayList.clear();
        String url = "jdbc:mysql://localhost:3306/diary";
        String username = "root";
        String password = "123456";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. 加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 建立数据库连接
            connection = DriverManager.getConnection(url, username, password);

            // 3. 创建Statement对象，用于执行SQL查询
            statement = connection.createStatement();

            // 4. 执行SQL查询
            String sql = "select * from text where autherID ="+this.num;
            resultSet = statement.executeQuery(sql);

            // 5. 处理查询结果
            while (resultSet.next()) {

                Diary tmp = new Diary(resultSet.getInt("textID"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getDate("createDate"));

                this.arrayList.add(tmp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void insertText(String title,String text){
        String url = "jdbc:mysql://localhost:3306/diary";
        String username = "root";
        String password = "123456";

        try {
            // 连接到MySQL数据库
            Connection connection = DriverManager.getConnection(url, username, password);

            // 编写SQL INSERT语句
            String sql = "insert into text (autherID,title,content)" +
                    "values (?,?,?)";

            // 创建PreparedStatement对象，并设置参数值
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.num);
            statement.setString(2, title);
            statement.setString(3, text);

            // 执行INSERT语句
            statement.executeUpdate();

            // 关闭连接和资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getAllText();

    }
    public void deleteTetx(int id){
        String url = "jdbc:mysql://localhost:3306/diary";
        String username = "root";
        String password = "123456";

        try {
            // 连接到MySQL数据库
            Connection connection = DriverManager.getConnection(url, username, password);

            // 编写SQL DELETE语句
            String sql = "DELETE FROM text WHERE textID = ?";

            // 创建PreparedStatement对象，并设置参数值
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            // 执行DELETE语句
            statement.executeUpdate();

            // 关闭连接和资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getAllText();
    }
    public void updateText(int id,String title,String text ){
        String url = "jdbc:mysql://localhost:3306/diary";
        String username = "root";
        String password = "123456";

        try {
            // 连接到MySQL数据库
            Connection connection = DriverManager.getConnection(url, username, password);

            // 编写SQL UPDATE语句
            String sql = "UPDATE text set title =?,content=? where textID =?";

            // 创建PreparedStatement对象，并设置参数值
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(3, id);
            statement.setString(2, text);
            statement.setString(1, title);

            // 执行UPDATE语句
            statement.executeUpdate();

            // 关闭连接和资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getAllText();
    }
}
