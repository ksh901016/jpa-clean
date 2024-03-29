package com.nhn.corn.jpaclean.acl.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class AclKey implements Serializable {

    @NotNull(message = "ip is essential")
    private String ip;

    @NotNull(message = "serviceGrpCode is essential")
    private String serviceGroupCode;

}