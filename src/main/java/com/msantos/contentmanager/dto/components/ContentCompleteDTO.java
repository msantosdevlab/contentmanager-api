package com.msantos.contentmanager.dto.components;

import com.msantos.contentmanager.entities.components.ContentComplete;
import com.msantos.contentmanager.entities.enums.Areas;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentCompleteDTO {
        private Long id;
    
    private String eyebrow;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Areas area;

    public ContentCompleteDTO(ContentComplete entity) {
        id = entity.getId();
        eyebrow = entity.getEyebrow();
        title = entity.getTitle();
        description = entity.getDescription();
        area = entity.getArea();
    }

}
