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
package org.hustle.jdk15.record;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tham
 *
 * Example for local Record class
 */

record Merchant(String name) {}
record Sale(Merchant merchant, LocalDate date, double value) {}

public class LocalRecordExample {
    List<Merchant> topMerchants(List<Sale> sales, List<Merchant> merchants,
                                int year, Month month) {
        record MerchantSale(Merchant merchant, double sales) {}
        return merchants.stream()
            .map(merchant -> new MerchantSale(merchant,
                    totalSales(sales, merchant, year, month)))
            .sorted(Comparator.comparingDouble(m -> m.sales))
            .map(MerchantSale::merchant)
            .collect(Collectors.toList());
    }

    double totalSales(List<Sale> sales, Merchant merchant, int year, Month month) {
        return sales.stream()
                .filter(sale -> sale.merchant().name().equals(merchant.name()) &&
                        sale.date().getYear() == year &&
                        sale.date().getMonth() == month)
                .mapToDouble(Sale::value)
                .sum();
    }

    public List<String> report(int year, Month month) {
        Merchant tham = merchant("Tham");
        Merchant jane = merchant("Jane");
        Merchant josh = merchant("Josh");
        List<Merchant> merchants = List.of(tham, jane, josh);

        List<Sale> sales = List.of(
                sale(tham, LocalDate.of(2020, Month.NOVEMBER, 15),
                        1000.0),
                sale(tham, LocalDate.of(2020, Month.AUGUST, 10),
                        1500.0),

                sale(jane, LocalDate.of(2020, Month.NOVEMBER, 20),
                        2500.5),
                sale(jane, LocalDate.of(2020, Month.AUGUST, 20),
                        1500.5),

                sale(josh, LocalDate.of(2020, Month.NOVEMBER, 11),
                        2500.2),
                sale(josh, LocalDate.of(2020, Month.MARCH, 11),
                        5500.2)
        );

        List<Merchant> topMerchants = topMerchants(sales, merchants, year, month);
        return topMerchants.stream()
                .map(Merchant::name)
                .collect(Collectors.toList());
    }

    private Sale sale(Merchant merchant, LocalDate date, double value) {
        return new Sale(merchant, date, value);
    }

    private Merchant merchant(String name) {
        return new Merchant(name);
    }
}
