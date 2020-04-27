package com.netcetera.clothingshop.userOrder;

import com.netcetera.clothingshop.item.ItemDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UserOrderDto {
    private long id;
    private String firstName;
    private String lastName;
    private String street;
    private String plz;
    private String phoneNumber;
    private String country;
    private List<ItemDto> items;
}
