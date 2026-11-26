package kh.edu.istad.m2testapi.mapper;


import kh.edu.istad.m2testapi.dto.UserResponse;
import kh.edu.istad.m2testapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //what is source?
    //what is target?
    UserResponse mapUserToUserResponse(User user);

}
