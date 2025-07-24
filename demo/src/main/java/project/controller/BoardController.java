package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.entity.BoardEntity;
import project.service.BoardService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("boardList", boardService.findAll());
        return "board/list";
    }

    @GetMapping("/post")
    public String postForm() {
        return "board/post";
    }

    @PostMapping("/save")
    public String save(BoardEntity board) {
        boardService.save(board);
        return "redirect:/board";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardEntity board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, BoardEntity board) {
        boardService.update(id, board);
        return "redirect:/board";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/board";
    }

    @ResponseBody
    @GetMapping("/api")
    public List<BoardEntity> getAllJson() {
        return boardService.findAll();
    }

    @ResponseBody
    @GetMapping("/api/{id}")
    public BoardEntity getById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @ResponseBody
    @PostMapping("/api")
    public BoardEntity create(@RequestBody BoardEntity board) {
        return boardService.save(board);
    }

    @ResponseBody
    @PutMapping("/api/{id}")
    public BoardEntity updateJson(@PathVariable Long id, @RequestBody BoardEntity board) {
        return boardService.update(id, board);
    }

    @ResponseBody
    @DeleteMapping("/api/{id}")
    public void deleteJson(@PathVariable Long id) {
        boardService.delete(id);
    }
}



