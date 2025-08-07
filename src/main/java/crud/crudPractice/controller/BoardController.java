package crud.crudPractice.controller;


import crud.crudPractice.entity.BoardEntity;
import crud.crudPractice.service.BoardService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //메인화면
    @GetMapping("/board/index")
    public String boardMainForm() {

        return "index";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(BoardEntity boardEntity) {

        boardService.boardWrite(boardEntity);

        return "";
    }
//리스트
    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }
//상세 페이지
    @GetMapping("/board/view")
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardView";
    }

//삭제
    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardModify";
    }

    //수정
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, BoardEntity boardEntity) {
        BoardEntity boardTemp = boardService.boardView(id);
        boardTemp.setTitle(boardEntity.getTitle());
        boardTemp.setContent(boardEntity.getContent());

        boardService.boardWrite(boardTemp);

        return "redirect:/board/list";
    }


}
