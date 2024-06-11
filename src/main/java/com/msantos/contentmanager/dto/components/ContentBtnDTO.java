package com.msantos.contentmanager.dto.components;

import com.msantos.contentmanager.entities.components.ContentBtn;
import com.msantos.contentmanager.entities.enums.Areas;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentBtnDTO {
      private Long id;

    private String title;
    private String description;

    private String btnName;
    private String btnHref;
    private String btnTarget;

    @Enumerated(EnumType.STRING)
    private Areas area;

    public ContentBtnDTO(ContentBtn entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        btnName = entity.getBtnName();
        btnHref = entity.getBtnHref();
        btnTarget = entity.getBtnTarget();
        area = entity.getArea();
    }

}
