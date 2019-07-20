package pl.connnectis.programator;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.List;

public class Calc {



    public double mean(List<Double> values){
        DescriptiveStatistics stats = new DescriptiveStatistics();


        for (int i = 0; i < values.size(); i++) {
            stats.addValue(values.get(i));

        }
        return stats.getMean();



    }
    public long sum (long a, long b){

        return a+b;
    }
}
