package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Services.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/slack") //This is the main directory for slack
public class SlackController {

    @Autowired
    SlackService slackService;


 //This is for getting input from user
    @GetMapping("messages") //This is slack message API
    public void sendMessage(@RequestParam String channel,
                            @RequestParam String message){
        slackService.sendMessage(channel, message); //get two parameters
    }
}
