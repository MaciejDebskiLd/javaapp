package pl.connnectis.programator;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {

    public static void main(String[] args) {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

        //https://commons.apache.org/proper/commons-math/userguide/stat.html

        for (int i = 1; i <= 5; i++) {
            descriptiveStatistics.addValue(i);
        }

        double mean = descriptiveStatistics.getMean();
        double std = descriptiveStatistics.getStandardDeviation();
        double median = descriptiveStatistics.getPercentile(50);

        System.out.println("średnia: " + mean);
        System.out.println("Odchylenie: " + std);
        System.out.println("Mediana: " + median);


    }


}
