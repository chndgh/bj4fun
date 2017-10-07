package com.snow.dream;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.repository.ActivityItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bj4funApplicationTests {

	@Autowired
	ActivityItemRepository activityItemRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRepository(){
		ActivityItem activityItem = new ActivityItem();
		activityItem.setId("2222");
		activityItem.setVoters(Arrays.asList("12345677","21212121"));
		activityItem.setStatus(1001);
		activityItemRepository.save(activityItem);

		List<ActivityItem> activities = activityItemRepository.findByStatusAndVoters(1001,"12345677");
		activities.stream().forEach(activityItem1 -> {
			System.out.println(activityItem1.getId());
		});
	}

}
