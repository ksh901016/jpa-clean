package com.nhn.corn.jpaclean;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.AclKey;
import com.nhn.corn.jpaclean.acl.repository.specification.AclCondition;
import com.nhn.corn.jpaclean.acl.repository.specification.repository.SpecifiAclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    SpecifiAclRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Acl newAcl = insertAclData();
        List<Acl> resultList = repository.findAll(where(AclCondition.hasIp("1.1.1.1"))
                .and(AclCondition.hasCompanyId("company1")));

        System.out.println("===========");
        System.out.println(resultList);
        System.out.println("===========");
    }

    public Acl insertAclData(){
        AclKey key = new AclKey("1.1.1.1", "code1", "company1");
        Acl acl = new Acl();
        acl.setKey(key);
        acl.setName("name");
        repository.save(acl);
        return acl;
    }

    /* queryDSL
    @Override
    public void run(ApplicationArguments args) throws Exception {
        AclKey aclKey = new AclKey("1.1.1.","cod1", "company1");
        Acl acl = new Acl();
        acl.setKey(aclKey);
        acl.setAge("25");
        repository.save(acl);

        //AclKey selectKey = new AclKey("1.1.1.","cod1", "company1");
        System.out.println("=======findAll========");
        System.out.println(repository.findAll());
        System.out.println("=======findAll========");

        Acl condition = new Acl();
        condition.setAge("25");
        condition.setName("corn");
        System.out.println("========search=======");
        System.out.println(repository.findAll(AclPredicate.search(condition)));
        System.out.println("========search=======");
    }*/
}
