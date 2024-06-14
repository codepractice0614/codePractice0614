package little.dms.global.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import java.util.Base64;

@Getter
@Component
@AllArgsConstructor
public class JwtProperties {

    private final String secretKey = "asdsadasdassdsjdijsfhesfosdfuicsdfusddas";

    private final Long accessExp = 12200L;

    private final Long refreshExp = 1028230L;

    private final String header = "authorization";

    private final String prefix = "Bearer";

}
