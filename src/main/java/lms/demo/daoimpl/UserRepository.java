package lms.demo.daoimpl;

import lms.demo.model.SignupRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SignupRequest,String> {
}
