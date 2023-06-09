package com.spring.SpringMavenDemo.events;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class EmployeeEvent extends ApplicationEvent {

    private String eventType;
    private Employee employee;
    public EmployeeEvent(Object source,String eventType,Employee employee) {
        super(source);
        this.eventType=eventType;
        this.employee=employee;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeEvent{" +
                "eventType='" + eventType + '\'' +
                ", employee=" + employee +
                ", source=" + source +
                '}';
    }
}
