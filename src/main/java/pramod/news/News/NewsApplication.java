package pramod.news.News;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NewsApplication {

	private static final Logger log = LoggerFactory.getLogger(NewsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {

			AbstractFactory obj = FactoryCreator.getFactoryCreator().getFactory();
			NewsManager news = obj.getNewsManager();

			news = restTemplate.getForObject(
					"https://newsapi.org/v2/top-headlines?country=us&apiKey=374df263f8fc4f3fa573ab276f1a1226",
					News.class);

			log.info(news.getNews());
		};
	}

}
