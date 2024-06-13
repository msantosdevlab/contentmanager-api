package com.msantos.contentmanager.mappers;

import org.springframework.stereotype.Component;

import com.msantos.contentmanager.dto.components.ContentBtnDTO;
import com.msantos.contentmanager.dto.components.ContentCompleteDTO;
import com.msantos.contentmanager.dto.components.ContentSimpleDTO;
import com.msantos.contentmanager.entities.components.ContentBtn;
import com.msantos.contentmanager.entities.components.ContentComplete;
import com.msantos.contentmanager.entities.components.ContentSimple;
import com.msantos.contentmanager.entities.enums.Areas;

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

}
