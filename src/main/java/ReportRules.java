

public class ReportRules {

    private int topPerformersThreshold;
    private boolean useExprienceMultiplier;
    private int periodLimit;


    public ReportRules(int topPerformersThreshold, boolean useExperienceMultiplier, int periodLimit) {
        this.topPerformersThreshold = topPerformersThreshold;
        this.useExprienceMultiplier = useExperienceMultiplier;
        this.periodLimit = periodLimit;
    }

    public ReportRules() {
    }

    public int getTopPerformersThreshold() {
        return topPerformersThreshold;
    }


    public boolean isUseExperienceMultiplier() {
        return useExprienceMultiplier;
    }


    public int getPeriodLimit() {
        return periodLimit;
    }


    @Override
    public String toString() {
        return "ReportRules{" +
                "topPerformersThreshold=" + topPerformersThreshold +
                ", useExprienceMultiplier=" + useExprienceMultiplier +
                ", periodLimit=" + periodLimit +
                '}';
    }
}
