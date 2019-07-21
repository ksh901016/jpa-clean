package com.nhn.corn.jpaclean.acl.repository.queryDSL.repository;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.AclKey;
import com.nhn.corn.jpaclean.acl.repository.criteria.AclRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

public interface AclRepository extends JpaRepository<Acl, AclKey>, QuerydslPredicateExecutor<Acl>{

}
