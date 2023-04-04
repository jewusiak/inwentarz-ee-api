package pl.jewusiak.inwentarzeeapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.jewusiak.inwentarzeeapi.models.dtos.UserDto;
import pl.jewusiak.inwentarzeeapi.services.UserService;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}/{isenabled}")
    public UserDto changeUserActivationStatus(@PathVariable long id, @PathVariable int isenabled) {
        if (isenabled != 0 && isenabled != 1)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endpoint use: /users/{user id}/{0 or 1}. 0=false, 1=true.");
        return userService.changeUserActivationStatus(id, isenabled == 1).toDto();
    }
}
