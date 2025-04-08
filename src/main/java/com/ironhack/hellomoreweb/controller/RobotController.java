package com.ironhack.hellomoreweb.controller;

import com.ironhack.hellomoreweb.dto.RobotMinimalRequest;
import com.ironhack.hellomoreweb.model.Robot;
import com.ironhack.hellomoreweb.service.RobotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
    public Robot addRobot(@RequestBody RobotMinimalRequest robot){
        return robotService.addRobot(robot);
    }

    @PostMapping("/custom")
    @ResponseStatus(HttpStatus.CREATED)
    public Robot addCustomRobot(@RequestBody Robot robot){
        return robotService.addRobot(robot);
    }
}
