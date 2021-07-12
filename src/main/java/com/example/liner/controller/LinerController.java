package com.example.liner.controller;

import com.example.liner.domain.HighlightVO;
import com.example.liner.domain.MyPageHighlightVO;
import com.example.liner.domain.UserTheme;
import com.example.liner.domain.UserThemeVO;
import com.example.liner.service.LinerService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liner")
public class LinerController {

    @Autowired
    private LinerService linerService;


    @GetMapping("")
    public ResponseEntity<?> getHelloWorld() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/my-highlight")
    public ResponseEntity<?> getMyHighlight(@RequestBody HighlightVO highlightVO) {
        List<HighlightVO> result = linerService.selectMyHighlight(highlightVO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/mypage-highlight")
    public ResponseEntity<?> getMyPageHighlight(@RequestBody HighlightVO highlightVO) {
        List<MyPageHighlightVO> result = linerService.selectMyPageHighlight(highlightVO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/highlight")
    public ResponseEntity<?> addHilight(@RequestBody HighlightVO highlightVO) {
        HighlightVO vo = linerService.addHighlight(highlightVO);
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

    @PutMapping("/highlight")
    public ResponseEntity<?> updateHilight(@RequestBody HighlightVO highlightVO) {
        HighlightVO result = linerService.updateHighlight(highlightVO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/highlight")
    public ResponseEntity<?> deleteHighlight(@RequestBody HighlightVO highlightVO) {
        linerService.deleteHighlight(highlightVO);

        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }

    @PutMapping("/my-theme")
    public ResponseEntity<?> updateMyTheme(@RequestBody HighlightVO highlightVO) {
        linerService.updateMyTheme(highlightVO);
        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }

    @PutMapping("/my-theme-color")
    public ResponseEntity<?> updateMyThemeColor(@RequestBody UserThemeVO param) {
        linerService.updateMyThemeColor(param);
        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }

    @DeleteMapping("/my-theme")
    public ResponseEntity<?> deleteMyTheme(@RequestBody HighlightVO highlightVO) {
        linerService.deleteMyTheme(highlightVO);

        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }
}
