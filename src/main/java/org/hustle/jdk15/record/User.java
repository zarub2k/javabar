package org.hustle.jdk15.record;

/**
 * @author tham
 */
public record User(String name, String city, int age) {
//    private static int age;
    public boolean canVote() {
        return age > 17;
    }
}
