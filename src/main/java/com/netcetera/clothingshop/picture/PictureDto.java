package com.netcetera.clothingshop.picture;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PictureDto{
    private long id;
    private String imageURL;
}
