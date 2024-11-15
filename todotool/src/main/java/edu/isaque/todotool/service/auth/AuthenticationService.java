package edu.isaque.todotool.service.auth;

import edu.isaque.todotool.dto.auth.LoginUserRequestDTO;
import edu.isaque.todotool.dto.auth.RegisterUserRequestDTO;
import edu.isaque.todotool.enums.Roles;
import edu.isaque.todotool.exception.InvalidCredentialsException;
import edu.isaque.todotool.exception.UserAlreadyExistsException;
import edu.isaque.todotool.mapper.UserMapper;
import edu.isaque.todotool.model.CustomUserDetails;
import edu.isaque.todotool.model.Role;
import edu.isaque.todotool.model.User;
import edu.isaque.todotool.repository.RoleRepository;
import edu.isaque.todotool.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long signup(RegisterUserRequestDTO dto) throws RoleNotFoundException {

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        User user = userMapper.toUser(dto);

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(Roles.ROLE_USER.name())
                .orElseThrow(() -> new RoleNotFoundException("Error: Role USER not found"));
        roles.add(userRole);

        user.setRoles(roles);

        return userRepository.save(user).getId();

    }

    @Transactional(readOnly = true)
    public CustomUserDetails authenticate(LoginUserRequestDTO dto) {
        User credentials = userRepository.findByEmail(dto.getEmail())
                .filter(user -> passwordEncoder.matches(dto.getPassword(), user.getPassword()))
                .orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

        return CustomUserDetails.build(credentials);
    }

}