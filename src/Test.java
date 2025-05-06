import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Test {
    private static final Map<String, String> skillMap = new HashMap<>();
    private static String generatedSkill;

    static {
        skillMap.put("java", "Java Backend developer");
        skillMap.put(".net", ".net Backend developer");
        skillMap.put("c++", "c++ Backend developer");
        skillMap.put("python", "AI developer");
        skillMap.put("Ruby", "Ruby Backend developer");
    }

    public static void main(String[] args) throws Exception {
        Thread skillGenerator = new Thread(() -> {
            try{
                Thread.sleep(1000);
                String[] skills = skillMap.keySet().toArray(new String[0]);
                Random random = new Random();
                generatedSkill = skills[random.nextInt(skills.length)];
                System.out.println("Generated skill: " + generatedSkill);
            } catch(Exception ex) {
                System.out.println("Can not create skillGenerator thread");
            }
        });

        Thread projectDescription = new Thread(() -> {
            try {
                skillGenerator.join();
                String projectDescriptionStr = skillMap.get(generatedSkill);
                System.out.println("Project description: " + projectDescriptionStr);
            } catch (Exception ex) {
                System.out.println("Can not create skillGenerator thread");
            }
        });

        skillGenerator.start();
        projectDescription.start();

        skillGenerator.join();
        projectDescription.join();

//        //////////////////////////////////
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        List<Freelancer> freelancers = new ArrayList<>();
//        boolean isFinished = false;
//
//        int id = 1;
//        while (!isFinished) {
//
//            Freelancer freelancer = addFreelancer();
//            freelancer.setId(String.valueOf(id++));
//            System.out.println("Do you wanna add another freelancer? (y/n)");
//            String answer = input.readLine();
//            if(answer.equals("n")) {
//                isFinished = true;
//            }
//            freelancers.add(freelancer);
//        }
//
//
//        /////////////////////////////////
//        writeToFile(freelancers);
//
//        /////////////////////////////
//        System.out.println(readFile());
//
//        System.out.println("Enter skill you wanna search: ");
//        String searchingSkill = input.readLine();
//        for (Freelancer freelancer:freelancers) {
//            List<String> skills = freelancer.getSkills();
//            if(skills.contains(searchingSkill)) {
//                System.out.println("Freelancer has this skill: " + freelancer.getName());
//            }
//        }
    }

    public static String readFile() throws IOException {
        Path path = Paths.get("freelancer1.dat");
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = reader.readLine();
        }
        reader.close();

        return sb.toString();
    }

    public static void writeToFile(List<Freelancer> freelancers) throws IOException {
        Path path = Paths.get("freelancer.dat");
        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        for (Freelancer freelancer : freelancers) {
            writer.append(freelancer.toString());
            writer.append(System.lineSeparator());
        }

        writer.flush();
        System.out.println("Object has been written to file");
    }

    public static Freelancer addFreelancer() throws IOException {
        Freelancer freelancer = new Freelancer();
        boolean isSuccess = false;

        while (!isSuccess) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter freelancer info: ");
            System.out.println("Enter name: ");
            String freelancerNameStr = input.readLine();
            System.out.println("Enter hourlyRate: ");
            String freelancerHourlyRateStr = input.readLine();
            System.out.println("Enter totalHoursWorked: ");
            String freelancerTotalHoursWorkedStr = input.readLine();
            System.out.println("Enter skills: ");
            String freelancerSkillStr = input.readLine();

            freelancer.setName(freelancerNameStr);
            freelancer.setHourlyRate(Float.parseFloat(freelancerHourlyRateStr));
            freelancer.setTotalHoursWorked(Integer.parseInt(freelancerTotalHoursWorkedStr));
            freelancer.setSkills(List.of(freelancerSkillStr.split(",")));

            boolean isValid = freelancer.validateName()
                    && freelancer.validateHourlyRate()
                    && freelancer.validateTotalHoursWorked();

            if (!isValid) {
                System.out.println("Invalid infomation!!!");
            } else {
                isSuccess = true;
            }
        }
        return freelancer;
    }
}
