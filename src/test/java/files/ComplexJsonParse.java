package files;

import io.restassured.path.json.JsonPath;

import java.sql.SQLOutput;

public class ComplexJsonParse {
    public static void main(String[] args) {


        JsonPath js = new JsonPath(payload.courcePrice());

        int count = js.getInt("courses.size()");
        System.out.println(count);
        //print purchase amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        //print title of the first course

        String titleFirstCourse = js.get("courses[0].title");
        System.out.println(titleFirstCourse);

        String titleFirstCourse1 = js.get("courses[1].title");
        System.out.println(titleFirstCourse1);


        //print all coursec titles and their respective prices
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            System.out.println(js.getInt("courses[" + i + "].price"));
            System.out.println(courseTitles);
        }
        System.out.println("Print no of copies sold by RPA Course");
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if (courseTitles.equals("RPA")) {
               int copies= js.get("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }
    }}