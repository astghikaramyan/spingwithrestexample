package am.bdg.mapper;

import java.util.List;

/**
 * Created by User on 08.11.2020.
 */
public interface Mapper<Entity, Dto> {
    Dto toDto(Entity entity);
    Entity toEntity(Dto entity);
    List<Dto> toDtoList(List<Entity> entityList);
    List<Entity> toEntityList(List<Dto> dtoList);
}
