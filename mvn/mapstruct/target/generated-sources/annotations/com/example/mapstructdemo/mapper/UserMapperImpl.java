package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.dto.CreateUserRequest;
import com.example.mapstructdemo.dto.UserDto;
import com.example.mapstructdemo.model.AddressEntity;
import com.example.mapstructdemo.model.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-23T18:36:13+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    private final AddressMapper addressMapper = Mappers.getMapper( AddressMapper.class );

    @Override
    public UserDto toDto(UserEntity entity) {

        UserDto userDto = new UserDto();

        if ( entity != null ) {
            userDto.setCity( entityAddressCity( entity ) );
            userDto.setId( entity.getId() );
            userDto.setEmail( entity.getEmail() );
        }
        userDto.setFullName( joinName(entity.getFirstName(), entity.getLastName()) );
        userDto.setRole( entity.getRole() == null ? null : entity.getRole().name() );
        userDto.setCreatedAtIso( formatInstant(entity.getCreatedAt()) );

        return userDto;
    }

    @Override
    public List<UserDto> toDtoList(List<UserEntity> entities) {
        if ( entities == null ) {
            return new ArrayList<UserDto>();
        }

        List<UserDto> list = new ArrayList<UserDto>( entities.size() );
        for ( UserEntity userEntity : entities ) {
            list.add( toDto( userEntity ) );
        }

        return list;
    }

    @Override
    public UserEntity fromCreate(CreateUserRequest req) {

        UserEntity userEntity = new UserEntity();

        if ( req != null ) {
            userEntity.setAddress( addressMapper.toEntity( req.getAddress() ) );
            userEntity.setEmail( req.getEmail() );
        }
        userEntity.setFirstName( extractFirstName(req) );
        userEntity.setLastName( extractLastName(req) );
        userEntity.setRole( parseRole(req.getRole()) );
        userEntity.setCreatedAt( java.time.Instant.now() );

        return userEntity;
    }

    @Override
    public void update(UserEntity target, UserDto dto) {

        if ( dto != null ) {
            if ( target.getAddress() == null ) {
                target.setAddress( new AddressEntity() );
            }
            userDtoToAddressEntity( dto, target.getAddress() );
            if ( dto.getEmail() != null ) {
                target.setEmail( dto.getEmail() );
            }
        }
        target.setRole( parseRole(dto.getRole()) );
    }

    private String entityAddressCity(UserEntity userEntity) {
        AddressEntity address = userEntity.getAddress();
        if ( address == null ) {
            return null;
        }
        return address.getCity();
    }

    protected void userDtoToAddressEntity(UserDto userDto, AddressEntity mappingTarget) {

        if ( userDto != null ) {
            if ( userDto.getCity() != null ) {
                mappingTarget.setCity( userDto.getCity() );
            }
        }
    }
}
