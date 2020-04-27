package schemaorg_apache_xmlbeans.system.MensajeMETypeSystem;
import org.apache.xmlbeans.SchemaTypeSystem;

public class TypeSystemHolder
{
    public static final SchemaTypeSystem typeSystem;
    
    private TypeSystemHolder() {
    }
    
    private static final SchemaTypeSystem loadTypeSystem() {
        try {
            return (SchemaTypeSystem)Class.forName("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl", true, TypeSystemHolder.class.getClassLoader()).getConstructor(Class.class).newInstance(TypeSystemHolder.class);
        }
        catch (ClassNotFoundException cause) {
            throw new RuntimeException("Cannot load org.apache.xmlbeans.impl.SchemaTypeSystemImpl: make sure xbean.jar is on the classpath.", cause);
        }
        catch (Exception cause2) {
        	System.out.println("ljkasdljasdlkjasd lk jsadlk jasldkj sd");
        	cause2.printStackTrace();
        	return null;
//            throw new RuntimeException("Could not instantiate SchemaTypeSystemImpl (" + cause2.toString() + "): is the version of xbean.jar correct?", cause2);
        }
    }
    
    static {
        typeSystem = loadTypeSystem();
    }
}