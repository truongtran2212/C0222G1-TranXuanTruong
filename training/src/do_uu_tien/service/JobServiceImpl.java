package do_uu_tien.service;

import do_uu_tien.model.Job;
import do_uu_tien.util.Comparator;
import do_uu_tien.util.ReadAndWrite;
import new_furama.util.regex.Regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JobServiceImpl implements JobService {

    public static Scanner scanner = new Scanner(System.in);
    public List<Job> jobList = getJobList();
    public static final String FILE_JOB = "src\\do_uu_tien\\data\\job.csv";

    public static final String ID_JOB = "^TASK-[0-9]{4}$";
    public static final String LEVEL = "^High|Normal|Low$";

    @Override
    public void display() {
        jobList = getJobList();

        Comparator comparator = new Comparator();
        Collections.sort(jobList, comparator);
        for (Job item : jobList) {
            System.out.println(item);
        }

        updateFile(jobList);
    }

    public static List<Job> getJobList() {
        List<Job> jobList = new ArrayList<>();
        List<String[]> list = ReadAndWrite.readFile(FILE_JOB);

        for (String[] item : list) {
            jobList.add(new Job(Integer.parseInt(item[0]), item[1], item[2], item[3], item[4],item[5]));
        }
        return jobList;
    }

    @Override
    public void addNewJob() {
        jobList = getJobList();

        int id = jobList.get(jobList.size() - 1).getId() + 1;

        System.out.println("input id job");
        while (true) {
            String idJob = Regex.checkRegex(ID_JOB);

//            while (true) {
//                idJob = scanner.nextLine();
//                if (idJob.matches(ID_JOB)) {
//                    break;
//                } else {
//                    System.err.println("Wrong format");
//                }
//            }

            boolean check = true;
            for (Job item : jobList) {
                if (idJob.equals(item.getIdJob())) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                System.err.println("id already in this list");
            } else {
                System.out.println("input name job");
                String nameJob = scanner.nextLine();
                System.out.println("Input day");
                String day = scanner.nextLine();

                System.out.println("Input Level, 1 in 3");
                System.out.println("High");
                System.out.println("Normal");
                System.out.println("Low");

                String level = Regex.checkRegex(LEVEL);

//                while (true) {
//                    level = scanner.nextLine();
//                    if (level.matches(LEVEL)) {
//                        break;
//                    } else {
//                        System.err.println("Wrong format");
//                    }
//                }

                jobList.add(new Job(id,idJob, nameJob, day, level, "Working"));
                updateFile(jobList);
                System.out.println("Add success");
                break;
            }
        }
    }
    @Override
    public void updateJob() {
        jobList = getJobList();
        display();

        System.out.println("Input id Job");
        String idJob;
        while (true) {
            idJob = scanner.nextLine();
            if (idJob.matches(ID_JOB)) {
                break;
            } else {
                System.err.println("Wrong format");
            }
        }

        boolean check = false;
        for (Job item : jobList) {
            if (item.getIdJob().equals(idJob)) {
                check = true;
                item.setStatusJob("Done");
                updateFile(jobList);
                System.out.println("update success");
                break;
            }
        }
        if (!check) {
            System.err.println("No have this id");
        }
    }


    public static void updateFile(List<Job> jobList) {
        List<String> stringList = new ArrayList<>();
        for (Job item : jobList) {
            stringList.add(item.getLine());
        }
        ReadAndWrite.writeFile(FILE_JOB,stringList);
    }
}
