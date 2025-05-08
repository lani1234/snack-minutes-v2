//package com.snackminutes.loader;
//
//import com.snackminutes.model.Snack;
//import com.snackminutes.model.UnitOfMeasure;
//import com.snackminutes.service.SnackService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final SnackService snackService;
//
//    public DataLoader(SnackService snackService) {
//        this.snackService = snackService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        // Sample snack data to be saved on startup
//
//        // option 1
////        Snack snack1 = new Snack("Chocolate Chip Cookie", 45.0, UnitOfMeasure.GRAM, "1 cookie", 220);
////        Snack snack2 = new Snack("Apple", 182.0, UnitOfMeasure.GRAM, "1 apple", 95);
////
////        snackService.createSnacks(Arrays.asList(snack1, snack2)); // Bulk create
//
//
//        // option 2
//        if (snackService.getAllSnacks().isEmpty()) {
//            // Creating some initial snack data
//            Snack snack1 = Snack.builder()
//                    .name("Chocolate Chip Cookie")
//                    .weight(45.0)
//                    .unitOfMeasure(UnitOfMeasure.GRAM)
//                    .servingSize("1")
//                    .caloriesPerServing(220)
//                    .build();
//
//            Snack snack2 = Snack.builder()
//                    .name("Apple")
//                    .weight(182.0)
//                    .unitOfMeasure(UnitOfMeasure.GRAM)
//                    .servingSize("1")
//                    .caloriesPerServing(95)
//                    .build();
//
//            // Save the snacks
//            snackService.createSnacks(Arrays.asList(snack1, snack2));
//
//            System.out.println("Sample snacks have been loaded into the database.");
//        }
//    }
//}
//
