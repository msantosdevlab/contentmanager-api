package com.msantos.contentmanager.entities;

import java.util.ArrayList;
import java.util.List;

import com.msantos.contentmanager.entities.components.ContentBtn;
import com.msantos.contentmanager.entities.components.ContentComplete;
import com.msantos.contentmanager.entities.components.ContentSimple;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_page")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PageTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namePage;

    @Builder.Default
    @OneToMany(mappedBy = "idPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContentSimple> contentSimple = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "idPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContentComplete> contentComplete = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "idPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContentBtn> contentBtn = new ArrayList<>();

}
