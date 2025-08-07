package crud.crudPractice.service;

import crud.crudPractice.entity.BoardEntity;
import crud.crudPractice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    //자동으로 연결
    @Autowired
    private BoardRepository boardRepository;

    //글 작성
    public void boardWrite(BoardEntity boardEntity) {

        boardRepository.save(boardEntity);

    }

    //게시글 리스트 처리
    public List<BoardEntity> boardList() {
        return boardRepository.findAll();
    }

    //특정 게시글 불러오기
    public BoardEntity boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }
}
