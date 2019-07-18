package com.nhn.corn.jpaclean.acl.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@ToString
public class Acl {

    @EmbeddedId
    private AclKey key;
    private String IpDescription;
    private String name;
    private String age;

    @Transient
    Pageable pageable;

}
