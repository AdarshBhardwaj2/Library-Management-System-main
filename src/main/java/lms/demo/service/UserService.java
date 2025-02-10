package lms.demo.service;

import lms.demo.model.SignupRequest;
import lms.demo.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public interface UserService {
    public Map<String, Object> getUserById(Long id);
    List<UserResponse> getAllUsers();
    public Map<String, Object> deleteUser(Long id);
   UserResponse updateUser(SignupRequest userRequest, Long id);
    UserResponse registerUser(SignupRequest userRequest);
    UserResponse loginUser(SignupRequest userRequest);
}
