package com.jeli.myeverytime.repository;

import com.jeli.myeverytime.domain.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    private void save(Post post) {
        em.persist(post);
    }
    private Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    private List<Post> findAll() {
        return em.createQuery("Select p from Post p", Post.class).getResultList();
    }

    private void delete(Long id) {
        Post findedPost = em.find(Post.class, id);
        em.remove(findedPost);
    }
}
