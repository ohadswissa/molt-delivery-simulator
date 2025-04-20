public class MoltDriver implements Comparable <MoltDriver> {
    private int id;
    private String name;
    private int nextAvailableTimeForDelivery;
    private int TotalOrdersDelivered = 0;
    public MoltDriver (int id, String name, int nextAvailableTimeForDelivery)
    {
        this.id = id;
        this.name = name;
        this.nextAvailableTimeForDelivery = nextAvailableTimeForDelivery;
    }
    public void incrementTotalOrdersDelivered()
    {
        this.TotalOrdersDelivered++;
    }
    public int getNextAvailableTimeForDelivery()
    {
        return this.nextAvailableTimeForDelivery;
    }
    public void setNextAvailableTimeForDelivery(int time)
    {
        this.nextAvailableTimeForDelivery = time;
    }
    public String getName()
    {
        return this.name;
    }
    public String toString()
    {
        return this.id + ", " + this.name + ", " + this.nextAvailableTimeForDelivery;
    }
    public int compareTo(MoltDriver otherDriver)
    {
        if (this.nextAvailableTimeForDelivery > otherDriver.nextAvailableTimeForDelivery)
        {
            return 1;
        }
        if (this.nextAvailableTimeForDelivery < otherDriver.nextAvailableTimeForDelivery)
        {
            return -1;
        }
        return 0;

    }
   }

