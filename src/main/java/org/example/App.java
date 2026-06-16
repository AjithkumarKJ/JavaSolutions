package org.example;

import static org.example.functions.EmployeeJava8Features.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   JAVA 8 FEATURES DEMONSTRATION");
        System.out.println("============================================");

        demonstrateFilterWithLambda();                    // Method 1
        demonstrateMapAndCollect();                       // Method 2
        demonstrateMethodReferences();                    // Method 3
        demonstrateOptional();                            // Method 4
        demonstrateReduce();                              // Method 5
        demonstrateGroupingBy();                          // Method 6
        demonstrateToMap();                               // Method 7
        demonstrateDistinctAndSorted();                   // Method 8
        demonstrateLimitAndSkip();                        // Method 9
        demonstrateFlatMap();                             // Method 10
        demonstrateCustomCollector();                     // Method 11
        demonstrateStreamStatistics();                    // Method 12
        demonstrateMatching();                            // Method 13
        demonstrateForEachWithIndex();                    // Method 14
        demonstrateComplexSorting();                      // Method 15
        demonstratePartitioning();                        // Method 16
        demonstrativeFindOperations();                    // Method 17
        demonstrateMapWithCalculation();                  // Method 18
        demonstrateChainingOperations();                  // Method 19
        demonstratePeek();                                // Method 20

        System.out.println("\n============================================");
        System.out.println("   DEMONSTRATION COMPLETE");
        System.out.println("============================================\n");
    }
}