package co.com.poli.productservice.controller;

import co.com.poli.productservice.helpers.Response;
import co.com.poli.productservice.helpers.ResponseBuild;
import co.com.poli.productservice.persistence.entity.Category;
import co.com.poli.productservice.service.CategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServices categoryServices;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@RequestBody Category category){
        categoryServices.save(category);
        return build.success(category);
    }

    @GetMapping
    public Response findAll(){
        return build.success(categoryServices.findAll());
    }

}
