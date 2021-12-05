package pramod.news.News;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.stereotype.Service;

@JsonIgnoreProperties(ignoreUnknown = true)
@Service
public class News implements NewsManager {

    private String status;
    private int totalResults;
    private List<Article> articles;

    public News() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getNews() {
        return "News [articles=" + articles + ", status=" + status + ", totalResults=" + totalResults + "]";
    }

}