import java.util.Comparator;

public class Data {

    private String name;
    private int totalSales;
    private int salesPeriod;
    private double experienceMultiplier;
    private double score;

    static Comparator<Data> SCORE_ORDER = Comparator.comparingDouble(Data::getScore);

    public Data(String name, int totalSales, int salesPeriod, double experienceMultiplier) {
        this.name = name;
        this.totalSales = totalSales;
        this.salesPeriod = salesPeriod;
        this.experienceMultiplier = experienceMultiplier;
    }

    public Data() {
    }

    public String getName() {
        return name;
    }


    public int getTotalSales() {
        return totalSales;
    }


    public int getSalesPeriod() {
        return salesPeriod;
    }

    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }


    public double getScore() {
        return score;
    }

    public void calculateScore(boolean expMultiplier) {

        if (expMultiplier) {
            this.score = (double) this.getTotalSales() / this.getSalesPeriod() * this.getExperienceMultiplier();
        } else {
            this.score = (double) this.totalSales / this.salesPeriod;
        }
    }


    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", totalSales=" + totalSales +
                ", salesPeriod=" + salesPeriod +
                ", experienceMultiplier=" + experienceMultiplier +
                ", score=" + score +
                '}';
    }
}
