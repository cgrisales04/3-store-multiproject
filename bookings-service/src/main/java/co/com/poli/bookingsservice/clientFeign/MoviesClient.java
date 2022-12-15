package co.com.poli.bookingsservice.clientFeign;

import co.com.poli.bookingsservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service", fallback = MovieClientImplHystrixFallback.class)
public interface MoviesClient {
    @GetMapping("/store/api/v1/movies/{id}")
    Response findById(@PathVariable("id") Long id);
}
