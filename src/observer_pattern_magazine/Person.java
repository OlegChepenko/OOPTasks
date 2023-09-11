package observer_pattern_magazine;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person implements Subscriber {
    private String name;

    @Override
    public void update(Magazine magazine, Publisher publisher) {
        System.out.println(name + " получил журнал " + magazine.getTitle());
        for(Article article : magazine.getArticles()) {
            System.out.println(name + " читает статью " + article.getTitle());
        }
    }

}
