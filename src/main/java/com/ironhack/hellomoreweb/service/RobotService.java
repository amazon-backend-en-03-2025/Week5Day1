package com.ironhack.hellomoreweb.service;

import com.ironhack.hellomoreweb.dto.RobotMinimalRequest;
import com.ironhack.hellomoreweb.model.Robot;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotService {

    private List<Robot> robotsStorage ;

    private static int currentId = 1;

    @PostConstruct
    private void initStorage() {
        robotsStorage = new ArrayList<>(
                List.of(
                        new Robot(currentId++, "Robo1", "Pioneer"),
                        new Robot(currentId++, "Robo1", "Asimo"),
                        new Robot(currentId++, "RoboX", "Atlas")
                )
        );
    }


    public List<Robot> getRobots() {
        return robotsStorage;
    }

    public Robot getRobotById(Integer id){
        for (Robot robot : robotsStorage) {
            if (robot.getId().equals(id)) {
                return robot;
            }
        }
        return null;
    }



    public Robot addRobot(Robot robot){
        Robot robotToAdd = new Robot(currentId++, robot.getModel(), robot.getName());
        robotsStorage.add(robotToAdd);
        return robotToAdd;
    }

    public Robot addRobot(RobotMinimalRequest robotMinimalRequest){
        Robot robotToAdd = new Robot(currentId++, robotMinimalRequest.getModel(), robotMinimalRequest.getName());
        robotsStorage.add(robotToAdd);
        return robotToAdd;
    }
}
