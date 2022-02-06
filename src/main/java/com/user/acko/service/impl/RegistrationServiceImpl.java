package com.user.acko.service.impl;

import com.user.acko.model.Developer;
import com.user.acko.model.Team;
import com.user.acko.repository.TeamRepository;
import com.user.acko.service.RegistrationService;
import com.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    TeamRepository teamRepository;

    public void createTeam(Team team)
    {
        /*Optional<Team> existingTeam = teamRepository.findById(team.getTeamID());
        if (!existinTeam.isPresent()) {
            throw new ResourceNotFoundException("team not found with id = " + team.getTeamID());
        }*/



        teamRepository.save(team);
    }

    public List<Team> getTeamlist() {
        return (List<Team>) teamRepository.findAll();

    }

    public Team getTeamByID(String teamID)
    {
        Optional<Team> team = teamRepository.findById(teamID);
        if (!team.isPresent()) {
            throw new ResourceNotFoundException("team not found with id = " + teamID);
        }

        return team.get();
    }

}
