package com.spring.SpringMavenDemo.events;

import org.springframework.stereotype.Repository;
/**
 * '@Repository','@Services','@Controller' => are derived from @Component
 * So by telling @Repository => It gives a logical (Semantic) meaning to it
 *                           => Whenever data is persists => It is related to persistance Mechanism*/
@Repository
public class EmployeeDAO {
    public Employee createNewEmployee()
    {
        Employee e=new Employee();
        e.setId(1);
        e.setFirstName("Deepika");
        e.setLastName("Prabha");
        return e;

    }
}
