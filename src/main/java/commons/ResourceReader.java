package commons;

public class ResourceReader {

    public String getPathToFile(String filePath) {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(filePath).getPath();
        int numberOfCharacters = path.length();
        return path.substring(1, numberOfCharacters);
    }
}