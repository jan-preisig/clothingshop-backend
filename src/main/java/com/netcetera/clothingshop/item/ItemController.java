package com.netcetera.clothingshop.item;

import com.netcetera.clothingshop.repository.ItemRepository;
import com.netcetera.rest.WebServiceUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = WebServiceUrl.Items)
@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems(){
        final List<ItemDto> itemDtos = ItemConverter.convert(itemRepository.findAll());
        return new ResponseEntity<>(itemDtos, HttpStatus.OK);
    }
}
