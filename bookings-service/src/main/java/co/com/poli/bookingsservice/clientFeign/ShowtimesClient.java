package co.com.poli.bookingsservice.clientFeign;

import co.com.poli.bookingsservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "showtimes-service", fallback = ShowtimesClientImplHystrixFallback.class)
public interface ShowtimesClient {
    @GetMapping("/store/api/v1/showtimes/{id}")
    Response findById(@PathVariable("id") Long id);
}
