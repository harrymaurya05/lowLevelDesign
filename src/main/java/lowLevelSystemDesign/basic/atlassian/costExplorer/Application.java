package lowLevelSystemDesign.basic.atlassian.costExplorer;

public class Application {
    public static void main(String[] args) {
        CostExplorer costExplorer = new CostExplorer();
        costExplorer.monthlyCostList("BASIC","2022-05-31");
    }
}
