public class MoltOrder implements Comparable<MoltOrder> {
    private String name;
    private String orderDescription;
    private int orderReadyTime;
    private int timeNeedToDeliver;
    private int priority;
    public MoltOrder (String name, String orderDescription, int orderReadyTime, int timeNeededToDeliver , int priority)
    {
        this.name = name;
        this.orderDescription = orderDescription;
        this.orderReadyTime = orderReadyTime;
        this.timeNeedToDeliver = timeNeededToDeliver;
        this.priority = priority;
    }
    public String toString()
    {
        return name + ", " + orderDescription + ", " + orderReadyTime + ", " + timeNeedToDeliver + ", " + priority;
    }
    public int getOrderReadyTime()
    {
        return orderReadyTime;
    }
    public int getTimeNeededToDeliver()
    {
        return timeNeedToDeliver;
    }
    public String getName()
    {
        return name;
    }
    public String getOrderDescription()
    {
        return orderDescription;
    }
    public int compareTo(MoltOrder otherOrder)
    {
        if (this.priority < otherOrder.priority)
        {
            return -1;
        }
        if (this.priority > otherOrder.priority)
        {
            return 1;
        }
        return 0;
    }
}
