package com.nhn.corn.jpaclean;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.AclKey;
import com.nhn.corn.jpaclean.acl.entity.Company;
import com.nhn.corn.jpaclean.acl.repository.specification.AclCondition;
import com.nhn.corn.jpaclean.acl.repository.specification.repository.CompanyRepository;
import com.nhn.corn.jpaclean.acl.repository.specification.repository.SpecifiAclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    SpecifiAclRepository aclRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        insertData();
    }

    public void insertData(){
        // ACL 2개, Company 2개

        Company company = new Company("D01", "D01 이름");
        companyRepository.save(company);

        AclKey aclKey = new AclKey("1.1.1.", "D01");
        Acl acl = new Acl();
        acl.setKey(aclKey);
        acl.setCompany(new Company("D01", "D01이름"));
        aclRepository.save(acl);

        System.out.println(aclRepository.findAll(AclCondition.join()));
    }

    /* specification
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Acl newAcl = insertAclData();
        List<Acl> resultList = aclRepository.findAll(where(AclCondition.hasIp("1.1.1.1"))
                .and(AclCondition.hasIp("1.1.1.1"))
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
        aclRepository.save(acl);
        return acl;
    }*/

    /* queryDSL
    @Override
    public void run(ApplicationArguments args) throws Exception {
        AclKey aclKey = new AclKey("1.1.1.","cod1", "company1");
        Acl acl = new Acl();
        acl.setKey(aclKey);
        acl.setAge("25");
        aclRepository.save(acl);

        //AclKey selectKey = new AclKey("1.1.1.","cod1", "company1");
        System.out.println("=======findAll========");
        System.out.println(aclRepository.findAll());
        System.out.println("=======findAll========");

        Acl condition = new Acl();
        condition.setAge("25");
        condition.setName("corn");
        System.out.println("========search=======");
        System.out.println(aclRepository.findAll(AclPredicate.search(condition)));
        System.out.println("========search=======");
    }*/
}
