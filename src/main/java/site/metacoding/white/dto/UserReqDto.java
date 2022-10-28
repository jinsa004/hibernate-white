package site.metacoding.white.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white.domain.User;

@Setter
@Getter
public class UserReqDto {

    @Setter
    @Getter
    public static class JoinReqDto { // 로그인 전 인증관련 로직들은 전부 다 앞에 엔티티 안붙임. ex)POST /user -> /join(규칙)
        private String username;
        private String password;

        // 요청의 DTO는 toEntity로 처리한다.(규칙)
        public User toEntity() {
            return User.builder().username(username).password(password).build();
        }
    }

    @Getter
    @Setter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @Getter
    @Setter
    public static class UserUpdateReqDto {
        private Long id;
        private String username;
        private String password;
    }
}