package com.netcetera.clothingshop.item;

import com.netcetera.clothingshop.category.CategoryConverter;
import com.netcetera.clothingshop.domain.Item;
import com.netcetera.clothingshop.picture.PictureConverter;
import lombok.NonNull;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ItemConverter {

    private ItemConverter() {
        //no instances needed
    }

    static ItemDto convert(@NonNull Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .category(CategoryConverter.convert(item.getCategory()).getName())
                .pictures(PictureConverter.convert(item.getPictures()))
                .build();
    }

    public static List<ItemDto> convert(@NonNull List<Item> items) {
        return items.stream().map(ItemConverter::convert).collect(toList());
    }
}
