package com.nhn.corn.jpaclean.acl.repository.specification;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class AclCondition {

    public static Specification<Acl> hasIp(String ip){
        return (acl, cq, cb) -> cb.equal(acl.get("key").get("ip"), ip);
    }

    public static Specification<Acl> hasServiceGroupCode(String serviceGroupCode){
        return (acl, cq, cb) -> cb.equal(acl.get("key").get("serviceGroupCode"), serviceGroupCode);
    }

    public static Specification<Acl> hasCompanyId(String companyId){
        return (acl, cq, cb) -> cb.equal(acl.get("key").get("companyId"), companyId);
    }

    public static Specification<Acl> containName(String name){
        return (acl, cq, cb) -> cb.like(acl.get("name"), "%" + name + "%");
    }

    public static Specification<Acl> hasAge(String age){
        return (acl, cq, cb) -> cb.equal(acl.get("age"), age);
    }

    public static Specification<Acl> searchCondition(){
        return Specification.where(hasAge("30")).and(hasAge("dd").and(hasIp("dd")).and(hasCompanyId("")));
    }

}
