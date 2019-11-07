package Utility;

import org.slf4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Util {
    public static void getDateDiff(Logger logger, Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        logger.info("Time of request in ms: " + timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS));
    }}
