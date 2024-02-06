package top.linco.snake;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;


public class Main extends Application {

    public User user = null;
    public int textID=-1;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(0,20,20,20));
        mainPane.setStyle("-fx-background-color: #39374a;");
        Scene mainScene = new Scene(mainPane,500,400);

        primaryStage.setScene(mainScene);

        Image diaryImg = new Image(getClass().getResource("/diary.png").toExternalForm());
        ImageView diaryImgView = new ImageView(diaryImg);
        diaryImgView.setFitHeight(200);
        diaryImgView.setFitWidth(200);

        HBox choice = new HBox(30);
        choice.setAlignment(Pos.TOP_CENTER);
        choice.setPadding(new Insets(0,0,60,0));
        Button login = new Button("登录");

        Button sign = new Button("注册");

        choice.getChildren().addAll(login,sign);

        login.setPadding(new Insets(10));
        login.setMinWidth(100);
        login.setStyle(""
                + "-fx-background-color: derive(#39374a, 60%), #39374a;"
                + "-fx-background-insets: 0, 1px;"
                + "-fx-text-fill:#ffffff;"
                + "-fx-font-size:14px;"
                + "-fx-background-radius: 30px, 80px;");

        sign.setPadding(new Insets(10));
        sign.setMinWidth(100);
        sign.setStyle(""
                + "-fx-background-color: derive(#39374a, 60%), #39374a;"
                + "-fx-background-insets: 0, 1px;"
                + "-fx-text-fill:#ffffff;"
                + "-fx-font-size:14px;"
                + "-fx-background-radius: 30px, 80px;");

        mainPane.setCenter(diaryImgView);
        mainPane.setBottom(choice);


        Group loginpane = new Group();

        TextField text = new TextField();
        //        设置提示
        Tooltip tip = new Tooltip("输入账号");
        text.setTooltip(tip);
        text.setPromptText("请输入您的账号");
        text.setFocusTraversable(false);
        text.setLayoutX(140);
        text.setLayoutY(100);

        PasswordField pt = new PasswordField();
        pt.setLayoutX(140);
        pt.setLayoutY(160);

//       设置提示
        Tooltip tip2 = new Tooltip("输入密码");
        pt.setTooltip(tip2);

//      设置文本框背景提示，需要去除焦点，并去除文本框文字
        pt.setPromptText("请输入您的密码");
        pt.setFocusTraversable(false);
//        System.out.println("dedrerd");
//        System.out.println(getClass().getResource("/user.png").toExternalForm());

        Image userImg = new Image(getClass().getResource("/user.png").toExternalForm());
        ImageView userImgView = new ImageView(userImg);
        userImgView.setFitWidth(20);
        userImgView.setFitHeight(20);
        Label label1 = new Label("账号");
        label1.setLayoutX(80);
        label1.setLayoutY(100);
        label1.setGraphic(userImgView);

        Image userImg2 = new Image(getClass().getResource("/password.png").toExternalForm());
        ImageView userImgView2 = new ImageView(userImg2);
        userImgView2.setFitWidth(20);
        userImgView2.setFitHeight(20);
        Label label2 = new Label("密码");
        label2.setLayoutX(80);
        label2.setLayoutY(160);
        label2.setGraphic(userImgView2);

        Button loginBtn = new Button("登录");
        loginBtn.setLayoutX(130);
        loginBtn.setLayoutY(250);

        loginBtn.setPadding(new Insets(10));
        loginBtn.setMinWidth(140);
        loginBtn.setStyle(""
                + "-fx-background-color: derive(#39374a, 60%), #39374a;"
                + "-fx-background-insets: 0, 1px;"
                + "-fx-text-fill:#ffffff;"
                + "-fx-font-size:14px;"
                + "-fx-background-radius: 30px, 80px;");

        loginpane.getChildren().addAll(text,pt,label1,label2,loginBtn);

        Pane mainLoginPane = new Pane(loginpane);
        mainLoginPane.setStyle("-fx-background-color: #fce3cc;");

        Scene loginScene = new Scene(mainLoginPane,400,400);

        //scene切换
        login.setOnAction(e->{
            primaryStage.setScene(loginScene);

        });
        Group signpane = new Group();
        TextField username = new TextField();
        //        设置提示
        Tooltip usernametip = new Tooltip("输入用户名");
        username.setTooltip(usernametip);
        username.setPromptText("请输入您的账号");
        username.setFocusTraversable(false);
        username.setLayoutX(140);
        username.setLayoutY(100);

        PasswordField password = new PasswordField();
        password.setLayoutX(140);
        password.setLayoutY(140);

