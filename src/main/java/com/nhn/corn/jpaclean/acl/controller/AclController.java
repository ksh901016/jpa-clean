package com.nhn.corn.jpaclean.acl.controller;

import com.nhn.corn.jpaclean.acl.entity.Acl;
import com.nhn.corn.jpaclean.acl.repository.AclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acl")
public class AclController {

    @Autowired
    AclRepository repository;

    @GetMapping("/list")
    public Page<Acl> listAll(Model model, Pageable pageable){
        repository.findAll(pageable);
        return null;
    }
}
