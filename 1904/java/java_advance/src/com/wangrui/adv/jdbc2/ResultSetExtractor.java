package com.wangrui.adv.jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<T> {

	T extract(ResultSet rst)throws SQLException;
}
