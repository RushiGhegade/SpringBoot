package AllSpringSecurityInOne.AllSpringSecurityInOne.security.userRepository;


import AllSpringSecurityInOne.AllSpringSecurityInOne.security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


    Optional<UserEntity> findByEmail(String username);

}
