package dao;

import domain.Customer;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer getCustomerWithId(Integer id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", id);
        sqlSession.close();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> customers = sqlSession.selectList("queryAllCustomer");
        sqlSession.close();
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.insert("insertCustom",customer);
        sqlSession.close();
    }

    @Override
    public void updateCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.update("updateCustomer",customer);
        sqlSession.close();
    }
}
