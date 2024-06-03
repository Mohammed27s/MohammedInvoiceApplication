package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Services.SlackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("slack") //This is the main directory for slack api
public class SlackController {

    @Autowired
    SlackService slackService;

   // @Scheduled(cron = "* * * * * *") //This is scheduling slack alert every minute, hour, day of month,
   // month and day of week
    @GetMapping("messages") //This is the main directory for slack api
    public void sendMessage(@RequestParam String channel, @RequestParam String message){
        slackService.sendMessage(channel, message);
    }

}
