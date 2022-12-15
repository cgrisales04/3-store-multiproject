package co.com.poli.productservice.controller;

import co.com.poli.productservice.helpers.Response;
import co.com.poli.productservice.helpers.ResponseBuild;
import co.com.poli.productservice.persistence.entity.Category;
import co.com.poli.productservice.persistence.entity.Product;
import co.com.poli.productservice.service.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productServices;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody Product product, BindingResult result){
        if(result.hasErrors()){
            return build.failed(formatMessage(result));
        }
        productServices.save(product);
        return build.success(product);
    }
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Product product = productServices.findById(id);
        productServices.delete(product);
        return build.success(product);
    }

    @GetMapping
    public Response findAll(){
        return build.success(productServices.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        return build.success(productServices.findById(id));
    }

    @GetMapping("/category")
    public Response findByCategory(@RequestBody Category category){
        return build.success(productServices.findByCategory(category));
    }

    private List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String,String> err = new HashMap<>();
                    err.put(error.getField(),error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }
}
