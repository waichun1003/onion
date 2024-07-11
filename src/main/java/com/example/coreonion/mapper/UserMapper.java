package com.example.coreonion.mapper;

import com.example.coreonion.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    User findUserById(Long userId);

    void updateUser(User user);

    void deleteUser(Long userId);

    User findUserByVerificationToken(String token);

    List<User> findAllUsers();

    User findUserByToken(@Param("token") String token);
}
