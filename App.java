
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure().addAnnotatedClass(Agent.class);
    	SessionFactory sf = con.buildSessionFactory();
    	
    	CreateAgent(sf,"Amit Bind","bind9530@gmail.com",965874123);  				//creating Agent
    	CreateAgent(sf,"Saurabh Nishad","Saurabh@gmail.com",456789123);				//creating Agent
    	CreateAgent(sf,"Krishna yadav","Krishna@gmail.com",968574123);				//creating Agent
    	
    	//Get Agents
    	getAgentbyId(sf,1);
    	getAgentbyId(sf,2);
    	getAgentbyId(sf,3);
    	
    	//updating Agent
    	updateAgentbyId(sf,2,"Saurabh","saurabh@hotmail.com",124356789);
    	System.out.println("After Updating Agent");
    	getAgentbyId(sf,2);
    	
    	//Delete Agent
    	deleteAgentbyId(sf,2);
    	
    }
    public static void CreateAgent(SessionFactory sf,String name,String Email,long phno)
	{
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=new Agent();
    	a1.setName(name);
    	a1.setEmail(Email);
    	a1.setPhone_number(phno);
    	ss.save(a1);
    	t1.commit();
	}
    public static void getAgentbyId(SessionFactory sf,int id) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	System.out.print(a1.getAgent_id()+" ");
    	System.out.print(a1.getName()+" ");
    	System.out.print(a1.getEmail()+" ");
    	System.out.print(a1.getPhone_number()+" ");	
    	System.out.println();
    }
    public static void deleteAgentbyId(SessionFactory sf,int id) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	ss.delete(a1);
    	t1.commit();
}
    public static void updateAgentbyId(SessionFactory sf,int id,String name,String Email,long phno) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	a1.setName(name);
    	a1.setEmail(Email);
    	a1.setPhone_number(phno);
    	ss.save(a1);
    	t1.commit();
    }
    
}
