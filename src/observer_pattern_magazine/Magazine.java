package observer_pattern_magazine;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class Magazine {
    private LocalDateTime date;
    private String title;
    private List<Article> articles;
}
