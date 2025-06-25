package AllSpringSecurityInOne.AllSpringSecurityInOne.repository;

import AllSpringSecurityInOne.AllSpringSecurityInOne.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Integer> {



}
