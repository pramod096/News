package pramod.news.News;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    // Handle GET Request
    @GetMapping(value = "/")
    public String getArticles(Model model) {

        List<Article> news = newsService.getAllNews();

        model.addAttribute("news", news);

        return "index";
    }

    // Handle Post Request
    @PostMapping(value = "/search")
    public String search(@RequestParam("search") String search, Model model) {

        List<Article> news = newsService.getSearchNews(search);

        System.out.println(search);

        model.addAttribute("news", news);

        return "index";
    }

}
