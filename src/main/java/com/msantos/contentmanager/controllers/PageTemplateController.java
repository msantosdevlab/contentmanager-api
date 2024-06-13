package com.msantos.contentmanager.controllers;

import java.net.URI;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.msantos.contentmanager.dto.PageTemplateDTO;
import com.msantos.contentmanager.services.PageTemplateService;

@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5174/"})
@RestController
@RequestMapping(value = "/pages")
public class PageTemplateController {

    @Autowired
    private PageTemplateService service;

    
    @PostMapping
    public ResponseEntity<PageTemplateDTO> insert(@Valid @RequestBody PageTemplateDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @GetMapping(value = "/{namePage}")
    public ResponseEntity<?> findPage(@PathVariable String namePage) {
        namePage = namePage.toUpperCase();
        PageTemplateDTO dto = service.findPage(namePage);       
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "{namePage}/edit")
    public ResponseEntity<PageTemplateDTO> update(@PathVariable String namePage, @Valid @RequestBody PageTemplateDTO dto) {
        dto = service.update(namePage, dto);
        return ResponseEntity.ok(dto);
    }
    
}
