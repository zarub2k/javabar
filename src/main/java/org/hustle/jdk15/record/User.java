package org.hustle.jdk15.record;

/**
 * @author tham
 */
public record User(String name, String city) {
    private static int age;
}
