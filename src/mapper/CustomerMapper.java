package mapper;

import domain.Customer;

import java.util.List;

/**
 1.namespace必须和Mapper接口类路径一致
 2.id必须和Mapper接口方法名一致
 3.parameterType必须和接口方法参数类型一致
 4.resultType必须和接口方法返回值类型一致
 **/
public interface CustomerMapper {

    //根据id查询客户
    public Customer queryCustomerById(Integer id);

    //查询所有客户
    public List<Customer> queryAllCustomer();

    //根据姓名模糊查询客户
    public List<Customer> queryCustomerByName(String name);

    //添加客户
    public void insertCustom(Customer customer);

    //更新操作
    public void updateCustomer(Customer customer);

    //删除操作
    public void deleteCustomer(Customer customer);

    void queryCustomerByName();
}
