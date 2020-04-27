package com.netcetera.clothingshop.picture;

import com.netcetera.clothingshop.domain.Picture;
import lombok.NonNull;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PictureConverter {

    private PictureConverter() {
        //no instances needed
    }

    static PictureDto convert(@NonNull Picture picture) {
        return PictureDto.builder()
                .id(picture.getId())
                .imageURL(picture.getImageURL())
                .build();
    }

    public static List<PictureDto> convert(@NonNull List<Picture> pictures) {
        return pictures.stream().map(PictureConverter::convert).collect(toList());
    }
}
