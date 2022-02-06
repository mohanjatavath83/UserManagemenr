package com.user.acko.service;

import com.user.acko.model.Team;

import java.util.List;

public interface RegistrationService {

    void createTeam(Team team);

    List<Team> getTeamlist();

    Team getTeamByID(String teamID);

}
