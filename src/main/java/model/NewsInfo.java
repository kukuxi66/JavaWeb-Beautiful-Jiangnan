package model;

public class NewsInfo {
    String news;
    String date;
    String content;
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public NewsInfo() {
    }

    public NewsInfo(String news, String date, String content, String userName) {
        this.news = news;
        this.date = date;
        this.content = content;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "news='" + news + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
