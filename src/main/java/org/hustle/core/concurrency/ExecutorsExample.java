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
package org.hustle.core.concurrency;

import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.HOURS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author tham
 */
public class ExecutorsExample {
    public void threadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<JavabarCallable> callables = List.of(
            new JavabarCallable("First"),
            new JavabarCallable("Second")
        );
        try {
            List<Future<String>> futures = executorService.invokeAll(callables);
            System.out.println("Before get()");
            futures.forEach(stringFuture ->
            {
                try {
                    String value = stringFuture.get();
                    System.out.println(value);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public void scheduledThreadPool() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
//        System.out.println("Before one shot schedule");
//        service.schedule(new SimpleCallable(), 5, SECONDS);

        System.out.println("Before fixed rate");

        Runnable beeper = () -> System.out.println("Beeper");
        ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        Runnable canceller = () -> scheduledFuture.cancel(false);
        service.schedule(canceller, 1, HOURS);

//        service.shutdown();
    }
}
