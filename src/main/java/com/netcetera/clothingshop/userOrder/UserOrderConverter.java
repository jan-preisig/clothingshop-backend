package com.netcetera.clothingshop.userOrder;

import com.netcetera.clothingshop.domain.UserOrder;
import com.netcetera.clothingshop.item.ItemConverter;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class UserOrderConverter {

    private UserOrderConverter() {
        //no instances needed
    }

    static UserOrderDto convert(@NonNull UserOrder userOrder) {
        return UserOrderDto.builder()
                .id(userOrder.getId())
                .firstName(userOrder.getFirstName())
                .lastName(userOrder.getLastName())
                .street(userOrder.getStreet())
                .plz(userOrder.getPlz())
                .phoneNumber(userOrder.getPhoneNumber())
                .country(userOrder.getCountry())
                .items(ItemConverter.convert(userOrder.getItems()))
                .build();
    }

    static List<UserOrderDto> convert(@NonNull List<UserOrder> userOrders) {
        return userOrders.stream().map(UserOrderConverter::convert).collect(Collectors.toList());
    }
}
