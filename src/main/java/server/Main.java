package server;

import domain.status.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Main method started in class Main");
        System.out.println("Hello World");
        Status backlog = new Status();
        Status open = new Status();
        Status inProgress = new Status();
        Status done = new Status();
    }
}
