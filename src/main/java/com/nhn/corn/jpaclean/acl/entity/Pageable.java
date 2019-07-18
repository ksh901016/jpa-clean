package com.nhn.corn.jpaclean.acl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Pageable {
    private int startPage;
    private int endPage;
}
