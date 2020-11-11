package am.bdg.repo;

import am.bdg.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 08.11.2020.
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
}
