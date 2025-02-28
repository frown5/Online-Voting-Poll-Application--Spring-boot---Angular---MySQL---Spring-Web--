package com.voting.votingapp.models;


//this entity is made so that we can connect the votes to the options

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote {

    private String optionText;
    private Long voteCount=0L;
}
