package com.nhn.corn.jpaclean.acl.repository.specification.repository;

import com.nhn.corn.jpaclean.acl.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
