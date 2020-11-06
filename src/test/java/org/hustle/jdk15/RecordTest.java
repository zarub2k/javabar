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
package org.hustle.jdk15;

import org.hustle.jdk15.record.Rectangle;
import org.hustle.jdk15.record.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.RecordComponent;
import java.util.Arrays;

/**
 * @author tham
 */
public class RecordTest {
    @Test
    public void testRecord() {
        Rectangle rectangle = new Rectangle(5.0, 7.0);
        System.out.println("Length " + rectangle.length());
        System.out.println("Width " + rectangle.width());
        System.out.println("toString() " + rectangle.toString());
        System.out.println("getClass() " + rectangle.getClass());
        System.out.println("getSuperClass() " + rectangle.getClass().getSuperclass());

        System.out.println("######## Record analysis");
        Class<? extends Rectangle> aClass = rectangle.getClass();
        System.out.println(aClass.isRecord());
        RecordComponent[] recordComponents = aClass.getRecordComponents();
        Arrays.stream(recordComponents).forEach(System.out::println);
    }

    @Test
    public void testRecordWithError() {
        Rectangle rectangle = new Rectangle(0.0, 7.0);
        System.out.println(rectangle.toString());
    }

    @Test
    public void testRecordMethod() {
        User userTham = new User("Tham", "Chennai", 42);
        System.out.println(userTham.name() + " can vote? " + userTham.canVote());

        User userChild = new User("Jane", "Chennai", 12);
        System.out.println(userChild.name() + " can vote? " + userChild.canVote());
    }
}
