package cn.jiaoayng.jpa.dao;
        import cn.jiaoayng.jpa.entity.Customer;
        import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @Auther Jiao yang
 * @Date 2019/10/9 15:46
 *    使用SpringData方法名查询
 *    需要注意的  继承后里面的泛型  第一个是实体类 类型  ， 第二个是该类主键的数据类型
 *
 */
public interface CustomerDao extends JpaRepository<Customer,Long>{

}
