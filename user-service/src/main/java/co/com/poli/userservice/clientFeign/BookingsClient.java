package co.com.poli.userservice.clientFeign;

import co.com.poli.userservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookings-service", fallback = BookingsClientImplHystrixFallback.class)
public interface BookingsClient {
    @GetMapping("/store/api/v1/bookings/user/{id}")
    Response findByuserid(@PathVariable("id") Long id);
}
