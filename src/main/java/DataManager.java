import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataManager {

    private static List<Data> finalSellers;
    private static ReportRules rules;
    private static final String path = "./sample.csv";

    public static void getPaths(String dataPath, String rulesPath) {
        Data[] sellersList = Utility.getDataFromJsonFile(dataPath, Data[].class);
        rules = Utility.getDataFromJsonFile(rulesPath, ReportRules.class);
        if (sellersList != null) {
            finalSellers = calculateScore(sellersList);
        }
        printResults();
        if (finalSellers != null) {
            Utility.writeCsvFile(finalSellers, path, "Name", "Score");
        }
    }


    private static List<Data> calculateScore(Data[] sellersList) {
        List<Data> sellers = new ArrayList<>();
        for (Data seller : sellersList) {
            if (seller.getSalesPeriod() <= rules.getPeriodLimit()) {
                seller.calculateScore(rules.isUseExperienceMultiplier());
                sellers.add(seller);
            }
        }

        sellers.sort(Data.SCORE_ORDER);
        Collections.reverse(sellers);

        double topResultsPercent = (rules.getTopPerformersThreshold() / 100.0) * sellers.size();
        if (topResultsPercent < 1) {
            System.out.println("We cant calculate " + topResultsPercent + " % of " + sellers.size() + " We need atleast 100 records!");
        } else {
            List<Data> finalSellers = new ArrayList<>();
            int count = 0;
            for (Data data : sellers) {
                if ((int) topResultsPercent == count) {
                    break;
                }
                count++;
                finalSellers.add(data);
            }

            return finalSellers;

        }
        return null;
    }


    public static void printResults() {
        System.out.println("UseExprienceMultiplier is set to: " + rules.isUseExperienceMultiplier());
        System.out.println("Final top " + rules.getTopPerformersThreshold() + "% with highest score sellers are:  ");
        for (Data entry : finalSellers) {
            System.out.println(entry.getName() + " - " + entry.getScore());
        }
    }
}
