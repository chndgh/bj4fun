package com.snow.dream;

import com.google.common.base.Strings;
import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.repository.ActivityItemRepository;
import com.snow.dream.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bj4funApplicationTests {

	@Autowired
	ActivityItemRepository activityItemRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUser(){
		User user = new User();
		user.setSubOpenId("1000000");
		user.setNickName("Lily");
		userRepository.save(user);


		User user1 = new User();
		user1.setSubOpenId("1000001");
		user1.setNickName("小明");
		userRepository.save(user1);


		User user2 = new User();
		user2.setSubOpenId("1000002");
		user2.setNickName("小红");
		userRepository.save(user2);
	}




	@Test
	public void testRepository(){
		ActivityItem activityItem = new ActivityItem();
		activityItem.setId(getNowDate());
		activityItem.setTitle("足球");
		activityItem.setDescription("一起踢足球");
		activityItem.setOwnerUserId("1000002");
		activityItem.setIsOpen(1);
		activityItem.setCreateTime(new Date().getTime());
		activityItem.setVoters(Arrays.asList("1000000","1000001"));
		activityItem.setStatus(1002);
		activityItemRepository.save(activityItem);



		ActivityItem activityItem1 = new ActivityItem();
		activityItem1.setId(getNowDate()+1);
		activityItem1.setTitle("足球");
		activityItem1.setIsOpen(1);
		activityItem1.setDescription("一起踢足球");
		activityItem1.setOwnerUserId("1000001");
		activityItem1.setCreateTime(new Date().getTime());
		activityItem1.setVoters(Arrays.asList("1000002","1000001","oAqAC0S"));
		activityItem1.setStatus(1002);
		activityItemRepository.save(activityItem1);

		ActivityItem activityItem2 = new ActivityItem();
		activityItem2.setId(getNowDate()+2);
		activityItem2.setTitle("足球");
		activityItem2.setIsOpen(1);
		activityItem2.setDescription("一起踢足球");
		activityItem2.setOwnerUserId("1000002");
		activityItem2.setCreateTime(new Date().getTime());
		activityItem2.setVoters(Arrays.asList("1000000","1000001","oAqAC0S"));
		activityItem2.setStatus(1002);
		activityItemRepository.save(activityItem2);

		ActivityItem activityItem3 = new ActivityItem();
		activityItem3.setId(getNowDate()+3);
		activityItem3.setTitle("足球");
		activityItem3.setIsOpen(1);
		activityItem3.setDescription("一起踢足球");
		activityItem3.setOwnerUserId("1000002");
		activityItem3.setCreateTime(new Date().getTime());
		activityItem3.setVoters(Arrays.asList("1000000","1000001"));
		activityItem3.setStatus(1002);
		activityItemRepository.save(activityItem3);

		ActivityItem activityItem4 = new ActivityItem();
		activityItem4.setId(getNowDate()+4);
		activityItem4.setTitle("篮球");
		activityItem4.setIsOpen(1);
		activityItem4.setDescription("一起打篮球");
		activityItem4.setOwnerUserId("1000002");
		activityItem4.setCreateTime(new Date().getTime());
		activityItem4.setVoters(Arrays.asList("1000000","1000001"));
		activityItem4.setStatus(1002);
		activityItemRepository.save(activityItem4);

		ActivityItem activityItem5 = new ActivityItem();
		activityItem5.setId(getNowDate()+5);
		activityItem5.setTitle("篮球");
		activityItem5.setIsOpen(1);
		activityItem5.setDescription("一起打篮球");
		activityItem5.setOwnerUserId("1000002");
		activityItem5.setCreateTime(new Date().getTime());
		activityItem5.setVoters(Arrays.asList("1000000","1000001"));
		activityItem5.setStatus(1002);
		activityItemRepository.save(activityItem5);


		ActivityItem activityItem6 = new ActivityItem();
		activityItem6.setId(getNowDate()+6);
		activityItem6.setTitle("篮球");
		activityItem6.setIsOpen(1);
		activityItem6.setDescription("一起打篮球");
		activityItem6.setOwnerUserId("1000002");
		activityItem6.setCreateTime(new Date().getTime());
		activityItem6.setVoters(Arrays.asList("1000000","1000001"));
		activityItem6.setStatus(1002);
		activityItemRepository.save(activityItem6);


		ActivityItem activityItem7 = new ActivityItem();
		activityItem7.setId(getNowDate()+7);
		activityItem7.setTitle("篮球");
		activityItem7.setIsOpen(1);
		activityItem7.setDescription("一起打篮球");
		activityItem7.setOwnerUserId("1000002");
		activityItem7.setCreateTime(new Date().getTime());
		activityItem7.setVoters(Arrays.asList("1000000","1000001"));
		activityItem7.setStatus(1002);
		activityItemRepository.save(activityItem7);


		ActivityItem activityItem8 = new ActivityItem();
		activityItem8.setId(getNowDate()+8);
		activityItem8.setTitle("篮球");
		activityItem8.setIsOpen(1);
		activityItem8.setDescription("一起打篮球");
		activityItem8.setOwnerUserId("1000002");
		activityItem8.setCreateTime(new Date().getTime());
		activityItem8.setVoters(Arrays.asList("1000000","1000001"));
		activityItem8.setStatus(1002);
		activityItemRepository.save(activityItem8);


		ActivityItem activityItem9 = new ActivityItem();
		activityItem9.setId(getNowDate()+9);
		activityItem9.setTitle("篮球");
		activityItem9.setDescription("一起打篮球");
		activityItem9.setIsOpen(1);
		activityItem9.setOwnerUserId("1000002");
		activityItem9.setCreateTime(new Date().getTime());
		activityItem9.setVoters(Arrays.asList("1000000","1000001"));
		activityItem9.setStatus(1002);
		activityItemRepository.save(activityItem9);


		ActivityItem activityItem10 = new ActivityItem();
		activityItem10.setId(getNowDate()+10);
		activityItem10.setTitle("篮球");
		activityItem10.setIsOpen(1);
		activityItem10.setDescription("一起打篮球");
		activityItem10.setOwnerUserId("1000002");
		activityItem10.setCreateTime(new Date().getTime());
		activityItem10.setVoters(Arrays.asList("1000000","1000001"));
		activityItem10.setStatus(1002);
		activityItemRepository.save(activityItem10);

		ActivityItem activityItem11 = new ActivityItem();
		activityItem11.setId(getNowDate()+11);
		activityItem11.setTitle("篮球");
		activityItem11.setIsOpen(0);
		activityItem11.setDescription("一起打篮球");
		activityItem11.setOwnerUserId("1000002");
		activityItem11.setCreateTime(new Date().getTime());
		activityItem11.setVoters(Arrays.asList("1000000","1000001"));
		activityItem11.setStatus(1002);
		activityItemRepository.save(activityItem11);

		ActivityItem activityItem12 = new ActivityItem();
		activityItem12.setId(getNowDate()+12);
		activityItem12.setOwnerUserId("1000002");
		activityItem12.setIsOpen(1);
		activityItem12.setCreateTime(new Date().getTime());
		activityItem12.setVoters(Arrays.asList("1000000","1000001"));
		activityItem12.setStatus(1002);
		activityItemRepository.save(activityItem12);

		ActivityItem activityItem13 = new ActivityItem();
		activityItem13.setId(getNowDate()+13);
		activityItem13.setIsOpen(1);
		activityItem13.setOwnerUserId("oAqAC0S");
		activityItem13.setCreateTime(new Date().getTime());
		activityItem13.setVoters(Arrays.asList("1000000","1000001","1000002"));
		activityItem13.setStatus(1002);
		activityItemRepository.save(activityItem13);

	}



	private String getNowDate(){
		String year = Calendar.YEAR+"";
		String month = Calendar.MONTH + 1+"";
		String date = Calendar.DATE+"";
		String hour = Calendar.HOUR+"";
		String min = Calendar.MINUTE+"";
		String second = Calendar.SECOND+"";
		String now = year + month+date+hour+min+second;
		return now;
	}

}
