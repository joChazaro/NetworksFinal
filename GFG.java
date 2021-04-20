
// Java program to demonstrate
// FileSystem.getRootDirectories() method

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.util.Iterator;

public class GFG {

    public static void main(String[] args) throws IOException {

        //Instantiating the File class
        File outputFile = new File("C:\\Users\\matth\\IdeaProjects\\OSFinal\\src\\testText.txt");
        //Instantiating the PrintStream class
        PrintStream resultFile = new PrintStream(outputFile);
        System.setOut(resultFile);

        //Printing values to file

        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name : dirs) {
            System.out.println(name);

            Path dir = name;
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path file : stream) {
                    System.out.println(file.getFileName());
                }
            } catch (IOException | DirectoryIteratorException x) {
                // IOException can never be thrown by the iteration.
                // In this snippet, it can only be thrown by newDirectoryStream.
                System.err.println(x);
            }
        }
    }
}

//Output stream