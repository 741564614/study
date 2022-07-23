package threadTest;

public class main {
    public static void main(String[] args) {
        ThreadJAlternatePrint();
    }

    /**
     * 线程交替打印
     */
    public static void ThreadJAlternatePrint(){
        NextOpt n=new NextOpt(0);
        ThreadJ j0=new ThreadJ(n,0);
        ThreadJ j1=new ThreadJ(n,1);
        j0.start();
        j1.start();
        return;
    }
}
