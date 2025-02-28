package com.voting.votingapp.repository;

import com.voting.votingapp.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long> {

}
