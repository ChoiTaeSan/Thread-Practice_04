public class Main {
    public static void main(String[] args) {
//------------------------------------------------------ Flag
//        FlagThread printThread = new FlagThread();
//        printThread.start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }
//
//        printThread.setStop(true);
//------------------------------------------------------ Interrupt
        Thread thread = new InterruptThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        thread.interrupt();
    }
}

class FlagThread extends Thread{
    boolean stop; //초기화하면 디폴트 값은 False

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        while(!stop){
            System.out.println("Thread 실행 중");
        }
        System.out.println("Thread 자원 정리");
        System.out.println("Thread 실행 종료");
    }
}

class InterruptThread extends Thread{
    //------------------------------------------------------ sleep 사용
//    @Override
//    public void run() {
//        try {
//            while(true){
//                System.out.println("Thread 실행 중");
//                Thread.sleep(1);
//            }
//        } catch (InterruptedException e) {
//        }
//        System.out.println("Thread 자원 정리");
//        System.out.println("Thread 실행 종료");
//    }
//------------------------------------------------------ interrupt() 호출 확인 사용
    @Override
    public void run() {
        while(true){
            System.out.println("Thread 실행 중");
            if(Thread.interrupted()){
                break;
            }
        }
        System.out.println("Thread 자원 정리");
        System.out.println("Thread 실행 종료");
    }
}