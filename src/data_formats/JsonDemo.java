import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * JsonDemo.java
 * 
 * This class demonstrates simple JSON handling in Java 8.
 * 
 * NOTE: Standard Java 8 does NOT have a dedicated JSON library (like Jackson or Gson).
 * However, since Java 8 includes the "Nashorn" JavaScript engine, we can use it 
 * to parse JSON strings natively without external dependencies!
 * 
 * Concepts:
 * 1. JSON Structure.
 * 2. Parsing JSON using the ScriptEngine (JavaScript).
 */
public class JsonDemo {
    public static void main(String[] args) {
        // 1. A JSON String
        String jsonString = "{" +
                "\"id\": 101, " +
                "\"name\": \"Alice Smith\", " +
                "\"active\": true" +
                "}";
        
        System.out.println("=== JSON Demo (using ScriptEngine) ===");
        System.out.println("Raw JSON: " + jsonString);
        System.out.println("---------------------------");
        
        try {
            // 2. Use ScriptEngineManager to get the JavaScript engine
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            
            // 3. Evaluate the JSON string to create a JavaScript object
            // We wrap it in parentheses or assign it to a variable to ensure it's treated as an expression
            String script = "var obj = " + jsonString + "; obj;";
            engine.eval(script);
            
            // 4. Access properties
            Object name = engine.eval("obj.name");
            Object id = engine.eval("obj.id");
            Object active = engine.eval("obj.active");
            
            System.out.println("Parsed Data:");
            System.out.println("Name:   " + name);
            System.out.println("ID:     " + id);
            System.out.println("Active: " + active);
            
        } catch (ScriptException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}
