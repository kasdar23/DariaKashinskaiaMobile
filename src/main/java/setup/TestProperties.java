package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private Properties currentProps = new Properties();
    private String propertyPath;

    public TestProperties(String propertyPath) {
        this.propertyPath = propertyPath;
    }

    /**
     * Load current property set.
     *
     * @return Property set.
     * @throws IOException If property path is incorrect.
     */
    public TestProperties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(propertyPath);
        currentProps.load(in);
        in.close();
        return this;
    }

    /**
     * Return property value by key.
     *
     * @param propKey The property key.
     * @return The property value.
     * @throws IOException If property path is incorrect.
     */
    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) getCurrentProps();
        return currentProps.getProperty(propKey, null);
    }

}
















