package site.metacoding.white.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.Board;
import site.metacoding.white.domain.BoardRepository;
import site.metacoding.white.dto.BoardReqDto.BoardSaveReqDto;
import site.metacoding.white.dto.BoardRespDto.BoardAllRespDto;
import site.metacoding.white.dto.BoardRespDto.BoardDetailRespDto;
import site.metacoding.white.dto.BoardRespDto.BoardSaveRespDto;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveRespDto save(BoardSaveReqDto boardSaveReqDto) {
        // 핵심 로직
        Board boardPS = boardRepository.save(boardSaveReqDto.toEntity());

        // DTO 전환
        BoardSaveRespDto boardSaveRespDto = new BoardSaveRespDto(boardPS);

        return boardSaveRespDto;
    }

    @Transactional(readOnly = true)
    public BoardDetailRespDto findById(Long id) {
        // Board boardPS = boardRepository.findById(id).orElseThrow(() -> {
        // new RuntimeException("해당" + id + "로 상세보기를 할 수 없습니다.");
        // });
        Optional<Board> boardOP = boardRepository.findById(id);
        if (boardOP.isPresent()) {
            BoardDetailRespDto boardDetailRespDto = new BoardDetailRespDto(boardOP.get());
            return boardDetailRespDto;
        } else {
            throw new RuntimeException("해당" + id + "로 상세보기를 할 수 없습니다.");
        }
    }

    @Transactional
    public void update(Long id, Board board) {
        Optional<Board> boardOP = boardRepository.findById(id);
        if (boardOP.isPresent()) {
            boardOP.get().update(board.getTitle(), board.getContent());
        } else {
            throw new RuntimeException("해당" + id + "로 업데이트를 할 수 없습니다.");
        }
        // 트랜젝션 종료시 자동으로 flush 되서 업데이트가 됨.
    }

    @Transactional(readOnly = true)
    public List<BoardAllRespDto> findAll() {
        List<Board> boardList = boardRepository.findAll();
        // 1.Board - > DTO로 옮겨야함
        List<BoardAllRespDto> boardAllRespDtoList = new ArrayList<>();
        // 2.List의 크기만큼 for문 돌리기
        for (Board board : boardList) {
            // 3.DTO를 LIST에 담기
            boardAllRespDtoList.add(new BoardAllRespDto(board));
        }
        return boardAllRespDtoList;
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
