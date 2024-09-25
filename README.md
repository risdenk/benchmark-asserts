
# benchmark-asserts

## Running
```
mvn clean package && java -jar target/benchmarks.jar -prof jfr
```

## Results
```
Benchmark                                                        Mode  Cnt     Score     Error  Units
MyBenchmark.testLongStringMessageAssert                         thrpt    3  2569.295 ± 275.315  ops/s
MyBenchmark.testLongStringMessageAssert:jfr                     thrpt            NaN              ---
MyBenchmark.testNoAssert                                        thrpt    3  2582.557 ± 155.550  ops/s
MyBenchmark.testNoAssert:jfr                                    thrpt            NaN              ---
MyBenchmark.testSimpleAssert                                    thrpt    3  2569.508 ±  99.231  ops/s
MyBenchmark.testSimpleAssert:jfr                                thrpt            NaN              ---
MyBenchmark.testSimpleStringMessageAssert                       thrpt    3  2581.186 ±  74.377  ops/s
MyBenchmark.testSimpleStringMessageAssert:jfr                   thrpt            NaN              ---
MyBenchmarkAssertionsEnabled.testLongStringMessageAssert        thrpt    3   617.655 ±  74.251  ops/s
MyBenchmarkAssertionsEnabled.testLongStringMessageAssert:jfr    thrpt            NaN              ---
MyBenchmarkAssertionsEnabled.testNoAssert                       thrpt    3  2559.503 ± 398.573  ops/s
MyBenchmarkAssertionsEnabled.testNoAssert:jfr                   thrpt            NaN              ---
MyBenchmarkAssertionsEnabled.testSimpleAssert                   thrpt    3   622.099 ±  61.091  ops/s
MyBenchmarkAssertionsEnabled.testSimpleAssert:jfr               thrpt            NaN              ---
MyBenchmarkAssertionsEnabled.testSimpleStringMessageAssert      thrpt    3   623.664 ±  70.528  ops/s
MyBenchmarkAssertionsEnabled.testSimpleStringMessageAssert:jfr  thrpt            NaN              ---
```

