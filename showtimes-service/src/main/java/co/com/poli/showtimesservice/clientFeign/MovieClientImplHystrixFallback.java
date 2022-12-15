package co.com.poli.showtimesservice.clientFeign;

import co.com.poli.showtimesservice.helpers.Response;
import co.com.poli.showtimesservice.helpers.ResponseBuild;
import co.com.poli.showtimesservice.persistence.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientImplHystrixFallback implements MoviesClient {

    private final ResponseBuild build;

    @Override
    public Response findById(Long id) {
        return build.success(new Movie());
    }
}
