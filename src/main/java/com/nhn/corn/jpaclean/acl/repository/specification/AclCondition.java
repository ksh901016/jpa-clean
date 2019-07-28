package com.nhn.corn.jpaclean.acl.repository.specification;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.Acl_;
import com.nhn.corn.jpaclean.acl.entity.Company;
import com.nhn.corn.jpaclean.acl.entity.Company_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.metamodel.SingularAttribute;

public class AclCondition {

    public static Specification<Acl> hasIp(String ip){
        return (acl, cq, cb) -> cb.equal(acl.get("key").get("ip"), ip);
    }

    public static Specification<Acl> hasServiceGroupCode(String serviceGroupCode){
        return (acl, cq, cb) -> cb.equal(acl.get("key").get("serviceGroupCode"), serviceGroupCode);
    }

    public static Specification<Acl> hasCompanyId(String companyId){
        return (acl, cq, cb) -> cb.equal(acl.get("company").get("companyId"), companyId);
    }

    public static Specification<Acl> containName(String name){
        return (acl, cq, cb) -> cb.like(acl.get("name"), "%" + name + "%");
    }

    public static Specification<Acl> hasAge(String age){
        return (acl, cq, cb) -> cb.equal(acl.get("age"), age);
    }

    public static Specification<Acl> join(){
        return (root, cq, cb) -> {
            root.join(root.get("company").toString(), JoinType.LEFT);
            //final Join<Acl, Company> join = root.join(root.get("company"), JoinType.LEFT);
            return null;
        };
    }
    public static Specification<Acl> searchCondition(){
        return Specification.where(hasAge("30")).and(hasAge("dd").and(hasIp("dd")).and(hasCompanyId("")));
    }

}
