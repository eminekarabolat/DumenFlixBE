package com.mcann.dumenflix.mapper;

import com.mcann.dumenflix.dto.request.RegisterRequestDto;
import com.mcann.dumenflix.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
	
	User fromRegisterRequestDto(RegisterRequestDto dto);
}