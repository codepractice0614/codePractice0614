package little.dms.domain.board.presentation.domain;

import jakarta.persistence.*;
import little.dms.domain.user.domain.User;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter


public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50)")
    private String title;

    @Column(columnDefinition = "varchar(600)")
    private String content;

    @ManyToOne
    private User user;

    @Builder
    public Board(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
