package edu.neu.csye7374;

public interface Tradable {

    default void setBid(String bid){
        System.out.println("This is the default bid setting");
    }
    default String getMetric(){
        return "This is the default metric";
    }
}
