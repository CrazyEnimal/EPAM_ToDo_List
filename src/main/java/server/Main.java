package server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Main method started");
        System.out.println("Hello World");
    }
}
