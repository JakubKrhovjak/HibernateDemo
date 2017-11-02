package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.ParentDao;
import com.example.hibernatedemo.entity.inheritnace.GoodChild;
import com.example.hibernatedemo.entity.inheritnace.NaughtyChild;
import com.example.hibernatedemo.entity.inheritnace.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jakub krhovják on 11/2/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InheritanceTest {

	private ParentDao parentDao;

	@Test
	public void insert() throws Exception {
		GoodChild goodChild = new GoodChild();
		goodChild.setFirstName("goodChild");
		goodChild.setAge(2);

		NaughtyChild naughtyChild = new NaughtyChild();
		naughtyChild.setFirstName("goodChild");
		naughtyChild.setAttribute("Devil");
		parentDao.save(new ArrayList<>(Arrays.asList(goodChild, naughtyChild)));
	}

	@Test
	public void select() throws Exception {
		List<Parent> parents = parentDao.findAll();

	}

	@Test
	public void update() throws Exception {
		List<Parent> parents = parentDao.findAll();
		parents.forEach(parent -> parent.setFirstName("updated"));
		parentDao.save(parents);

	}

	@Autowired
	public void setParentDao(ParentDao parentDao) {
		this.parentDao = parentDao;
	}
}
