package pl.beda.UserAuthenticationSystem.component;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomTaskScheduler {

//    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedDelay = 5000)
      // second, minute, hour, day of the month, month, day of the week
//    @Scheduled(cron = "${cron.expression}")
    public void doSomeStuff() {
        System.out.println("some operation, time: " + LocalTime.now());
    }
}
