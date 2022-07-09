package lowLevelSystemDesign.basic.atlassian.costExplorer;

import java.time.LocalDate;

public class CostExplorer {

    public void monthlyCostList(String planId, String startDate){
        LocalDate currentDate
                = LocalDate.parse(startDate);
        // Get day from date
        int dayOfMonth = currentDate.getDayOfMonth();
        int daysLeft = (30 - dayOfMonth);
        Double monthlyCost ;
        if(planId == "BASIC"){
            monthlyCost = 9.99;
        }else if(planId == "STANDARD"){
            monthlyCost = 49.99;
        } else {
            monthlyCost = 249.99;
        }
        Double currentMonthCost ;

        if(daysLeft > 0){
            currentMonthCost = (monthlyCost/30) * daysLeft;
        } else{
            currentMonthCost = monthlyCost;
        }
        double monthlyCostReport[]   = new double[12];
        monthlyCostReport[0] = currentMonthCost;
        for(int i=1; i<=11; i++){
            monthlyCostReport[i] = monthlyCost;
        }
        System.out.println("monthlyCostReport: ");
        for(int i=0; i<12; i++){
            //monthlyCostReport[i] = monthlyCost;
            System.out.print(monthlyCostReport[i]+" ");
        }
        //System.out.println(monthlyCostReport.toString());

    }

}
