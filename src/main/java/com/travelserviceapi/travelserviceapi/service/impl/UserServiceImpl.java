package com.travelserviceapi.travelserviceapi.service.impl;

import com.travelserviceapi.travelserviceapi.dto.core.UserDto;
import com.travelserviceapi.travelserviceapi.dto.requestDto.RequestUserDto;
import com.travelserviceapi.travelserviceapi.dto.responseDto.ResponseUserDto;
import com.travelserviceapi.travelserviceapi.entity.User;
import com.travelserviceapi.travelserviceapi.exception.DuplicateEntryException;
import com.travelserviceapi.travelserviceapi.repo.UserRepo;
import com.travelserviceapi.travelserviceapi.service.UserService;
import com.travelserviceapi.travelserviceapi.util.Generator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final Generator generator;
    private final ModelMapper mapper;
    public UserServiceImpl(UserRepo userRepo, Generator generator, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.generator = generator;
        this.mapper = mapper;
    }

    @Override
    public ResponseUserDto SaveUser(RequestUserDto dto) {
        UserDto userDto = mapper.map(dto, UserDto.class);
        String generatePrefix = generator.generatePrefix(5, 16);
        String primaryKey = generator.generatePrimaryKey("USER-", generatePrefix);
        userDto.setUserId(primaryKey);
        if(!userRepo.existsById(userDto.getUserId())){
            User user = mapper.map(userDto, User.class);
            user.setUserProfilePic(Base64.getEncoder().encodeToString(userDto.getProfilePic()).getBytes());
            user.setUserNicFrontImg(Base64.getEncoder().encodeToString(userDto.getNicFrontImg()).getBytes());
            user.setUserNicRearImg(Base64.getEncoder().encodeToString(userDto.getNicRearImg()).getBytes());
            userRepo.save(user);
        }else {
            throw new DuplicateEntryException("Duplicate Primary Key");

        }

        return  null;

    }
}
