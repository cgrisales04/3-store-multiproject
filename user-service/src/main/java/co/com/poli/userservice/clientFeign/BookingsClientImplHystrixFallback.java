package co.com.poli.userservice.clientFeign;

import co.com.poli.userservice.helpers.Response;
import co.com.poli.userservice.helpers.ResponseBuild;
import co.com.poli.userservice.persistence.entity.Bookings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingsClientImplHystrixFallback implements BookingsClient {

    private final ResponseBuild build;

    @Override
    public Response findByuserid(Long id) {
        return build.success(new Bookings());
    }
}
