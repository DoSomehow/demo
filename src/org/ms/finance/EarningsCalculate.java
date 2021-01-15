package org.ms.finance;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class EarningsCalculate {

    public static void main(String[] args) {
        EarningsCalculate ec = new EarningsCalculate();
        // double result = ec.annualEarningsCalculate(100000d, 4.8, 180, 180);
        // System.out.println("最终获益:" + result);  //10236.71  //102367.12
        // double result = ec.annualEarningsCalculate(100000d, 4.8, 7, 180);
        // System.out.println("最终获得:" + result);  //10242.11 //102421.15
        double result = ec.annualEarningsCalculate(100000d, 10, 365, 3650);
        System.out.println("最终获得:" + result);  //259374.25
    }

    public double annualEarningsCalculate(double fund, double rate, int period, int days) {
        DecimalFormat df = new DecimalFormat("#.##");
        BigDecimal newFund = new BigDecimal(String.valueOf(fund));
        while(days > 0){
            String earningsStr = df.format(newFund.doubleValue() * rate / 100 * period / 365);
            // double earnings = Double.valueOf(earningsStr);
            // fund += earnings;
            BigDecimal earnings = new BigDecimal(earningsStr);
            newFund = newFund.add(earnings);
            days -= period;
        }
        return newFund.doubleValue();
    }


}
