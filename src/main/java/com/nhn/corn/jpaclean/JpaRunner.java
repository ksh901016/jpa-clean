package com.nhn.corn.jpaclean;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.AclKey;
import com.nhn.corn.jpaclean.acl.repository.AclRepository;
import com.nhn.corn.jpaclean.acl.repository.predicate.AclPredicate;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    AclRepository repository;

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
    }
}
