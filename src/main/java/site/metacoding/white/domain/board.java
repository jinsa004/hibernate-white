package site.metacoding.white.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String author;
}
