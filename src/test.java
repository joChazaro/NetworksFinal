import java.io.IOException;
import java.nio.file.*;


public class test {
    public static void main(String[] args) throws IOException {
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name: dirs) {
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
