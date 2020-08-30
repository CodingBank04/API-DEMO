package Library;

public class PayLoad {
    public static  String addBook(String isbn, String aisle){
        String payload="{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
        return payload;
    }
}
