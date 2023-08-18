package com.jeli.myeverytime.repository;

import com.jeli.myeverytime.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("Select m from Member m", Member.class).getResultList();
    }

    public void delete(Long id) {
        Member findedMember = em.find(Member.class, id);
        em.remove(findedMember);
    }

    public Member findByLoginIdAndPassword(String loginId, String password) {
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.loginId=:loginId and m.password = :password", Member.class);

        query.setParameter("loginId",loginId);
        query.setParameter("password",password);
        List<Member> resultList = query.getResultList();

        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        else {
            return null;
        }
    }
}
