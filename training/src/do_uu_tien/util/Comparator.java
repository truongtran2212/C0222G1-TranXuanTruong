package do_uu_tien.util;

import do_uu_tien.model.Job;

import java.util.ArrayList;
import java.util.List;

public class Comparator implements java.util.Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int number1 = compareLevel(o1);
        int number2 = compareLevel(o2);

        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        }
        return 0;
    }

    public int compareLevel(Job job) {
        int level;
        switch (job.getLevel()) {

            case "High":
                level = 1;
                break;
            case "Normal":
                level = 2;
                break;
            case "Low":
                level = 3;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + job.getLevel());
        }
        return level;
    }

}
