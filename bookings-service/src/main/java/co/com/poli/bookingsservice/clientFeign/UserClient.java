package co.com.poli.bookingsservice.clientFeign;

import co.com.poli.bookingsservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", fallback = UserClientImplHystrixFallback.class)
public interface UserClient {
    @GetMapping("/store/api/v1/users/{id}")
    Response findById(@PathVariable("id") Long id);
}
