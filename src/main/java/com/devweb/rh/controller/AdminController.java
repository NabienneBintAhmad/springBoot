package com.devweb.rh.controller;

import com.devweb.rh.model.Admin;
import com.devweb.rh.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Admin> liste(){
        return adminRepository.findAll();
    }
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Admin add(@RequestBody(required = false) Admin admin){
        Admin a = new Admin();
        a.setNomm(admin.getNomm());
        a.setPrenomm(admin.getPrenomm());
        a.setMatriculee(admin.getMatriculee());
        a.setCnii(admin.getCnii());
        a.setAdressee(admin.getAdressee());
        a.setEmaill(admin.getEmaill());
        a.setContactt(admin.getContactt());
        a.setStatut("Debloquer");
        return adminRepository.save(a);
    }

}
