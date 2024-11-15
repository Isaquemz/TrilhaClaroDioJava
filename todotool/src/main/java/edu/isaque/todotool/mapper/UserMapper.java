package edu.isaque.todotool.mapper;

import edu.isaque.todotool.dto.auth.RegisterUserRequestDTO;
import edu.isaque.todotool.dto.user.UserProfileDTO;
import edu.isaque.todotool.model.CustomUserDetails;
import edu.isaque.todotool.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(RegisterUserRequestDTO registerUserRequestDTO);

    CustomUserDetails toCustomUserDetails(User user);

    UserProfileDTO toUserProfileDTO(CustomUserDetails user);

}
