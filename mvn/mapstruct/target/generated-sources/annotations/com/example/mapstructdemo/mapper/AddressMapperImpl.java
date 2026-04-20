package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.dto.AddressDto;
import com.example.mapstructdemo.model.AddressEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-23T18:36:13+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressEntity toEntity(AddressDto dto) {
        if ( dto == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCity( dto.getCity() );
        addressEntity.setStreet( dto.getStreet() );
        addressEntity.setZip( dto.getZip() );

        return addressEntity;
    }

    @Override
    public AddressDto toDto(AddressEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setCity( entity.getCity() );
        addressDto.setStreet( entity.getStreet() );
        addressDto.setZip( entity.getZip() );

        return addressDto;
    }
}
