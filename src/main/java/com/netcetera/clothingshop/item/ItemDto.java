package com.netcetera.clothingshop.item;

import com.netcetera.clothingshop.picture.PictureDto;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
public class ItemDto {
    private long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String category;
    private List<PictureDto> pictures;
}
