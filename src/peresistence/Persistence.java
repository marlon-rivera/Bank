package peresistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import models.Account;

public class Persistence {
	
	public static void saveAccounts(ArrayList<Account> accounts) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String object = "";
		try(PrintWriter writer = new PrintWriter("data/accounts.json");) {
				object = gson.toJson(accounts);
				writer.write(object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Account> readAccounts(){
		ArrayList<Account> accounts = new ArrayList<>();
		Account[] list = null; 
		JsonReader reader;
		try {
			reader = new Gson().newJsonReader(new FileReader("data/accounts.json"));
			list = new Gson().fromJson(reader, Account[].class);
			for (Account account : list) {
				accounts.add(account);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}
}