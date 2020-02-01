package com.wangrui.adv.coll;

import java.util.Comparator;

// 比较器接口
public class PeopleAgeCompartor implements Comparator<People> {

	@Override
	public int compare(People o1, People o2) {
		return o1.age - o2.age;

	}

}
