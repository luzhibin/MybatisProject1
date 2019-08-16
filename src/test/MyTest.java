package test;

import domain.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MybatisUtils;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    @Test
    public void test(){
/*        //1.SqlSessionFactoryBuilder 加载配置文件，创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //String resource = "SqlMappingConfig.xml";

        //2.加载SqlMappingConfig.xml配置文件
        InputStream inputStream = Resources.class.getResourceAsStream("/SqlMappingConfig.xml");

        //3.获取session工厂，创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        //4.获取会话,创建SqlSession对象      ----JDBC连接
        SqlSession sqlSession = sessionFactory.openSession();*/

        SqlSession sqlSession = MybatisUtils.openSession();

        //5.执行SqlSession对象执行查询  ---执行sql
        //第一个参数是Customer.xml的statement的id
        //第二个参数是执行sql需要的参数
        Customer customer = sqlSession.selectOne("queryCustomerById", 2);

        System.out.println(customer);

        //6.释放资源  关闭session
        sqlSession.close();
    }
    /*查询所有用户*/
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> queryAllCustomer = sqlSession.selectList("queryAllCustomer");
        for (Customer customer : queryAllCustomer) {
            System.out.println(customer);
        }
        sqlSession.close();
    }
    //根据用户名模糊查询用户
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> customers = sqlSession.selectList("queryCustomerByName", "李");
        for (Customer customer : customers) {
            System.out.println(customers);
        }
        sqlSession.close();
    }
    //插入操作，添加客户
    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = new Customer();
        customer.setCust_name("露娜2");
        customer.setCust_profession("法师");
        customer.setCust_phone("18045678911");
        customer.setEmail("LuNaLuNa2@qq.com");
        sqlSession.insert("insertCustom",customer);
        //当要改动数据库当中的记录时，执行sql时要自己提交事务
        //手动提交事务
        sqlSession.commit();
        System.out.println(customer);
        sqlSession.close();
    }
    /*更新操作*/
    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", 13);
        customer.setCust_name("孙悟空");
        customer.setCust_profession("战士");
        sqlSession.update("updateCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }
    /*删除操作*/
    @Test
    public void delete(){
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", 13);
        sqlSession.delete("deleteCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }

}
