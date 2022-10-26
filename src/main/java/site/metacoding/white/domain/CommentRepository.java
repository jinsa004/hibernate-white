package site.metacoding.white.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository // IoC 등록
public class CommentRepository {

    private final EntityManager em;

    public Comment save(Comment comment) {
        em.persist(comment); // insert 쿼리가 자동으로 만들어짐, insert밖에 못함
        return comment;
    }

    public void deleteById(Long id) {
        // JPQL 문법
        em.createQuery("delete from Board b where b.id = :id")// createQuery를 사용해서 쿼리문을 짤땐 entity 파일명에 맞춰서
                .setParameter("id", id)
                .executeUpdate();
    }

}
