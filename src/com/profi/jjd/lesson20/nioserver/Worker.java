package com.profi.jjd.lesson20.nioserver;

public abstract class Worker implements Runnable {
    @Override
    public void run(){
        try {
            init();
            while (!isInterrupted()){
                loop();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                stop();
            } catch (Exception ignored) { }
        }
    }

    protected void init() throws Exception{}

    protected void stop() throws Exception{}

    protected void loop() throws Exception{}

    protected boolean isInterrupted(){
        return Thread.currentThread().isInterrupted();
    }
}