package library;

public class MySemaphore {
        private int initialValue = 0;
        private int bound = 0;

        public MySemaphore(int initialValue,int upperBound){
            this.bound = upperBound;
            this.initialValue = initialValue;
        }


        public synchronized void release(boolean isReader) throws InterruptedException{
            while(this.initialValue == bound){
                wait();
            }
            this.initialValue = isReader ? initialValue+5 : initialValue+1;
            this.notify();
        }

        public synchronized void acquire(boolean isReader) throws InterruptedException{
            while(this.initialValue == 0){
                wait();
            }
            this.initialValue = isReader ? initialValue-5 : initialValue-1;
            this.notify();
        }
}
