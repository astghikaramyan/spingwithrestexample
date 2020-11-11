package am.bdg.service;

import am.bdg.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 08.11.2020.
 */
public interface UserService {
    UserEntity add(UserEntity userEntity);
    Optional<UserEntity> get(Integer id);
    List<UserEntity> getAll();
    void delete(Integer id);
}
