package site.metacoding.white.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.Board;
import site.metacoding.white.domain.BoardRepository;
import site.metacoding.white.domain.Comment;
import site.metacoding.white.domain.CommentRepository;
import site.metacoding.white.dto.CommentReqDto.CommentSaveReqDto;
import site.metacoding.white.dto.CommentRespDto.CommentSaveRespDto;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentSaveRespDto save(CommentSaveReqDto commentSaveReqDto) { // 세션 값이 아닌 이상 영속화 후 진행해야함.
        // 1.Board가 있는지 확인
        Optional<Board> boardOP = boardRepository.findById(commentSaveReqDto.getBoardId());
        if (boardOP.isPresent()) {
            Comment comment = commentSaveReqDto.toEntity(boardOP.get());
            Comment commentPS = commentRepository.save(comment);
            CommentSaveRespDto commentSaveRespDto = new CommentSaveRespDto(commentPS);
            return commentSaveRespDto;
        } else {
            throw new RuntimeException("해당 게시글이 존재하지 않습니다.");
        }

        // 2.Comment 객체 만들기

    }

}