//       设置提示
        Tooltip passwordtip = new Tooltip("输入密码");
        password.setTooltip(passwordtip);

//      设置文本框背景提示，需要去除焦点，并去除文本框文字
        password.setPromptText("请输入您的密码");
        password.setFocusTraversable(false);

        TextField emailInput = new TextField();
        //        设置提示
        Tooltip emailtip = new Tooltip("输入邮箱");
        emailInput.setTooltip(emailtip);
        emailInput.setPromptText("请输入您的邮箱");
        emailInput.setFocusTraversable(false);
        emailInput.setLayoutX(140);
        emailInput.setLayoutY(180);


        Image userImgSign = new Image(getClass().getResource("/user.png").toExternalForm());
        ImageView userImgViewSign = new ImageView(userImgSign);
        userImgViewSign.setFitWidth(20);
        userImgViewSign.setFitHeight(20);
        Label label3 = new Label("账号");
        label3.setLayoutX(80);
        label3.setLayoutY(100);
        label3.setGraphic(userImgViewSign);

        Image userImg3 = new Image(getClass().getResource("/password.png").toExternalForm());
        ImageView userImgView3 = new ImageView(userImg3);
        userImgView3.setFitWidth(20);
        userImgView3.setFitHeight(20);
        Label label4 = new Label("密码");
        label4.setLayoutX(80);
        label4.setLayoutY(140);
        label4.setGraphic(userImgView3);

        Image userImg4 = new Image(getClass().getResource("/email.png").toExternalForm());
        ImageView userImgView4 = new ImageView(userImg4);
        userImgView4.setFitWidth(20);
        userImgView4.setFitHeight(20);
        Label label5 = new Label("邮箱");
        label5.setLayoutX(80);
        label5.setLayoutY(180);
        label5.setGraphic(userImgView4);


        Button signBtn = new Button("注册");
        signBtn.setLayoutX(130);
        signBtn.setLayoutY(260);

        signBtn.setPadding(new Insets(10));
        signBtn.setMinWidth(140);
        signBtn.setStyle(""
                + "-fx-background-color: derive(#39374a, 60%), #39374a;"
                + "-fx-background-insets: 0, 1px;"
                + "-fx-text-fill:#ffffff;"
                + "-fx-font-size:14px;"
                + "-fx-background-radius: 30px, 80px;");

        signpane.getChildren().addAll(username,password,label3,label4,signBtn,label5,emailInput);

        signBtn.setOnAction(e->{
            String loginUserName = username.getText();
            String loginPassword = password.getText();
            String loginEmail = emailInput.getText();
            this.loginUser(loginUserName,loginPassword,loginEmail);
            primaryStage.setScene(mainScene);
        });

        Pane mainSignPane = new Pane(signpane);
        mainSignPane.setStyle("-fx-background-color: #fce3cc;");

        Scene signScene = new Scene(mainSignPane,400,400);

        sign.setOnAction(e->{
            primaryStage.setScene(signScene);
        });


        BorderPane borderPane = new BorderPane();

        //顶部
        FlowPane topPane = new FlowPane();
        Label l1 = new Label("欢迎使用！");
        Button b1 = new Button("退出");
        topPane.setAlignment(Pos.CENTER_LEFT);
        topPane.getChildren().addAll(l1, b1);
        topPane.setHgap(10); //这里是为了调整控件左右的间隙
        topPane.setPadding(new Insets(10)); //这里是为了调整布局上下的间隙 防止太过紧密
        borderPane.setTop(topPane);

        b1.setOnAction(e->{
            this.user = null;
            this.textID = -1;
            primaryStage.setScene(mainScene);
        });

        //中部
        TableView<Diary> tableView = new TableView();
        borderPane.setCenter(tableView);
        TableColumn c1 = new TableColumn("统一ID");
        TableColumn c2 = new TableColumn("标题");
        TableColumn c3 = new TableColumn("更新日期");
//        TableColumn c4 = new TableColumn("学生性别");
        tableView.getColumns().addAll(c1, c2, c3);
//c1: 学生编号 -> 对应 Student 对象的id属性
        c1.setCellValueFactory(new PropertyValueFactory("id"));
//c1: 学生名字 -> 对应 Student 对象的username属性
        c2.setCellValueFactory(new PropertyValueFactory("title"));
