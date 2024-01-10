package com.example.test.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;
    @GetMapping("/vote")
    public String vote() {
        return"vote";
    }

    @PostMapping("/vote/{voteId}")
    @ResponseBody
    public void vote(@PathVariable("voteId") Long voteId) {
        voteService.voteIncrease(voteId);
    }
}
