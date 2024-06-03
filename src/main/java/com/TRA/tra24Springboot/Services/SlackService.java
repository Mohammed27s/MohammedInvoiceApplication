package com.TRA.tra24Springboot.Services;

import com.slack.api.Slack;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//This is slack service
@Service
public class SlackService {

@Value("${slack.integration.token}")
    private String slackToken;

/*
@Scheduled(cron = "* 0/5 * * * ?")
public void sendSchedueldMessageOnSlack(){

    String channel = "#random";
    String message = "Testing corn api";
    sendMessage(channel, message);
}
*/ //for safety reasons i stopped this corn api
  public void sendMessage(String channel, String message){
   Slack slack = Slack.getInstance();
   String token = slackToken; //Your Slack API token

      channel = "#random";
      message = "Testing corn api";

   ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel(channel).text(message).build();


   try {

       ChatPostMessageResponse response = slack.methods(token).chatPostMessage(request);
       if (response.isOk()) {
           System.out.println("Message sent successfully to Slack app!");
       } else {
           System.out.println("Failed to send message to Slack app: " + response.getError());
       }
   }catch (Exception e){
           System.out.println("Error sending message to Slack app: "+ e.getMessage());
       }


  }




}
