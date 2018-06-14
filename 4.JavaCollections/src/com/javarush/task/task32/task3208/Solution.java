package com.javarush.task.task32.task3208;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Remote stubCat = null;
                Remote stubDog = null;
                Cat cat = new Cat("Kitty");
                Dog dog = new Dog("Barky");
                registry = LocateRegistry.createRegistry(2099);
                stubCat = UnicastRemoteObject.exportObject(cat, 0);
                registry.bind(cat.getClass().getName(), stubCat);
                stubDog = UnicastRemoteObject.exportObject(dog, 0);
                registry.bind(dog.getClass().getName(), stubDog);

                Thread.sleep(1500);

                UnicastRemoteObject.unexportObject(cat, false);
                UnicastRemoteObject.unexportObject(dog, false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}