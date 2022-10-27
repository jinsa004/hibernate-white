package site.metacoding.white.domain;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

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
        em.createQuery("delete from Comment c where c.id = :id")// createQuery를 사용해서 쿼리문을 짤땐 entity 파일명에 맞춰서
                .setParameter("id", id)
                .executeUpdate();
    }

    public Optional<Comment> findById(Long id) {
        try {
            Optional<Comment> commentOP = Optional
                    .of(em.createQuery("select c from Comment c where e.id=:id", Comment.class)
                            .setParameter("id", id)
                            .getSingleResult());
            return commentOP;
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
