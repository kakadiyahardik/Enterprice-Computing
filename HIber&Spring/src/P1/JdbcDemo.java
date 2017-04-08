package P1;

import Model.Emp;

public class JdbcDemo 
{
	
	public static void main(String[] arg)
	{
		Emp e=new JdbcDaoImpl().getEmp(3);
		/*ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		
		Emp e=(Emp) ctx.getBean("emp");*/
		/*JdbcDaoImpl da=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		Emp e=da.getEmp(3);*/
		System.out.println(e.getEmp_name());
	}
}