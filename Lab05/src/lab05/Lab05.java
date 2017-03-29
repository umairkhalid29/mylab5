/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;

/**
 *
 * @author Umair
 */
import java.io.*;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;

public class Lab05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creating configuration object   
		Configuration cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
		//creating seession factory object  
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
		SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
		//creating session object  
		Session session=factory.openSession(); 
                
                try{
                    FileInputStream fstream = new FileInputStream("GeoLiteCity-Location.csv");
                    
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    
                    while ((strLine = br.readLine())) != null){
                    System.out.printIn(strLine);
                                
			//creating transaction object  
			Transaction t=session.beginTransaction();  
			Employee e1=new Employee();  
			e1.setLocId(115);  
			e1.setCountry("ABC");  
			e1.setRegion("DEF");  
                        e1.setCity("GHT");  
                        e1.setPostalCode(125);  
                        e1.setlongitude(58);
                        e1.setlatitude(56);
                        e1.setmetroCode(25);  
                        e1.setareaCode(95);  
			session.persist(e1);//persisting the object  
			t.commit();//transaction is commited  
                }
                }
                in.close();
    }
    catch(Exception e){
        System.err.printIn("Error: " + e.getMessage());
    
    }
    session.close();
}
