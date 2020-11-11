package am.bdg.controller;

import am.bdg.dto.UserDto;
import am.bdg.entity.UserEntity;
import am.bdg.mapper.UserMapper;
import am.bdg.service.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by User on 08.11.2020.
 */
@Controller
public class UserControllerMVC {

    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public UserControllerMVC(UserService userService, UserMapper userMapper){
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @RequestMapping(value =  "/index", method = RequestMethod.GET)
    public String indexPage(Model model){
//        ModelAndView modelAndView = new ModelAndView();
        UserEntity userEntity = new UserEntity();
        model.addAttribute("userEntity", userEntity);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = "application/json")
    public String saveUser(@ModelAttribute("userEntity") UserEntity userEntity){
//        ModelAndView modelAndView = new ModelAndView();
        this.userService.add(userEntity);
//        modelAndView.addObject("ok", true);
//        modelAndView.setViewName("index");
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView viewPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserEntity> userEntity = this.userService.getAll();
        modelAndView.addObject("users", userEntity);
        modelAndView.setViewName("home");
        return modelAndView;
    }
//
//    @RequestMapping(value = "/home", method = RequestMethod.PUT)
//    public ModelAndView updateUsers(@RequestBody UserDto userDto, @PathVariable Integer id){
//        ModelAndView modelAndView = new ModelAndView();
//        UserEntity userEntity = this.userMapper.toEntity(userDto);
//        userEntity.setId(id);
//        userEntity = this.userService.add(userEntity);
//        modelAndView.setViewName("home");
//        return modelAndView;
//    }
}
//https://o7planning.org/ru/11545/spring-boot-and-thymeleaf-tutorial