package com.nhn.corn.jpaclean.acl.repository;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.AclKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AclRepository extends JpaRepository<Acl, AclKey>, QuerydslPredicateExecutor<Acl>, AclRepositoryCustom {

}
