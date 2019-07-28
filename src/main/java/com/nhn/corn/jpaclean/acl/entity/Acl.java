package com.nhn.corn.jpaclean.acl.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Acl {

    @EmbeddedId
    private AclKey key;

    @ManyToOne
    private Company company;

    private String IpDescription;
    private String name;
    private String age;

    @Transient
    Pageable pageable;

}
