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
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author tham
 */
public class LambdaExample {
    List<Person> persons = new ArrayList<>(8);
    {
        System.out.println("Called");
        persons.add(new Person("Tham", 42));
        persons.add(new Person("Josh", 22));
        persons.add(new Person("Pollard", 7));
        persons.add(new Person("Kane", 50));
    }

    public void filterByAge(int age) {
        List<Person> filteredList = persons.stream()
                .filter(new PersonPredicate(age))
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }

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
