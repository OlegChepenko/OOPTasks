package readFileNameWriteFilesource;

import java.io.*;
import java.util.Scanner;

public class ReadFileNameWriteFileSource {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        Scanner scanner = new Scanner(fileInputStream);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()){
            builder.append(scanner.nextLine()).append("\n");
        }
        System.out.println(builder.toString());
        scanner.close();
        reader.close();
    }
}
