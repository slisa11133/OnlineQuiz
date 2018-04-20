package com.b3.dao.Strategy;

public class HardPaper implements PaperStrategy {	
	//HardPaper has 3 G3 questions,3 G2 questions and 4 G1 questions.
		@Override
		public String getSQL() {
			String sql = 
					"(select  *  from  online_quiz.question\r\n" + 
					"where grade = 3 limit 3) union\r\n" + 
					"(select  *  from  online_quiz.question\r\n" + 
					"where grade = 2 limit 3) union\r\n" + 
					"(select  *  from  online_quiz.question\r\n" +
					"where grade = 1 limit 4)\r\n" +
					"order by rand()";
			return sql;
		}
}
