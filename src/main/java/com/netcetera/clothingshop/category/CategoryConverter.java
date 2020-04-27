package com.netcetera.clothingshop.category;

import com.netcetera.clothingshop.domain.Category;
import lombok.NonNull;

public class CategoryConverter {

    private CategoryConverter() {
        //no instances needed
    }

    public static CategoryDto convert(@NonNull Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .build();
    }
}
