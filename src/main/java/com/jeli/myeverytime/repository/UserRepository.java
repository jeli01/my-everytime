package com.jeli.myeverytime.repository;

import com.jeli.myeverytime.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    private void save(User user) {
        em.persist(user);
    }
    private User findOne(Long id) {
        return em.find(User.class, id);
    }

    private List<User> findAll() {
        return em.createQuery("Select p from User p", User.class).getResultList();
    }

    private void delete(Long id) {
        User findedUser = em.find(User.class, id);
        em.remove(findedUser);
    }
}
