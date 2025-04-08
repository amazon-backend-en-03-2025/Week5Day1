package com.ironhack.hellomoreweb.service;

import com.ironhack.hellomoreweb.dto.RobotMinimalRequest;
import com.ironhack.hellomoreweb.dto.UpdateNameDTO;
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


    public void deleteRobotById(int id){
        for (int i = 0; i < robotsStorage.size(); i++) {
            if (robotsStorage.get(i).getId().equals(id)) {
                robotsStorage.remove(i);
                break;
            }
        }
    }


    public Robot changeRobotName(int id, UpdateNameDTO updateNameDTO) {
        for(Robot robot : robotsStorage){
            if(robot.getId() == id){
                robot.setName(updateNameDTO.getNewName());
                return robot;
            }
        }
        return null;
    }

    public Robot updateRobot(int id, Robot robot) {
        if (robot.getId() != null && robot.getId() != id){
            return null;
        }

        for (Robot exisitingRobot: robotsStorage){
            if (exisitingRobot.getId() == id){
                exisitingRobot.setName(robot.getName());
                exisitingRobot.setModel(robot.getModel());
                exisitingRobot.setManufacturer(robot.getManufacturer());

                return exisitingRobot;
            }
        }
        return null;
    }
}
