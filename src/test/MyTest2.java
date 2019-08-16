package test;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import domain.Customer;
import mapper.CustomerMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.List;

public class MyTest2 {

    @Test
    public void test1(){
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customerWithId = customerDao.getCustomerWithId(1);
        System.out.println(customerWithId);

        List<Customer> allCustomer = customerDao.getAllCustomer();
        for (Customer customer : allCustomer) {
            System.out.println(customer);
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.queryCustomerById(1);
        System.out.println(customer);

        List<Customer> customers = mapper.queryAllCustomer();
        for (Customer customer1 : customers) {
            System.out.println(customer1);
        }

        List<Customer> customerList = mapper.queryCustomerByName("%李%");
        for (Customer customer1 : customerList) {
            System.out.println(customer1);
        }

    sqlSession.close();
    }
}
