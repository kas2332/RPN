public class Stopwatch {
    //attribute to hold start time, used to calculate time elapsed
    private final long startTime;

    //sets the start time to the millisecond
    public Stopwatch() {
        this.startTime = System.currentTimeMillis();
    }

    //returns seconds between calling this function and creating the object
    public double elapsedTime() {
        final long now = System.currentTimeMillis();
        return (double) (now - this.startTime) / 1000;
    }
}
