package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Download extends Thread {
    private Semaphore semaphore;
    private int mb = 0;
    private CountDownLatch cdl1;
    private int id;

    public Download(Semaphore semaphore, int mb, CountDownLatch cdl1) {
        this.semaphore = semaphore;
        this.mb = mb;
        this.cdl1 = cdl1;

    }

    @Override
    public void run() {

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName()+" загрузка разрешена");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
                mb = mb +100;
                System.out.println("Downloader "+i+ " загрузил " + mb + " mb");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } semaphore.release();
            cdl1.countDown();
        }
    }

