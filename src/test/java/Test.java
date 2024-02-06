import java.sql.*;
public class Test {
    public static void main(String[] args) {
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
            String sql = "SELECT * FROM mydiarys";
            resultSet = statement.executeQuery(sql);

            // 5. 处理查询结果
            while (resultSet.next()) {
                int id = resultSet.getInt("num");
                String name = resultSet.getString("text");
                System.out.println("id: " + id + ", name: " + name);
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

}