package com.example.hibernatedemo;

import com.example.hibernatedemo.entity.Record;
import com.example.hibernatedemo.entity.inheritnace.GoodChild;
import com.example.hibernatedemo.entity.inheritnace.NaughtyChild;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jakub krhovják on 11/4/17.
 */
public class FlushingTest extends HibernateDemoApplicationTests {

	private SessionFactory sessionFactory;

//	@Before
//	public void myInitMethod() {
//		sessionFactory.openSession().setFlushMode(FlushMode.ALWAYS);
//		//sessionFactory.getCurrentSession().setFlushMode(FlushMode.ALWAYS);
//	}

	@Test
	@Transactional
 	@Rollback(value = false)
	//@QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FLUSH_MODE, value = FlushMode.ALWAYS) })
	public void BasicFlush() throws Exception {
		//sessionFactory.openSession().setFlushMode(FlushMode.ALWAYS);
		Record record = createRecord();
		recordDao.saveAndFlush(record);

		GoodChild goodChild = new GoodChild();
		goodChild.setFirstName("goodChild");
		goodChild.setAge(2);

		NaughtyChild naughtyChild = new NaughtyChild();
		naughtyChild.setFirstName("naughtyChild");
		naughtyChild.setAttribute("Devil");
		parentDao.save(new ArrayList<>(Arrays.asList(goodChild, naughtyChild)));

//		Record record2 = createRecord();
//		recordDao.mySave(record2);

		recordDao.findAll();
		//recordDao.co
	}

	@Test
	@Transactional(readOnly = true)
//	@Transactional
	public void SelectReadOnly() throws Exception {
		recordDao.findAll();
		parentDao.findAll();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
