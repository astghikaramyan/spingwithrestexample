package am.bdg.controller;

import am.bdg.dto.UserDto;
import am.bdg.entity.UserEntity;
import am.bdg.mapper.UserMapper;
import am.bdg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 08.11.2020.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = this.userMapper.toEntity(userDto);
        userEntity = this.userService.add(userEntity);
        return ResponseEntity.ok(this.userMapper.toDto(userEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        Optional<UserEntity> userEntity = this.userService.get(id);
        if (userEntity.isPresent()) {
            return ResponseEntity.ok(this.userMapper.toDto(userEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer id){
        UserEntity userEntity = this.userMapper.toEntity(userDto);
        userEntity.setId(id);
        userEntity = this.userService.add(userEntity);
        return ResponseEntity.ok(this.userMapper.toDto(userEntity));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserEntity> userEntity = this.userService.getAll();
        if(userEntity != null){
            return ResponseEntity.ok(this.userMapper.toDtoList(userEntity));
        }
        return ResponseEntity.notFound().build();
    }

}
//https://www.youtube.com/watch?v=mf2-MOl0VXY