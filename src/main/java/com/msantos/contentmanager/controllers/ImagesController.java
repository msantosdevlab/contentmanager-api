package com.msantos.contentmanager.controllers;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.msantos.contentmanager.entities.PageTemplate;
import com.msantos.contentmanager.entities.components.Image;
import com.msantos.contentmanager.entities.enums.Areas;
import com.msantos.contentmanager.mappers.ComponentsMapper;
import com.msantos.contentmanager.services.ImageService;
import com.msantos.contentmanager.services.PageTemplateService;

@CrossOrigin(origins = { "http://localhost:5173/", "http://localhost:5174/" })
@RestController
@RequestMapping(value = "/images")
public class ImagesController {

    @Autowired
    private ImageService service;

    @Autowired
    private ComponentsMapper componentsMapper;

    @Autowired
    private PageTemplateService servicePageTemplate;

    @PostMapping
    public ResponseEntity<?> insert(@RequestParam("file") List<MultipartFile> files,
            @RequestParam("nameImage") List<String> namesImages,
            @RequestParam("area") List<Areas> areas, @RequestParam("idPage") List<Long> idsPages) throws IOException {

        List<PageTemplate> entities = new ArrayList<>();
        for (int i = 0; i < idsPages.size(); i++) {
            PageTemplate entity = servicePageTemplate.findById(idsPages.get(i));
            entities.add(entity);
        }

        List<Image> images = componentsMapper.datasToImages(files, namesImages, areas, entities);

        List<Image> savedImage = service.insertImages(images);

        List<URI> imageUris = buildImageURLs(savedImage);

        // Atualiza as imagens com as URLs
        for (int i = 0; i < savedImage.size(); i++) {
            savedImage.get(i).setUrl(imageUris.get(i).toString());

            service.update(savedImage.get(i));
        }

        return ResponseEntity.ok("Imagens salvas com sucesso!");
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        var possibleImage = service.getById(id);
        if (possibleImage.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var image = possibleImage.get();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(image.getExtension().getMediaType());
        headers.setContentDispositionFormData("inline; filename=\"" + image.getFileName() + "\"", image.getFileName());

        return new ResponseEntity<>(image.getFile(), headers, HttpStatus.OK);

    }

    private List<URI> buildImageURLs(List<Image> images) {
        List<URI> imageUrls = new ArrayList<>();
        for (Image image : images) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(image.getId())
                    .toUri();
            imageUrls.add(uri);
        }
        return imageUrls;
    }

}
