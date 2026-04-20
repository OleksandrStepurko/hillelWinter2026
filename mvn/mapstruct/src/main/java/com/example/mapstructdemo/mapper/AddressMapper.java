package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.dto.AddressDto;
import com.example.mapstructdemo.model.AddressEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {

    AddressEntity toEntity(AddressDto dto); // dto -> entity

    AddressDto toDto(AddressEntity entity); // entity -> dto
}
