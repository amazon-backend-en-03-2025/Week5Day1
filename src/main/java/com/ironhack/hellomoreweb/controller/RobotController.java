package com.ironhack.hellomoreweb.controller;

import com.ironhack.hellomoreweb.model.Robot;
import com.ironhack.hellomoreweb.service.RobotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/robots")
public class RobotController {

    private final RobotService robotService;


    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }


    @GetMapping
    public List<Robot> getRobots() {
        return robotService.getRobots();
    }

    @GetMapping("/{id}")
    public Robot getRobotById(@PathVariable int id) {
        return robotService.getRobotById(id);
    }
}
