package com.example.fullyUseOfRepository.service;

import com.example.fullyUseOfRepository.models.Team;
import com.example.fullyUseOfRepository.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

//    public List<Team> getAllTeam(){
//        Sort sort = Sort.by("score").descending();
//        return teamRepository.findAll(sort);
//    }


    public Page<Team> getAllTeam(int pageNum, int pageSize ){
        Sort sort = Sort.by("score").descending();
        Pageable pageable = PageRequest.of(pageNum,pageSize).withSort(sort);
        return teamRepository.findAll(pageable);
    }

    public Team addTeam(Team team){
        return teamRepository.save(team);
    }

    public Team getTeamByName(String name){
        return teamRepository.findByName(name);
    }

    public void deleteTeam(String id){
        teamRepository.deleteById(id);
    }

}
