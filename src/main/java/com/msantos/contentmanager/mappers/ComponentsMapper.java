package com.msantos.contentmanager.mappers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.msantos.contentmanager.dto.components.ContentBtnDTO;
import com.msantos.contentmanager.dto.components.ContentCompleteDTO;
import com.msantos.contentmanager.dto.components.ContentSimpleDTO;
import com.msantos.contentmanager.entities.PageTemplate;
import com.msantos.contentmanager.entities.components.ContentBtn;
import com.msantos.contentmanager.entities.components.ContentComplete;
import com.msantos.contentmanager.entities.components.ContentSimple;
import com.msantos.contentmanager.entities.components.Image;
import com.msantos.contentmanager.entities.enums.Areas;
import com.msantos.contentmanager.entities.enums.ImageExtension;

@Component
public class ComponentsMapper {

    public ContentSimple simpleDtoToEntity(ContentSimpleDTO contentSimpleDTO) {
        return ContentSimple.builder()
                .id(contentSimpleDTO.getId())
                .title(contentSimpleDTO.getTitle())
                .description(contentSimpleDTO.getDescription())
                .area(contentSimpleDTO.getArea())
                .build();
    }

    public ContentComplete completeDtoToEntity(ContentCompleteDTO contentCompleteDTO) {
        return ContentComplete.builder()
                .id(contentCompleteDTO.getId())
                .eyebrow(contentCompleteDTO.getEyebrow())
                .title(contentCompleteDTO.getTitle())
                .description(contentCompleteDTO.getDescription())
                .area(Areas.valueOf(contentCompleteDTO.getArea().toString()))
                .build();
    }

    public ContentBtn btnDtoToEntity(ContentBtnDTO contentBtnDTO) {
        return ContentBtn.builder()
                .id(contentBtnDTO.getId())
                .title(contentBtnDTO.getTitle())
                .description(contentBtnDTO.getDescription())
                .btnName(contentBtnDTO.getBtnName())
                .btnHref(contentBtnDTO.getBtnHref())
                .btnTarget(contentBtnDTO.getBtnTarget())
                .area(Areas.valueOf(contentBtnDTO.getArea().toString()))
                .build();
    }

    public List<Image> datasToImages(List<MultipartFile> files, List<String> namesImages, List<Areas> areas,
            List<PageTemplate> entity) {
        List<Image> images = new ArrayList<>();

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            String nameImage = namesImages.get(i);
            Areas area = areas.get(i);
            PageTemplate idPage = entity.get(i);
            try {
                Image image = Image.builder()
                        .file(file.getBytes())
                        .nameImage(nameImage)
                        .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
                        .area(area)
                        .idPage(idPage)
                        .build();
                images.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return images;
    }

}
