/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hustle.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author tham
 *
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
public class LambdaExample {
    List<Person> persons = new ArrayList<>(8);
    {
        persons.add(new Person("Tham", 42));
        persons.add(new Person("Josh", 22));
        persons.add(new Person("Pollard", 7));
        persons.add(new Person("Kane", 50));
    }

    public void forEach() {
        List.of("Tham", "Josh", "Kane")
            .forEach(new EmailAppendConsumer());
    }

    public void filterByAge(int age) {
        List<String> filteredList = persons.stream()
                .filter(new PersonPredicate(age))
                .map(new EmailFunction())
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }

    public void averageAge() {
        double avgAge = persons.stream()
                .mapToInt(Person::age)
                .average()
                .getAsDouble();
        System.out.println("Average age: " + avgAge);
    }

    //Consumer to make changes made by Function (.forEach)
    static class EmailAppendConsumer implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s + ">H");
        }
    }

    //Mapper to map - Function (.map)
    static class EmailFunction implements Function<Person, String> {

        @Override
        public String apply(Person person) {
            return person.name();
        }
    }

    //Predicate to (.filter)
    static class PersonPredicate implements Predicate<Person> {
        int age;
        PersonPredicate(int age) {
            this.age = age;
        }

        @Override
        public boolean test(Person person) {
            return person.age() > age;
        }
    }
}
