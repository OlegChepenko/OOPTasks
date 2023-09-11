package observer_pattern_magazine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private int magNumber = 0;
    private final int targetCountArticles = 4;
    private List<Article> articles = new ArrayList<>();
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        if (!subscribers.contains(subscriber))
            subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Magazine magazine) {
        for(Subscriber subscriber : subscribers) {
            subscriber.update(magazine, this);
        }
    }

    public void mainLogic() {
        if (articles.size() == targetCountArticles) {
            magNumber++;
            Magazine magazine = new Magazine(LocalDateTime.now(), "Mag №" + magNumber, articles);
            articles = new ArrayList<>();
            notifySubscribers(magazine);
        }
    }

    public void addArticle(Article article) {
        articles.add(article);
        mainLogic();
    }
}
