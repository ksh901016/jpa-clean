package com.nhn.corn.jpaclean.acl.repository;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AclRepositoryCustomImpl implements AclRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Acl> findAllByAclCondition(Acl condition) {
        // implementation
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Acl> cq = cb.createQuery(Acl.class); // CriteriaBuilder로부터 CriteriaQuery를 가져온

        // 조회의 시작점을 뜻하는 Root객체 생성 여기서 변수명 m은 JPQL에서 별칭이라고 생각하면 된다.
        Root<Acl> acl = cq.from(Acl.class);
        Predicate predicate = cb.equal(acl.get("name"), condition.getName()); // where 조건

        cq.where(predicate);
        return entityManager.createQuery(cq).getResultList();
    }
}
