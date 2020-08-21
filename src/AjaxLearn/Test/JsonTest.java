package AjaxLearn.Test;

import AjaxLearn.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JsonTest {
//    java对象转化为json字符串
    @Test
    public void testOne() throws Exception {
        Person person = new Person();
        person.setName("李四");
        person.setAge(23);
        person.setGender("女");

//        创建jackson核心对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
//        转换
        String s = objectMapper.writeValueAsString(person);
//        System.out.println(s);
//        将数据写到文件中
        objectMapper.writeValue(new File("d://a.txt"),person);
//        将数据关联到writer中,字符输出流,流到文件中
        objectMapper.writeValue(new FileWriter("d://a.txt"),person);
    }
    //    java对象转化为json字符串,list对象数组
    @Test
    public void testTWO() throws Exception {
        Person person = new Person();
        person.setName("李四");
        person.setAge(23);
        person.setGender("女");
        person.setBirthday(new Date());

        Person person1 = new Person();
        person1.setName("李四");
        person1.setAge(23);
        person1.setGender("女");
        person1.setBirthday(new Date());

        List<Person> people = new ArrayList<Person>();
        people.add(person);
        people.add(person1);

//        创建jackson核心对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

//        转换
        String s = objectMapper.writeValueAsString(people);
        System.out.println(s);

    }
//    java的map对象转json
    @Test
    public void testThree() throws Exception {
//        创建map对象
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name","李四");
        stringObjectHashMap.put("age",12);
        //        创建jackson核心对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

//        转换
        String s = objectMapper.writeValueAsString(stringObjectHashMap);
        System.out.println(s);
    }
//    json转java

    @Test
    public void testFour() throws Exception {
//        初始化json
        String json="{\"name\":\"李四\",\"age\":13}";
        //        创建jackson核心对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
//        转化为java对象
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
