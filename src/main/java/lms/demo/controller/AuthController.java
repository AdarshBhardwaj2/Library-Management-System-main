package lms.demo.controller;

import lms.demo.model.SignupRequest;
import lms.demo.model.UserResponse;
import lms.demo.service.UserService;
import lms.demo.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;
  private final JwtUtil jwtUtil;

  public AuthController(UserService userService, JwtUtil jwtUtil) {
    this.userService = userService;
    this.jwtUtil = jwtUtil;
  }

  // User Registration Endpoint
  @PostMapping("/register")
  public ResponseEntity<Map<String, String>> registerUser(@RequestBody SignupRequest userRequest) {

//    UserResponse userResponse = userService.registerUser(userRequest);

    // Generate JWT token
    String token = JwtUtil.generateToken("asdfadsf");

    // Return response with token
    Map<String, String> response = new HashMap<>();
    response.put("message", "User registered successfully");
    response.put("token", token);
    return ResponseEntity.ok(response);

  }

  // User Login Endpoint (returns JWT token)
  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> loginUser(@RequestBody SignupRequest userRequest) {
    // Validate user credentials (for simplicity, assuming username & password check is inside userService)
    // Validate user credentials
    UserResponse userResponse = userService.loginUser(userRequest);
    if (userResponse == null) {
      return ResponseEntity.status(401).body(Map.of("error", "Invalid Credentials"));
    }

    // Generate JWT token
    String token = jwtUtil.generateToken(userResponse.getEmail()); // Use email as identifier

    // Return token in response
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return ResponseEntity.ok(response);
  }
}
