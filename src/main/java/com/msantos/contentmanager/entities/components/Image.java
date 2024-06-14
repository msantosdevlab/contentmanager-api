package com.msantos.contentmanager.entities.components;

import com.msantos.contentmanager.entities.PageTemplate;
import com.msantos.contentmanager.entities.enums.Areas;
import com.msantos.contentmanager.entities.enums.ImageExtension;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_comp_images")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String url;
    private String nameImage;

    @Enumerated(EnumType.STRING)
    private ImageExtension extension;

    @Lob // diz que o campo é um arquivo
    private byte[] file;

    @ManyToOne
    @JoinColumn(name = "id_page")
    private PageTemplate idPage;

    @Enumerated(EnumType.STRING)
    private Areas area;

    public String getFileName(){
    return getNameImage().concat(".").concat(getExtension().name());
    }
}
