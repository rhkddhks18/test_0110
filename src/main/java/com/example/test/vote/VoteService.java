package com.example.test.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    public void voteIncrease(Long voteId) {
        Optional<Vote> optionalVote = voteRepository.findById(voteId);
        if (optionalVote.isPresent()) {
            Vote vote = optionalVote.get();

            vote.increaseVoteCount();
            voteRepository.save(vote);
        } else {
            throw new IllegalArgumentException("투표를 찾을 수 없습니다. ID: " + voteId);
        }
    }
}
