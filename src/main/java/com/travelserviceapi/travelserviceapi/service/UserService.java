package com.travelserviceapi.travelserviceapi.service;

import com.travelserviceapi.travelserviceapi.dto.requestDto.RequestUserDto;
import com.travelserviceapi.travelserviceapi.dto.responseDto.ResponseUserDto;

public interface UserService {

    public ResponseUserDto SaveUser(RequestUserDto dto);
}
