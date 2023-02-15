class FooBar {
    private int n;
    private boolean thread1; // prints foo
    
    public FooBar(int n) {
        this.n = n;
        thread1 = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this) {
                while (!thread1) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
        	    printFoo.run();
                thread1 = false;
                notify();
            }
        	
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this) {
                while (thread1) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run(); 
                thread1 = true;
                notify();
            }
        }
    }
}