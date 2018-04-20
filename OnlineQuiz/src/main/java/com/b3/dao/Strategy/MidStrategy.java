package com.b3.dao.Strategy;

public class MidStrategy implements PaperStrategy {
	//MidPaper has 2 G3 questions,3 G2 questions and 5 G1 questions.
	@Override
	public String getSQL() {
		String sql = 
				"(select  *  from  online_quiz.question\r\n" + 
				"where grade = 3 limit 2) union\r\n" + 
				"(select  *  from  online_quiz.question\r\n" + 
				"where grade = 2 limit 3) union\r\n" + 
				"(select  *  from  online_quiz.question\r\n" +
				"where grade = 1 limit 5)\r\n" +
				"order by rand()";
		return sql;
	}
}
