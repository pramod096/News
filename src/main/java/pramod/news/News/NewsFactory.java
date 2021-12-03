package pramod.news.News;

public class NewsFactory extends AbstractFactory {

    @Override
    public NewsManager getNewsManager() {
        return new News();
    }
}
