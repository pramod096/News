package pramod.news.News;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    private List<Article> allNews = new ArrayList<>();
    private List<Article> searchNews = new ArrayList<>();

    // Method to get All the news on Page Load
    public List<Article> getAllNews() {
        return allNews;
    }

    // Method to get news from user input
    public List<Article> getSearchNews(String search) {

        AbstractFactory obj = FactoryCreator.getFactoryCreator().getFactory();
        NewsManager news = obj.getNewsManager();

        String URL = "https://newsapi.org/v2/everything?q=" + search +
                "&apiKey=cb025707f849476da45e6e7ba76c3156";

        // Object to Consume Restful Webservices
        RestTemplate restTemplate = new RestTemplate();
        news = restTemplate.getForObject(
                URL,
                News.class);

        this.searchNews = news.getArticles();
        return searchNews;
    }

    // Constructor for NewsService
    public NewsService() {
        AbstractFactory obj = FactoryCreator.getFactoryCreator().getFactory();
        NewsManager news = obj.getNewsManager();

        // Object to Consume Restful Webservices
        RestTemplate restTemplate = new RestTemplate();

        news = restTemplate.getForObject(
                "https://newsapi.org/v2/everything?q=tesla&apiKey=cb025707f849476da45e6e7ba76c3156",
                News.class);

        this.allNews = news.getArticles();
    }

}
