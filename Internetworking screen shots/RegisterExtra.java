
import java.util.*;
import java.io.*; 

public class Register {

	public static void main(String[] args) {


		//Encryption encrypt = new Encryption();
		
		Scanner input = new Scanner(System.in);
		System.out.print("please enter your first name and last name (seperated by a space): ");
		String firstname = input.next();
		String lastname = input.next();

		User user1 = new User(firstname, lastname);
		

		//System.out.print("Username: ");
		//String username = input.next();

		//System.out.print("password (must include a special Character): ");
		//String password = input.next();


		//Login login = new Login(username, password);
		//user1.register(login);
////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////////////		
			
	    try(Scanner scan = new Scanner(new File("text.txt")).useDelimiter(";")){

			ArrayList<String> data = new ArrayList<>() ;
			while(scan.hasNext()){
			    data.add(scan.next());
			    data.toArray();
			    
			}
			
			String userInput = (firstname + lastname + ":");
			for(int i= 0; i < data.size(); i++){
					int j = data.get(i).indexOf(':')+1;
					String firstNLast = data.get(i).substring(0, j);

				if(firstNLast.contains(userInput)){
					System.out.println("User Exists");

					System.out.print("Username: ");
					String username = input.next();

					System.out.print("password: ");
					String password = input.next();

					Login login = new Login(username, password);

	////////////////////////////////////////////////////////////////////////////////////////
					String passInput = (login.getUser() + login.getPass());
						for(int m= 0; m < data.size(); m++){
							int n = data.get(m).indexOf(':')+1;
							String userNpass = data.get(m).substring(n);
								if(userNpass.contains(passInput)){
									System.out.println("Access granted");
									break;
								}else{
									//System.out.println("Access denied");
									continue;
									//System.out.println(userNpass);
									//System.out.println(passInput);
									//System.out.println();

								}
						}
	////////////////////////////////////////////////////////////////////////////////////////				

					break;
				}else if(i == data.size()-1){
					System.out.println("Please register an account: ");
				}
			}
	
		}	
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

////////////////////////////////////////////////////////////////////////////////////////
		//
 /*

		System.out.print("Username: ");
		String username = input.next();

		System.out.print("password (must include a special Character): ");
		String password = input.next();



		Login login = new Login(username, password);
		user1.register(login);

	   
		if(login.specialCharInPassValid(password)){
		
			System.out.print("welcome aboard\n");
			
			String appendUser = login.getUser();
			String appendPass = login.getPass();
			String appendFirstname = user1.getFirstName();
			String appendLastname = user1.getLastName();

			FileDB(appendFirstname, appendLastname, appendUser, appendPass);

		}else{
			System.out.print("access denied\n");
		}

*/




	
	}

	////////////////////////////////////////////////////////////////

	private static void FileDB(String firstname, String lastname, String user, String pass) {
		File file = new File("text.txt");
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(firstname + lastname+ ":" +user + pass + ";");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

} 








