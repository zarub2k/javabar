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

/**
 * Text block examples
 * @author tham
 *
 * https://docs.oracle.com/en/java/javase/15/text-blocks/index.html
 */
public class TextBlock {
    public void checkEq() {
        String value = "Thamizharasu";
        String textBlock = """
                       Thamizharasu""";

        System.out.println("Is equal: " + value.equals(textBlock));
    }

    public void checkJson() {
        String json = """
                {
                    "name": "Tham",
                    "city": "Chennai"
                }
                """;

        System.out.println(json);
    }

    public void subString() {
        String name = """
                What is your name?
                My name is 'Tham'
                """;

        System.out.println("Substring: " + name.substring(0, 18));
    }
}
