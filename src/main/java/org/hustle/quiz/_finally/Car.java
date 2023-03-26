package org.hustle.quiz._finally;

/**
 * Ref: https://blogs.oracle.com/javamagazine/post/java-quiz-try-catch-finally-exception
 */
public class Car {
    public String checkBattery() throws BatteryException {
        throw new BatteryException();
    }

    public String checkFuel() throws FuelException {
        throw new FuelException();
    }

    public String start() {
        try {
            checkBattery();
            checkFuel();
        } catch (BatteryException | FuelException e) {
            return "Bad Battery";
        } finally {
            return "Finally";
        }
    }
}
