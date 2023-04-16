package com.spring.SpringMavenDemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeePublisher implements ApplicationEventPublisherAware {
    @Autowired
    private EmployeeDAO employeeDAO;
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }
    public Employee createNewEmployee(){
        System.out.println("publish create new employee");
        Employee employee=employeeDAO.createNewEmployee();
        //Publish the event here
        publisher.publishEvent(new EmployeeEvent(this,"ADD",employee));
        return employee;
    }

    @Override
    public String toString() {
        return "EmployeePublisher{" +
                "employeeDAO=" + employeeDAO +
                ", publisher=" + publisher +
                '}';
    }
    /**
     * Event Listeners => Lets Learn About it
     * Purpose : There is button in screen - the code listens to that buttin and responds once the click has happend
     * There is Event => Publisher (is mandatory) => will mention the source , hence mandatory
     *                => Event Type(Eg : Add, delete, update etc., ) => not mandatory
     *                => Event Object Class (What is it adding,deleteing or updating) eg: Employee => not mandatory
     * Process Flow -
     *  - I have an event occured
     *  - I have a listener => This listener will listen whenever the event is raised by the oublisher
     *  - Publisher has a method which will create the employee object ,publish the employee object and raise the event
     *  'Publisher' - will raise an event and whenever the event occurs =>
     *  There is the 'Listener' - will listen to that 'Event'*/

}
