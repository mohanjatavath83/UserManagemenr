package com.user.acko.controller;

import com.user.acko.model.Team;
import com.user.acko.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acko/team")
public class AckoController
{

    @Autowired
    RegistrationService registrationService;

    @PostMapping
    public void createTeam(@RequestBody Team team)
    {
        registrationService.createTeam(team);
    }

    @GetMapping
    public List<Team> getAllteam()
    {

       return registrationService.getTeamlist();

    }

    @GetMapping("/{teamID}")
    public Team getTeamByID(@PathVariable String teamID)
    {

        return registrationService.getTeamByID(teamID);

    }

}
