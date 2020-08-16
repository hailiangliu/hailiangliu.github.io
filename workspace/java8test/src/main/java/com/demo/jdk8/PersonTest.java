package com.demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);


        List<Person> persons = Arrays.asList(person1, person2, person3);

        PersonTest personTest = new PersonTest();
        List<Person> result = personTest.getPersonByUsername("zhangsan", persons);
        result.forEach(p -> System.out.println(p.getUsername()));

    }

    // 找出符合条件得 结果集  条件： username=指定
    public List<Person> getPersonByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
    }
    // 使用BiFunction 实现 查找age条件
    public List<Person> getPersonByAge(int age, List<Person> persons){
        BiFunction<Integer, List<Person>, List<Person>> function = (ageOfPerson, personList) ->{
            return personList.stream().filter(p->p.getAge()>ageOfPerson).collect(Collectors.toList());
        };
        return function.apply(age, persons);
    }

}
