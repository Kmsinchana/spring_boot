package com.example.verisioning_of_RestAPI.controller;

import com.example.verisioning_of_RestAPI.dto.UserDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDTO getTheUser(@PathVariable Long id){
        return new UserDTO(id,"Jhon");
    }
    @GetMapping
   public CollectionModel<UserDTO> getALLUser(){
        List<UserDTO> user = List.of(
                new UserDTO(1L,"sinchu"),
                new UserDTO(2L,"varsha")
        );
        CollectionModel<UserDTO> model = CollectionModel.of(user);
        model.add(linkTo(methodOn(UserController.class).getALLUser()).withSelfRel());
        model.add(linkTo(methodOn(UserController.class).getTheUser(1L)).withRel("User-with-id"));
        return model;
    }
}
