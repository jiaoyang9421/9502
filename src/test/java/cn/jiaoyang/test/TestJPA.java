package cn.jiaoyang.test;

import cn.jiaoayng.jpa.dao.CustomerDao;
import cn.jiaoayng.jpa.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Auther Jiao yang
 * @Date 2019/10/9 15:55
 * 测试类中调用的方法来自与继承父类的JpaRepository内的方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJPA {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(2L);
        System.out.println(customer);
    }

    @Test
    @Transactional
    public void testGetOne() {
        Customer customer = customerDao.getOne(2L);
        System.out.println("bobonononkpnjlsfdlkfsnhd");
        System.out.println(customer);
    }

    // 查询所有
    @Test
    public void testFindAll() {
        List<Customer> customer = customerDao.findAll();
        for (Customer cc : customer) {
            System.out.println(cc);
        }

    }

    @Test
    public void testFindAllByPage() {
        PageRequest pageable = new PageRequest(0, 5);
        Page<Customer> page = customerDao.findAll(pageable);
        long totalElements = page.getTotalElements();
        System.out.println("总的记录数是：" + totalElements);
        int totalPages = page.getTotalPages();
        System.out.println("总页数为：" + totalPages);
        List<Customer> content = page.getContent();
        for (Customer cc : content) {
            System.out.println(cc);
        }

    }

    // 排序
    @Test
    public void testFindAllSort() {
//        (A开头升序，D开头降序)
        Sort sort = new Sort(Sort.Direction.DESC, "custId");
        List<Customer> customer = customerDao.findAll(sort);
        for (Customer cc : customer) {
            System.out.println(cc);
        }

    }

    @Test
    public void testCount() {
        long count = customerDao.count();
        System.out.println(count);

    }

    // 判断某个记录是否存在
    @Test
    public void testExists() {
        boolean exists = customerDao.exists(1L);
        System.out.println(exists);

    }
}