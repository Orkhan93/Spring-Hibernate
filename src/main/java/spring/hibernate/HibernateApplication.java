package spring.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.hibernate.config.SpringHibernateConfig;
import spring.hibernate.dao.EmployeeDao;
import spring.hibernate.model.Employee;

public class HibernateApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);

        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

        System.out.println(employeeDao.getAllEmployees());
    }
}
