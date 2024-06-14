package com.msantos.contentmanager.entities.enums;

import lombok.Getter;
import org.springframework.http.MediaType;


public enum ImageExtension {

    PNG(MediaType.IMAGE_PNG),
    GIF(MediaType.IMAGE_GIF),
    JPEG(MediaType.IMAGE_JPEG);

    @Getter
    private MediaType mediaType;

    ImageExtension(MediaType mediaType) {
        this.mediaType = mediaType;
    }


}
