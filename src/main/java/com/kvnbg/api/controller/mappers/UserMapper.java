package com.kvnbg.api.controller.mappers;

import com.kvnbg.api.controller.records.UserCreateRecord;
import com.kvnbg.api.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {
    User toModel(UserCreateRecord userCreateRecord);
}
