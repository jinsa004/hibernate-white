package site.metacoding.white.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 db에 맞는 전략을 맞춤. ex)마리아디비는 시퀀스를 안쓰기때문에 이걸 설정해줘야 오토임플리먼트로 함
    private Long id;
    private String title;
    @Column(length = 1000)
    private String content;
    // FK가 만들어짐. user_id
    @ManyToOne(fetch = FetchType.EAGER) // 객체끼리 관계를 결정해주는 어노테이션. Many = N , One = 1 => N대N, N대1, 1대1의 관계
    // @JoinColumn() 만들어지는 user_id를 임의의 값으로 지정해줄 수 있음 ex)userId
    private User user;
}
