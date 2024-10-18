package practice;

import java.util.*;

public class Test11 {

    public static void main(String[] args) {

        List<Map<String, Object>> employees = Arrays.asList(
                new HashMap<String, Object>() {{
                    put("name", "Alice");
                    put("age", 30);
                    put("city", "New York");
                }},
                new HashMap<String, Object>() {{
                    put("name", "Bob");
                    put("age", 25);
                    put("city", "London");
                }},
                new HashMap<String, Object>() {{
                    put("name", "Charlie");
                    put("age", 35);
                    put("city", "Paris");
                }}
        );


        Map<String, Object>[] arrayOfMaps = employees.toArray(new HashMap[0]);

        // Printing the array of maps
        for (Map<String, Object> map : arrayOfMaps) {
            System.out.println(map);
        }
        System.out.println(getEmployee(employees, "Paris"));

    }

    private static List<String> getEmployee(List<Map<String, Object>> employees,
                                    String cityfilter) {
        ArrayList<String> list = new ArrayList();

        for (Map<String, Object> e : employees) {
            if (String.valueOf(e.get("city")).equalsIgnoreCase(cityfilter)) {
                list.add(String.valueOf(e.get("name")));
            }
        }

        return list;
    }
}
