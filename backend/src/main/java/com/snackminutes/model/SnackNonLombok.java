//package com.snackminutes.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "snack") // Optional: Specify the table name in the database
//public class Snack {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private double weight;
//
//    @Enumerated(EnumType.STRING) // Assuming UnitOfMeasure is an enum
//    private UnitOfMeasure unitOfMeasure;
//
//    private String servingSize;
//
//    private int caloriesPerServing;
//
//    // Default constructor (required by JPA)
//    public Snack() {
//    }
//
//    // Constructor with all fields (optional, but often useful)
//    public Snack(String name, double weight, UnitOfMeasure unitOfMeasure, String servingSize, int caloriesPerServing) {
//        this.name = name;
//        this.weight = weight;
//        this.unitOfMeasure = unitOfMeasure;
//        this.servingSize = servingSize;
//        this.caloriesPerServing = caloriesPerServing;
//    }
//
//    // Getters and setters for all fields
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public UnitOfMeasure getUnitOfMeasure() {
//        return unitOfMeasure;
//    }
//
//    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
//        this.unitOfMeasure = unitOfMeasure;
//    }
//
//    public String getServingSize() {
//        return servingSize;
//    }
//
//    public void setServingSize(String servingSize) {
//        this.servingSize = servingSize;
//    }
//
//    public int getCaloriesPerServing() {
//        return caloriesPerServing;
//    }
//
//    public void setCaloriesPerServing(int caloriesPerServing) {
//        this.caloriesPerServing = caloriesPerServing;
//    }
//
//    @Override
//    public String toString() {
//        return "Snack{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", weight=" + weight +
//                ", unitOfMeasure=" + unitOfMeasure +
//                ", servingSize='" + servingSize + '\'' +
//                ", caloriesPerServing=" + caloriesPerServing +
//                '}';
//    }
//}
