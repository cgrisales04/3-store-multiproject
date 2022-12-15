package co.com.poli.userservice.controller;

import co.com.poli.userservice.helpers.Response;
import co.com.poli.userservice.helpers.ResponseBuild;
import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(formatMessage(result));
        }
        userServices.save(user);
        return build.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        User user = userServices.findById(id);
        Boolean resultDelete = userServices.delete(user);
        if (resultDelete) {
            return build.success(user);
        }
        return build.failed(user);
    }

    @GetMapping
    public Response findAll() {
        return build.success(userServices.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return build.success(userServices.findById(id));
    }


    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }
}
