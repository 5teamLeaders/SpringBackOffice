package com.example.springbackoffice.jwt;

import com.example.springbackoffice.dto.ApiResponseDto;
import com.example.springbackoffice.security.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j(topic = "JWT 검증 및 인가")
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final ObjectMapper objectMapper;

    public JwtAuthorizationFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService, ObjectMapper objectMapper) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.objectMapper = objectMapper;
    }

    // 로그인 토큰 없이 시도 시 로그인 안내 메서드
    // 요청을 필터링하고 JWT 유효성 검사 매서드 ( 토큰의 존재여부, 유효성검사, 블랙리스트 확인을 수행)
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String tokenValue = jwtUtil.getJwtFromHeader(req);

        if (StringUtils.hasText(tokenValue)) {
            if(!jwtUtil.validateToken(tokenValue)) {
                ApiResponseDto responseDto = new ApiResponseDto(HttpStatus.BAD_REQUEST.value(), "토큰이 유효하지 않습니다.");
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.setContentType("application/json; charset=UTF-8");
                res.getWriter().write(objectMapper.writeValueAsString(responseDto));

                return;
            }
            Claims info = jwtUtil.getUserInfoFromToken(tokenValue);
            setAuthentication(info.getSubject());
        }

        filterChain.doFilter(req, res);
    }

    // 인증 처리 : 인증 정보를 SecurityContextHolder 에 설정하는 메서드
    // Spring Security 는 인증(Authentication)과 인가(Authorization)를 처리하기 위해 보안 컨텍스트를 사용함
    public void setAuthentication(String username) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication = createAuthentication(username);
        context.setAuthentication(authentication);
        // username -> user 조회 -> userDetails 에 담고 -> authentication의 principal 에 담고
        // -> securityContent 에 담고 -> SecurityContextHolder 에 담고
        // -> 이제 @AuthenticationPrincipal 로 조회할 수 있음
        SecurityContextHolder.setContext(context);
    }

    // 인증 객체 생성 : UserDetailsServiceImpl 을 사용하여 사용자 정보를 조회하고, UsernamePasswordAuthenticationToken을 생성하여 인증에 사용
    private Authentication createAuthentication(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}
