package lowLevelSystemDesign.basic.atlassian.costExplorer;

public class Plans {
    private String  planId;
    private Float monthlyCost ;

    public Plans(String planId, Float monthlyCost) {
        this.planId = planId;
        this.monthlyCost = monthlyCost;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Float getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(Float monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
}
