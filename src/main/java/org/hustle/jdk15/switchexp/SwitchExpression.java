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
package org.hustle.jdk15.switchexp;

/**
 * @author tham
 */
public class SwitchExpression {
    public enum Day {
        SUN, MON, TUE, WED, THU, FRI, SAT
    }

    public String switchOld(Day day) {
        String value;
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                value = "Working day";
                break;
            case SAT:
            case SUN:
                value = "Weekend day";
                break;
            default:
                value = "Enter a valid day";
                break;
        }

        return value;
    }

    public String switchNew(Day day) {
        switch (day) {
            case SAT, SUN -> {
                return "Weekend day";
            }
            case MON, TUE, WED, THU, FRI -> {
                return "Working day";
            }
            default -> throw new IllegalStateException("Not a valid day");
        }
    }

    public String switchNewWithAssign(Day day) {
        String value;
        switch (day) {
            case SAT, SUN -> value = "Weekend day";
            case MON, TUE, WED, THU, FRI -> value = "Working day";
            default -> throw new IllegalStateException("Not a valid day");
        }

        return value;
    }

    public String switchNewWithYield(Day day) {
        return switch (day) {
            case SAT, SUN -> {
                System.out.println("Enters weekend");
                yield "Weekend day";
            }
            case MON, TUE, WED, THU, FRI -> {
                System.out.println("Enters working day");
                yield "Working day";
            }
        };
    }
}
