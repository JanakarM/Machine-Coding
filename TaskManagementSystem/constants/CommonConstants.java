package design_1.constants;

import java.util.concurrent.atomic.AtomicInteger;

public class CommonConstants {
    protected static final AtomicInteger userIds = new AtomicInteger(0);
    protected static final AtomicInteger taskIds = new AtomicInteger(0);
    protected static final int noOfTasksPerSalesMan=5;
    public static final Long incentiveAmount=1000L;
}
