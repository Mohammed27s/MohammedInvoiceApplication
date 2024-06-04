package com.TRA.tra24Springboot.Services;


import com.slack.api.Slack;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SlackService {
    @Value("${slack.integration.token}") //This is storing the token value
    private String slackToken;
    //slack.integration.token= This is token

    /*@Scheduled(cron = "* 0/1 * * * ?") //this is corn API used for Scheduling alert. by sending alert to slack app
    //For safety reason i comment this code
    public void sendSchedueldMessageOnSlack(){
        String channel = "#random";
        String message = "Testing corn";
        sendMessage(channel, message);
    }
                                           */ //This stopped

    public void sendMessage(String channel, String message){
        Slack slack = Slack.getInstance();
        String token = slackToken; //This is slack API




        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(message)
                .build();


        try {
            ChatPostMessageResponse response = slack.methods(token).chatPostMessage(request);
           if(response.isOk()){
               System.out.println("Slack Working");
           }
           else {
               System.out.println("Failed to send message to Slack!: "+response.getError());
           }
        } catch (Exception e){
            System.out.println("Error sending message to Slack: "+e.getMessage());
        }


    }


}
