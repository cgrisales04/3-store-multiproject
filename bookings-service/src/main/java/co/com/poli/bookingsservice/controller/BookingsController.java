package co.com.poli.bookingsservice.controller;

import co.com.poli.bookingsservice.helpers.Response;
import co.com.poli.bookingsservice.helpers.ResponseBuild;
import co.com.poli.bookingsservice.persistence.entity.Bookings;
import co.com.poli.bookingsservice.service.BookingsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingsController {
    private final BookingsServices bookingsServices;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody Bookings bookings, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(formatMessage(result));
        }
        Boolean resultInsert = bookingsServices.save(bookings);
        if (resultInsert) {
            return build.success(bookings);
        }
        return build.failed(bookings);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Bookings bookings = bookingsServices.findById(id);
        bookingsServices.delete(bookings);
        return build.success(bookings);
    }

    @GetMapping
    public Response findAll() {
        return build.success(bookingsServices.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return build.success(bookingsServices.findById(id));
    }

    @GetMapping("/user/{id}")
    public Response findByuserid(@PathVariable("id") Long userid) {
        return build.success(bookingsServices.findByuserid(userid));
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
