package site.metacoding.white.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    @Builder // 풀생성자를 설정하고 @Builder를 걸어줌
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

}
