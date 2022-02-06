package com.user.acko.job;

import com.user.acko.model.Developer;
import com.user.acko.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Notification {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DeveloperRepository developerRepository;

   // @Scheduled(fixedRate = 10000)
    public void cronJobSch() throws Exception
    {

        List<Developer> developerList = (List<Developer>) developerRepository.findAll();
        for (Developer developer : developerList)
        {
            String message = "welcome ";
            System.out.println(message + developer.getUid());
        }


    }
}


