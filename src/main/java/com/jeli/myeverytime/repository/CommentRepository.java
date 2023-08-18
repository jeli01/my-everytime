package com.jeli.myeverytime.repository;

import com.jeli.myeverytime.domain.Comment;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }
    public Comment findOne(Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> findAll() {
        return em.createQuery("Select c from Comment c", Comment.class).getResultList();
    }

    public void delete(Long id) {
        Comment findedComment = em.find(Comment.class, id);
        em.remove(findedComment);
    }
}
