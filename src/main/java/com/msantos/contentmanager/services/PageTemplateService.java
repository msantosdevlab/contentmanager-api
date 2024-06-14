package com.msantos.contentmanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msantos.contentmanager.dto.PageTemplateDTO;
import com.msantos.contentmanager.dto.components.ContentBtnDTO;
import com.msantos.contentmanager.dto.components.ContentCompleteDTO;
import com.msantos.contentmanager.dto.components.ContentSimpleDTO;
import com.msantos.contentmanager.entities.PageTemplate;
import com.msantos.contentmanager.entities.components.ContentBtn;
import com.msantos.contentmanager.entities.components.ContentComplete;
import com.msantos.contentmanager.entities.components.ContentSimple;
import com.msantos.contentmanager.mappers.ComponentsMapper;
import com.msantos.contentmanager.repositories.PagesRepository;
import com.msantos.contentmanager.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PageTemplateService {

    @Autowired
    private PagesRepository repository;

    @Autowired
    private ComponentsMapper componentsMapper;

    @Transactional
    public PageTemplateDTO insert(PageTemplateDTO dto) {
        PageTemplate entity = new PageTemplate();
        entity.setNamePage(dto.getNamePage());

        for (ContentSimpleDTO csDTO : dto.getContentSimple()) {
            ContentSimple contentSimple = componentsMapper.simpleDtoToEntity(csDTO);
            contentSimple.setIdPage(entity);
            entity.getContentSimple().add(contentSimple);
        }

        for (ContentCompleteDTO completeDTO : dto.getContentComplete()) {
            ContentComplete contentblock = componentsMapper.completeDtoToEntity(completeDTO);
            contentblock.setIdPage(entity);
            entity.getContentComplete().add(contentblock);
        }

        for (ContentBtnDTO cbtnDTO : dto.getContentBtn()) {
            ContentBtn contentblock = componentsMapper.btnDtoToEntity(cbtnDTO);
            contentblock.setIdPage(entity);
            entity.getContentBtn().add(contentblock);
        }

        entity = repository.save(entity);

        return new PageTemplateDTO(entity);
    }

    @Transactional(readOnly = true)
    public PageTemplateDTO findPage(String namePage) {
        try {
            PageTemplate result = repository.findPage(namePage);
            PageTemplateDTO dto = new PageTemplateDTO(result);
            return dto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public PageTemplateDTO update(String namePage, PageTemplateDTO dto) {
        try {
            PageTemplate entity = repository.findPage(namePage);

            entity.setNamePage(dto.getNamePage());

            entity.getContentSimple().clear();
            for (ContentSimpleDTO csDTO : dto.getContentSimple()) {
                ContentSimple contentSimple = componentsMapper.simpleDtoToEntity(csDTO);
                contentSimple.setIdPage(entity);
                entity.getContentSimple().add(contentSimple);
            }

            entity.getContentComplete().clear();
            for (ContentCompleteDTO completeDTO : dto.getContentComplete()) {
                ContentComplete contentblock = componentsMapper.completeDtoToEntity(completeDTO);
                contentblock.setIdPage(entity);
                entity.getContentComplete().add(contentblock);
            }

            entity.getContentBtn().clear();
            for (ContentBtnDTO cbtnDTO : dto.getContentBtn()) {
                ContentBtn contentblock = componentsMapper.btnDtoToEntity(cbtnDTO);
                contentblock.setIdPage(entity);
                entity.getContentBtn().add(contentblock);
            }

            entity = repository.saveAndFlush(entity);
            return new PageTemplateDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Página não encontrada");
        }
    }

    @Transactional(readOnly = true) // somente leitura
    public PageTemplate findById(Long id) {
        Optional<PageTemplate> result = repository.findById(id);
        PageTemplate page = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        // PageTemplateDTO dto = new PageTemplateDTO(page);
        return page;
    }

}
