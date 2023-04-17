package homework2;
/* 
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task1 {
    public static void main(String[] args) throws IOException {
        StringBuilder responceBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("people.json"));
        String[] buffer = bufferedReader.readLine().replace("{", "").replace("\"", "")
                        .replace("}", "").replaceAll("\\s", "").split(",");
        
        responceBuilder.append("SELECT * FROM students WHERE ");
        for (String temp : buffer) {
            String[] data = temp.split(":");
            if (data[1].equals("null")) {
                continue;
            }
            responceBuilder.append(data[0] + " = " + data[1] + " AND ");
        }
        String responce = responceBuilder.substring(0, responceBuilder.length() - 4);
        System.out.println(responce);
        bufferedReader.close();
    }
}
