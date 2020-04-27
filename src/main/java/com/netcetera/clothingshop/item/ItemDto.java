package com.netcetera.clothingshop.item;

import com.netcetera.clothingshop.picture.PictureDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ItemDto {
    private long id;
    private String name;
    private String price;
    private String category;
    private List<PictureDto> pictures;
}
