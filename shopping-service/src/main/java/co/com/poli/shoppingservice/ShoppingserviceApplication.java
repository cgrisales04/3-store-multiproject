package co.com.poli.shoppingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ShoppingserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingserviceApplication.class, args);
    }

}
