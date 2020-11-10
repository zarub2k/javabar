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
package org.hustle.jdk15.instance;

/**
 * @author tham
 */
public class InstanceOfExample {
    public static void instanceofWithOld(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle)shape;
            System.out.println("Circle: " + circle.radius());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle)shape;
            System.out.println("Rectangle: " + rectangle.length() +
                    ", " + rectangle.width());
        } else {
            System.out.println("Given shape is not found");
        }
    }

    public static void instanceofWithNew(Shape shape) {
        if (shape instanceof Circle circle) {
            System.out.println("Circle: " + circle.radius());
        } else if (shape instanceof Rectangle rectangle) {
            System.out.println("Rectangle: " + rectangle.length() +
                    ", " + rectangle.width());
        }
    }
}

interface Shape {}

