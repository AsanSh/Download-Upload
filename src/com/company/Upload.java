package com.company;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class Upload extends Thread{
    private int size;
    private int mb;
    private CountDownLatch cdl;

    public Upload(String name, int size, int mb, CountDownLatch cdl) {
        super(name);
        this.size = size;
        this.mb = mb;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
        for (int i = 0; i < 100; i++) {
            size = size - 20;
            mb = mb+20;
            System.out.println("Загрузка на сервер "+i);
                sleep(100);}
            System.out.println("Загрузка завершена");
        sleep(1000);
            for (int i = 0; i < 10; i++) {
                System.out.println("Подготовка файла для загрузки"+i);
                sleep(300);
            }
            System.out.println("Подготовка завершена");
            sleep(1000);
            } catch (InterruptedException e) {

            }

        }
    }

