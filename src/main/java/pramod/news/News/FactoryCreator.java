package pramod.news.News;

public class FactoryCreator {

    private static FactoryCreator objFactory;

    private FactoryCreator() {

    }

    public static FactoryCreator getFactoryCreator() {
        if (objFactory == null) {
            objFactory = new FactoryCreator();
        }

        return objFactory;
    }

    public AbstractFactory getFactory() {
        return new NewsFactory();
    }
}
