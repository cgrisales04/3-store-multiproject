package co.com.poli.bookingsservice.clientFeign;

import co.com.poli.bookingsservice.helpers.Response;
import co.com.poli.bookingsservice.helpers.ResponseBuild;
import co.com.poli.bookingsservice.persistence.entity.Movie;
import co.com.poli.bookingsservice.persistence.entity.Showtimes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowtimesClientImplHystrixFallback implements ShowtimesClient {
    private final ResponseBuild build;

    @Override
    public Response findById(Long id) {
        return build.success(new Showtimes());
    }
}
