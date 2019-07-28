package com.nhn.corn.jpaclean.acl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    private String companyId;
    private String companyName;

    /*
    @OneToMany(mappedBy = "company")
    Set<Acl> aclSet = new HashSet<>();

    public Company(String companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }*/

}
