package little.dms.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import little.dms.global.exception.ExpiredTokenException;
import little.dms.global.exception.InvalidTokenException;
import little.dms.global.security.TokenResponse;
import little.dms.global.security.auth.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class JwtReissueUtil {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    private String getId(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private boolean isRefreshToken(String token) {
        return getClaims(token).get("type").equals("refresh");
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

}
