package com.leverx.peoplebase.user.controller;

import com.leverx.peoplebase.user.entity.User;
import com.leverx.peoplebase.user.entity.dto.UserInputDto;
import com.leverx.peoplebase.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @RequestMapping(method = GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") long id) {
        return userService.findById(id)
                .map(user -> ResponseEntity.ok().contentType(APPLICATION_JSON).body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public HttpStatus deleteById(@PathVariable("id") long id) {
        userService.delete(id);
        return HttpStatus.FORBIDDEN;
    }

    @RequestMapping(method = POST)
    public void create(@RequestBody UserInputDto userInputDto) {
        userService.save(userInputDto);
    }
}