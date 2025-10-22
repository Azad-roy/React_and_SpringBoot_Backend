package com.example.fullyUseOfRepository.controller;

import com.example.fullyUseOfRepository.models.Team;
import com.example.fullyUseOfRepository.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
//@CrossOrigin(origins = "http://localhost:5173") // FOr local
@CrossOrigin(origins = "https://cricket-score-manager.netlify.app/") // For production
public class TeamController {

    @Autowired
    private TeamService teamService;


//    @GetMapping
//    public List<Team> getAllTeams(){
//        return teamService.getAllTeam();
//    }

    @GetMapping
    public Page<Team> getAllTeams(@RequestParam int pageNum, int pageSize){
        return teamService.getAllTeam(pageNum,pageSize);
    }


    @PostMapping
    public Team addTeam(@RequestBody Team team){
        return teamService.addTeam(team);
    }

    @GetMapping("/{name}")
    public Team getTeamByName(@PathVariable String name){
        return teamService.getTeamByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable String id){
        teamService.deleteTeam(id);
    }
}

//package com.example.fullyUseOfRepository.controller;
//
//import com.example.fullyUseOfRepository.models.Team;
//import com.example.fullyUseOfRepository.service.TeamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//
//@RestController
//@RequestMapping("/team")
//@CrossOrigin(origins = "*") // allow frontend at localhost:63342
//public class TeamController {
//
//    @Autowired
//    private TeamService teamService;
//
//    // GET http://localhost:8080/team
//    @GetMapping
//    public List<Team> getAllTeams() {
//        return teamService.getAllTeam();
//    }
//
//    // POST http://localhost:8080/team
//    @PostMapping
//    public Team addTeam(@RequestBody Team team) {
//        return teamService.addTeam(team);
//    }
//
//    // GET http://localhost:8080/team/{name}
//    @GetMapping("/{name}")
//    public Team getTeamByName(@PathVariable String name) {
//        return teamService.getTeamByName(name);
//    }
//}
