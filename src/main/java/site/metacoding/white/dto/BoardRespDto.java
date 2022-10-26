package site.metacoding.white.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white.domain.Board;
import site.metacoding.white.domain.User;

public class BoardRespDto {

    @Getter
    @Setter
    public static class BoardSaveRespDto {
        private Long id;
        private String title;
        private String content;
        private UserDto user;

        @Getter
        @Setter
        public static class UserDto {
            private Long id;
            private String username;

            public UserDto(User user) {
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

        public BoardSaveRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = new UserDto(board.getUser());
        }

        // 메소드를 만들면 한번에 끝나게 해결해보기
    }

    @Getter
    @Setter
    public static class BoardDetailRespDto {
        private Long id;
        private String title;
        private String content;
        private UserDto user;

        @Getter
        @Setter
        public static class UserDto {
            private Long id;
            private String username;

            public UserDto(User user) { // LAZY 로딩이 지금 실행됨
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

        public BoardDetailRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = new UserDto(board.getUser());
        }

        // 메소드를 만들면 한번에 끝나게 해결해보기
    }

    @Getter
    @Setter
    public static class BoardAllRespDto {
        private Long id;
        private String title;
        private String content;
        private UserDto user;

        @Getter
        @Setter
        public static class UserDto {
            private Long id;
            private String username;

            public UserDto(User user) { // LAZY 로딩이 지금 실행됨
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

        public BoardAllRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = new UserDto(board.getUser());
        }
    }
}