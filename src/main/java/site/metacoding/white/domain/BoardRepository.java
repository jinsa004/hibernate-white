package site.metacoding.white.domain;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager em;

    public Board save(Board board) {
        em.persist(board); // insert 쿼리가 자동으로 만들어짐, insert밖에 못함
        return board;
    }

    public Board findById(Long id) {
        // JPQL 문법
        Board boardPS = em.createQuery("select b from Board b where b.id=:id", Board.class)// createQuery를 사용해서 쿼리문을 짤땐
                                                                                           // entity 파일명에 맞춰서
                .setParameter("id", id)
                .getSingleResult();
        return boardPS;
    }

    public void deleteById(Long id) {
        // JPQL 문법
        em.createQuery("delete from Board b where b.id = :id")// createQuery를 사용해서 쿼리문을 짤땐 entity 파일명에 맞춰서
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Board> findAll() {
        // JPQL 문법
        List<Board> boardList = em.createQuery("select b from Board b", Board.class)
                .getResultList();
        return boardList;
    }

}
