package site.metacoding.white.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository // IoC 등록
public class UserRepository {

    // DI
    private final EntityManager em;

    public void save(User user) {
        // Persistence를 Context에 영속화 시키기 -> 자동 flush (트랜젝션 종료시)
        em.persist(user);
    }

    public User findByUsername(User user) {
        User userPS = em.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", user.getUsername())
                .getSingleResult();
        return userPS;
    }

}
