package com.nhn.corn.jpaclean.acl.repository.specification.repository;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.AclKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecifiAclRepository extends JpaRepository<Acl, AclKey>, JpaSpecificationExecutor<Acl> {

}
