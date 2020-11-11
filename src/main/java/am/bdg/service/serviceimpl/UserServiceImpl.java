package am.bdg.service.serviceimpl;

import am.bdg.entity.UserEntity;
import am.bdg.repo.UserRepo;
import am.bdg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 08.11.2020.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity add(UserEntity userEntity) {
        return this.userRepo.save(userEntity);
    }

    public Optional<UserEntity> get(Integer id) {
        return this.userRepo.findById(id);
    }

    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

    public void delete(Integer id) {
        if(userRepo.findById(id).isPresent()){
            userRepo.deleteById(id);
        }
    }
}
