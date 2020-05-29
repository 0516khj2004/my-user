package com.example.userapi.conroller;

import com.example.userapi.model.CreateResponseModel;
import com.example.userapi.model.CreateUserRequestModel;
import com.example.userapi.model.UserResponseModel;
import com.example.userapi.repository.UserRepository;
import com.example.userapi.service.Userservice;
import com.example.userapi.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    Userservice userservice;

    //추가
    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<CreateResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(
                MatchingStrategies.STRICT
        );
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createDto = userservice.createUser(userDto);

        CreateResponseModel returnValue = modelMapper.map(createDto,
                CreateResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
    //회원관리
    @GetMapping(value = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId){
        UserDto userDto = userservice.getUserByUserId(userId);
        UserResponseModel returnValue = new ModelMapper().map(userDto,UserResponseModel.class );
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }


}
