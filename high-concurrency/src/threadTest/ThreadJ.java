package threadTest;


public class ThreadJ extends Thread{
    private NextOpt nextOpt;
    private Integer index;

    @Override
    public void run() {
        while(nextOpt.getNextValue()<100){
            synchronized (nextOpt){
                while ((nextOpt.getNextValue()&1)!=index){
                    try {
                        nextOpt.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("index:"+index+",value:"+nextOpt.getNextValue());
                nextOpt.setNextValue(nextOpt.getNextValue()+1);
                nextOpt.notifyAll();
            }
        }
    }

    public NextOpt getNextOpt() {
        return nextOpt;
    }

    public void setNextOpt(NextOpt nextOpt) {
        this.nextOpt = nextOpt;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public ThreadJ(NextOpt nextOpt,Integer index){
        this.nextOpt=nextOpt;
        this.index=index;
    }
}
