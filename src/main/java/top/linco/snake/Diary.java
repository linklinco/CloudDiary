package top.linco.snake;

import java.util.Date;

public class Diary {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;
    public String title;
    public Date createDate;
    public String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Diary(int dID,String title, String content, Date createDate){
        this.id = dID;
        this.title = title;
        this.createDate = createDate;
        this.content =  content;
    }

}
