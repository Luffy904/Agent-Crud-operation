import javax.persistence.*;

@Entity

public class Agent {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int Agent_id;
		private String  name;
		private String email;
		private long Phone_number;
	
		public int getAgent_id() {
			return Agent_id;
		}
		public void setAgent_id(int agent_id) {
			Agent_id = agent_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone_number() {
			return Phone_number;
		}
		public void setPhone_number(long phno) {
			Phone_number = phno;
		}
		
	}

