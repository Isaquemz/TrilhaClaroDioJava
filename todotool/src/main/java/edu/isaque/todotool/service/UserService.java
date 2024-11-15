package edu.isaque.todotool.service;

import edu.isaque.todotool.dto.user.UserProfileDTO;
import edu.isaque.todotool.mapper.UserMapper;
import edu.isaque.todotool.model.CustomUserDetails;
import edu.isaque.todotool.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserProfileDTO authenticatedUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails currentUser = (CustomUserDetails) authentication.getPrincipal();
        return userMapper.toUserProfileDTO(currentUser);
    }

}
