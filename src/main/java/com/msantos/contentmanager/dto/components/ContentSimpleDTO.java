package com.msantos.contentmanager.dto.components;

import com.msantos.contentmanager.entities.components.ContentSimple;
import com.msantos.contentmanager.entities.enums.Areas;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentSimpleDTO {
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Areas area;

    public ContentSimpleDTO(ContentSimple entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        area = entity.getArea();
    }

}
