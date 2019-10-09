package com.devweb.rh.config;

import com.devweb.rh.model.Role;
import com.devweb.rh.model.RoleName;
import com.devweb.rh.model.User;
import com.devweb.rh.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
//creation et validation du token
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    @Value("${jwt.secret}")
    private String secret;
    private String token;

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    //retrieve roles from jwt token
    public String getRolesFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {

        //permet de retouner le role au niveau du token
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    //generate token for user

    public String generateToken(UserDetails userDetails) throws Exception {
        Claims claims = Jwts.claims().setAudience(String.valueOf(userDetails.getAuthorities()));
        //permet de retourner le role au niveau du token
        return doGenerateToken(claims, userDetails.getUsername());
    }
    @Autowired
    UserRepository userRepository;
    //while creating the token -
//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
//2. Sign the JWT using the HS512 algorithm and secret key.
//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
//   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) throws Exception {
        User user= userRepository.findByUsername(subject).orElseThrow();

        String auth = null;
        for (Role role: user.getRoles()
        ) {
            RoleName rien=role.getName();
            System.out.println(rien);
            auth=rien.name();
            //System.out.println(auth);

        }
        if (user.getStatut().equals("Bloquer")==true  )
        {
            throw  new Exception("Vous etes bloqué");
        }
        if (user.getAdmin()!=null && user.getAdmin().getStatut().equals("Bloquer")==true )
        {
            throw  new Exception("Votre entreprise est bloquer! Veuillez consulter votre administrateur");
        }

        if (user.getRoles().equals("ROLE_SUPERADMIN")){
            return "le Super administrateur ne peut pas être bloqué";
        }

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).claim("roles",auth)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}