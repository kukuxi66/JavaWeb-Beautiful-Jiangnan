package model;

public class news {
    String news;
    String date;

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

    public news(String news, String date) {
        this.news = news;
        this.date = date;
    }

    public news() {
    }

    @Override
    public String toString() {
        return "news{" +
                "news='" + news + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
