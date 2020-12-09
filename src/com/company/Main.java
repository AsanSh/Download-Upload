package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(1);
        CountDownLatch cdl1 = new CountDownLatch(10);

        try{
            Upload upload = new Upload("Upload", 500, 20, cdl);
            upload.start();
            try {
                upload.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cdl.countDown();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Semaphore semaphore = new Semaphore(3);
            for (int i = 1; i < 11; i++) {
                Download download = new Download(semaphore, i, cdl1);
                download.start();
            }
            try {
                cdl1.await();
            } catch (InterruptedException e) {

            }
        } catch (Exception e){};

    }
}
