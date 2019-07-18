package com.nhn.corn.jpaclean.acl.repository.predicate;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.entity.QAcl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class AclPredicate {
    public static Predicate search(Acl condition){
        QAcl acl = QAcl.acl;

        BooleanBuilder builder = new BooleanBuilder();
        if(condition.getAge() != null){
            builder.and(acl.age.eq(condition.getAge()));
        }
        if(condition.getName() != null){
            builder.and(acl.name.eq(condition.getName()));
        }
        return builder;
    }
}