//c1: 学生密码 -> 对应 Student 对象的password属性
        c3.setCellValueFactory(new PropertyValueFactory("createDate"));

        //底部
        FlowPane bottomPane = new FlowPane();
        Button g1 = new Button("增加");
        Button g2 = new Button("删除");
        Button g3 = new Button("修改");
        Button g4 = new Button("浏览");
        bottomPane.getChildren().addAll(g1, g2, g3, g4);
        bottomPane.setHgap(10);
        bottomPane.setPadding(new Insets(10));
        borderPane.setBottom(bottomPane);


        BorderPane writerPane = new BorderPane();

        HBox hBox = new HBox();
        Label labelTitle = new Label("请输入标题：");
        TextField inputTitle = new TextField();
        hBox.getChildren().addAll(labelTitle,inputTitle);
//        hBox.setAlignment(Pos.CENTER);

        writerPane.setTop(hBox);

        HTMLEditor htmlEditor = new HTMLEditor();

        writerPane.setCenter(htmlEditor);
        HBox saveBtns =  new HBox();
        Button saveBtn = new Button("保存");
        saveBtns.getChildren().addAll(saveBtn);
        writerPane.setBottom(saveBtns);

        Scene writerScene2 = new Scene(writerPane);
        Scene writerScene = new Scene(borderPane);
        g1.setOnAction(e->{
            inputTitle.clear();
            htmlEditor.setHtmlText("");
            primaryStage.setScene(writerScene2);
        });
        g2.setOnAction(e->{
            int rownum = tableView.getSelectionModel().getSelectedCells().get(0).getRow();
            this.user.deleteTetx(this.user.arrayList.get(rownum).id);
            tableView.setItems(FXCollections.observableList(this.user.arrayList));
        });
        g3.setOnAction(e->{
            int rownum = tableView.getSelectionModel().getSelectedCells().get(0).getRow();
            inputTitle.setText(this.user.arrayList.get(rownum).title);
            htmlEditor.setHtmlText(this.user.arrayList.get(rownum).content);
            this.textID = this.user.arrayList.get(rownum).id;
            primaryStage.setScene(writerScene2);
        });
        g4.setOnAction(e->{
            int rownum = tableView.getSelectionModel().getSelectedCells().get(0).getRow();
            inputTitle.setText(this.user.arrayList.get(rownum).title);
            htmlEditor.setHtmlText(this.user.arrayList.get(rownum).content);
            this.textID = this.user.arrayList.get(rownum).id;
            primaryStage.setScene(writerScene2);
        });
        saveBtn.setOnAction(e->{
            String saveTitle = inputTitle.getText();
            String saveText = htmlEditor.getHtmlText();
            if(this.textID ==-1){
                this.user.insertText(saveTitle,saveText);
            }else{

                this.user.updateText(this.textID,saveTitle,saveText);
                this.textID =-1;
            }
            tableView.setItems(FXCollections.observableList(this.user.arrayList));
            primaryStage.setScene(writerScene);
        });

        loginBtn.setOnAction(e->{
            String loginUserName = text.getText();
            String loginPassword = pt.getText();
            int loginstate = checkPassWord(loginUserName,loginPassword);
            if(loginstate>0){
                user = new User(loginstate,loginUserName);
                l1.setText("欢迎使用，"+loginUserName+"!");
                tableView.setItems(FXCollections.observableList(this.user.arrayList));
                primaryStage.setScene(writerScene);

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("登录错误");
                alert.setHeaderText("用户名或密码错误");
                alert.setContentText("请检查您的用户名或者密码，如您未注册，请先进行注册");
                alert.showAndWait();
            }

        });

        primaryStage.setTitle("CloudDiary");
        primaryStage.getIcons().add(new Image(getClass().getResource("/diary.png").toExternalForm()));
        primaryStage.show();

    }

    public void loginUser(String name,String pw,String email){
        String url = "jdbc:mysql://localhost:3306/diary";
        String username = "root";
        String password = "123456";

        try {
            // 连接到MySQL数据库
            Connection connection = DriverManager.getConnection(url, username, password);

            // 编写SQL INSERT语句
            String sql = "insert into user (username,password,email)" +
                    "values (?,?,?)";

            // 创建PreparedStatement对象，并设置参数值
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, pw);
            statement.setString(3, email);

            // 执行INSERT语句
            statement.executeUpdate();

            // 关闭连接和资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int checkPassWord(String name,String pw){
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
            String sql = "select * from user where username ="+"'"+name+"'";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String pwt = resultSet.getString("password");
                if(Objects.equals(pwt, pw)){
                    return id;
                }else {
                    return -1;
                }
            }else {
                return -1;
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

    return 0;
    }
}