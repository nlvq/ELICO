package ihm.simulate;

import java.util.ArrayList;
import java.util.List;

public class SimulateJob {
    String title;

    public SimulateJob(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static List<SimulateJob> getJobs() {
        ArrayList<SimulateJob> jobs = new ArrayList<>();

        jobs.add(new SimulateJob("Superviseur"));
        jobs.add(new SimulateJob("Validateur"));
        jobs.add(new SimulateJob("Ingénieur"));

        return jobs;
    }
}
