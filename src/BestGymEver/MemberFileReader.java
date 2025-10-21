package BestGymEver;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberFileReader {

    public List<Member> read(Path p) {
        List<Member> memberList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(p)) {
            br.readLine(); // Skippa första rad
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                LocalDate start = LocalDate.parse(parts[4]);
                LocalDate latest = LocalDate.parse(parts[5]);

                Member m = new Member(parts[0], parts[1], parts[2], parts[3],
                        start, latest, parts[6]);
                memberList.add(m);
            }
        } catch (IOException e) {
            System.err.println("Fel när fil skulle läsas in: " + e.getMessage());
            return null;
        }

        return memberList;
    }
}