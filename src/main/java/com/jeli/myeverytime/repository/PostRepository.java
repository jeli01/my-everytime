package com.jeli.myeverytime.repository;

import com.jeli.myeverytime.domain.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class PostRepository {

    private final EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }
    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findAll() {
        return em.createQuery("Select p from Post p", Post.class).getResultList();
    }

    public void delete(Long id) {
        Post findedPost = em.find(Post.class, id);
        em.remove(findedPost);
    }

    public List<Post> findPostByType(String type) {
        TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p WHERE p.type=:type ", Post.class);
        query.setParameter("type",type);

        return query.getResultList();
    }
}
