package com.nhn.corn.jpaclean.acl.repository.criteria;

import com.nhn.corn.jpaclean.acl.entity.Acl;

import java.util.List;

public interface AclRepositoryCustom {
    /* Criteria를 사용하기 위한 Repository */
    List<Acl> findAllByAclCondition(Acl condition);
}
