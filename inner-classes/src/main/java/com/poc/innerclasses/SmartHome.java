package com.poc.innerclasses;

public class SmartHome {
    private String owner = "Chandan";

    // 1. Member (non-static) inner class
    public class Light {
        public void turnOn() {
            System.out.println(owner + "'s lights are ON.");
        }
    }

    // 2. Static nested class
    public static class Thermostat {
        public void setTemperature(int degrees) {
            System.out.println("Thermostat set to " + degrees + "°C.");
        }
    }

    // Method using Local Inner Class
    public void securitySystem() {
        final String mode = "ARMED";

        // 3. Local inner class
        class Camera {
            public void activate() {
                System.out.println("Security camera activated. Mode: " + mode);
            }
        }

        Camera camera = new Camera();
        camera.activate();
    }

    // Method using Anonymous Inner Class
    public void scheduleTask() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Scheduled task is running...");
            }
        };

        // 4. Anonymous inner class used with Thread
        Thread thread = new Thread(task);
        thread.start();
    }

    // Main method to test everything
    public static void main(String[] args) {
        SmartHome home = new SmartHome();

        // Using member inner class
        SmartHome.Light light = home.new Light();
        light.turnOn();

        // Using static nested class
        SmartHome.Thermostat thermostat = new SmartHome.Thermostat();
        thermostat.setTemperature(22);

        // Using local inner class
        home.securitySystem();

        // Using anonymous inner class
        home.scheduleTask();
    }
}
