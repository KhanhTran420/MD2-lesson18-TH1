public class RunnableDemo implements Runnable {
    private Thread t;
    private final String threadName;

    RunnableDemo(String name){
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run(){
        System.out.println("Running " + threadName);
        try{
            for (int i = 4; i > 0 ; i--) {
                System.out.println("Thread: " + threadName + "," + i);
                // Dừng vòng lập trong 50s
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Threat " + threadName + " interrupted.");
        }
        System.out.println("Threat " + threadName + "exiting.");
    }

    public void start(){
        System.out.println("Staring" + threadName);
        if(t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}
