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
package org.hustle.core;

import org.hustle.core.lang.ChildThread;
import org.junit.jupiter.api.Test;

/**
 * @author tham
 */
public class ThreadTest {
    @Test
    public void testRunnable() {
        int count = 5;
        ChildThread child = new ChildThread(count);
        Thread thread = new Thread(child, "Child Thread");
        thread.start();
        System.out.println(thread.getName());
        try {
            thread.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error in Main thread");
            }
        }
    }
}
