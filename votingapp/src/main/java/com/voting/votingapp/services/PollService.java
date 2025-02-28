package com.voting.votingapp.services;

import com.voting.votingapp.models.OptionVote;
import com.voting.votingapp.models.Poll;
import com.voting.votingapp.repository.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }


    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public Optional<Poll> getpollbyId(Long id) {

        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        // Get Poll from DB
        Poll poll=pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));
        // Get All Options

        List<OptionVote> options=poll.getOptions();
        // If index for is not valid,throw error
        if(optionIndex <0 || optionIndex>=options.size()){
            throw new IllegalArgumentException("Invalid option index");
        }
        // Get Selected Option
        OptionVote selectedOption=options.get(optionIndex);
        // Increment vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);
        // save the incremented vote option into the db
        pollRepository.save(poll);


    }
}
