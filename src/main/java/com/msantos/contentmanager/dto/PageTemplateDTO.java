package com.msantos.contentmanager.dto;

import java.util.ArrayList;
import java.util.List;

import com.msantos.contentmanager.dto.components.ContentBtnDTO;
import com.msantos.contentmanager.dto.components.ContentCompleteDTO;
import com.msantos.contentmanager.dto.components.ContentSimpleDTO;
import com.msantos.contentmanager.entities.PageTemplate;
import com.msantos.contentmanager.entities.components.ContentBtn;
import com.msantos.contentmanager.entities.components.ContentComplete;
import com.msantos.contentmanager.entities.components.ContentSimple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageTemplateDTO {
        private Long id;

    private String namePage;

    @Builder.Default
    private List<ContentSimpleDTO> contentSimple = new ArrayList<>();
    @Builder.Default
    private List<ContentCompleteDTO> contentComplete = new ArrayList<>();
    @Builder.Default
    private List<ContentBtnDTO> contentBtn = new ArrayList<>();

        public PageTemplateDTO(PageTemplate entity) {
        id = entity.getId();
        namePage = entity.getNamePage();

        for (ContentSimple contSimple : entity.getContentSimple()) {
            contentSimple.add(new ContentSimpleDTO(contSimple));
        }

        for (ContentComplete contComplete : entity.getContentComplete()) {
            contentComplete.add(new ContentCompleteDTO(contComplete));
        }

        for (ContentBtn contBtn : entity.getContentBtn()) {
            contentBtn.add(new ContentBtnDTO(contBtn));
        }
    }
    
}
