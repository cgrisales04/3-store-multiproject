package co.com.poli.bookingsservice.clientFeign;

import co.com.poli.bookingsservice.helpers.Response;
import co.com.poli.bookingsservice.helpers.ResponseBuild;
import co.com.poli.bookingsservice.persistence.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientImplHystrixFallback implements UserClient {
    private final ResponseBuild build;

    @Override
    public Response findById(Long id) {
        return build.success(new User());
    }
}
