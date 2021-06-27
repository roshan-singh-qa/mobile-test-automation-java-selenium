package commons;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapper {
    public <T> T deserializeYamlFile(Class<T> type, String fileName) throws IOException {
        return deserialize(type, fileName, new YAMLFactory());
    }

    public <T> T deserializeJsonFile(Class<T> type, String fileName) throws IOException {
        return deserialize(type, fileName, new JsonFactory());
    }

    public <T> T getTestData(Class<T> type, String fileName) throws IOException {
        return deserializeYamlFile(type, fileName);
    }

    public <T> List<String> getTestDataFields(Class<T> type) {
        ArrayList<String> listOfFields = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JavaType dataType = mapper.getTypeFactory().constructType(type);
        BeanDescription introspection = mapper.getSerializationConfig().introspect(dataType);
        List<BeanPropertyDefinition> properties = introspection.findProperties();
        for (BeanPropertyDefinition property : properties) {
            listOfFields.add(property.getName());
        }
        return listOfFields;
    }

    public Map<String, List<String>> getYamlFileAsMap(String fileName) throws IOException {
        return getFileAsMap(fileName, new YAMLFactory());
    }

    public Map<String, Object> getYamlFileAsStringAndObjectMap(String fileName) throws IOException {
        return getFileAsStringAndListOfObjectMap(fileName, new YAMLFactory());
    }

    public Map<String, List<String>> getJsonFileAsMap(String fileName) throws IOException {
        return getFileAsMap(fileName, new JsonFactory());
    }

    public String getObjectAsString(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    @SuppressWarnings("unchecked")
    private Map<String, List<String>> getFileAsMap(String fileName, JsonFactory factory)
            throws IOException {
        ResourceReader resourceReader = new ResourceReader();
        ObjectMapper mapper = new ObjectMapper(factory);
        String pathToFile =
                resourceReader.getPathToFile(fileName);
        return mapper.readValue(new File(pathToFile), Map.class);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getFileAsStringAndListOfObjectMap(String fileName,
                                                                  JsonFactory factory)
            throws IOException {
        ResourceReader resourceReader = new ResourceReader();
        ObjectMapper mapper = new ObjectMapper(factory);
        String pathToFile =
                resourceReader.getPathToFile(fileName);
        return mapper.readValue(new File(pathToFile), Map.class);
    }

    private <T> T deserialize(Class<T> type, String fileName, JsonFactory factory)
            throws IOException {
        ResourceReader resourceReader = new ResourceReader();
        ObjectMapper mapper = new ObjectMapper(factory);
        String pathToFile = resourceReader.getPathToFile(fileName);
        mapper.findAndRegisterModules();
        return mapper.readValue(new File(pathToFile), type);
    }
}
