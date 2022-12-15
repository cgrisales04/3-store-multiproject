package co.com.poli.showtimesservice.controller;

import co.com.poli.showtimesservice.helpers.Response;
import co.com.poli.showtimesservice.helpers.ResponseBuild;
import co.com.poli.showtimesservice.persistence.entity.Showtimes;
import co.com.poli.showtimesservice.service.ShowtimesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimesController {
    private final ShowtimesServices showtimesServices;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody Showtimes showtimes, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(formatMessage(result));
        }
        Boolean resultInsert = showtimesServices.save(showtimes);
        if (resultInsert){
            return build.success(showtimes);
        }
        return build.failed(showtimes);
    }

    @GetMapping
    public Response findAll() {
        return build.success(showtimesServices.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return build.success(showtimesServices.findById(id));
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
