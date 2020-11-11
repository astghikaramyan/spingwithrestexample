package am.bdg.mapper;

import am.bdg.dto.UserDto;
import am.bdg.entity.UserEntity;

/**
 * Created by User on 08.11.2020.
 */

@org.mapstruct.Mapper(componentModel = "spring")
public interface UserMapper extends Mapper<UserEntity, UserDto> {
}
