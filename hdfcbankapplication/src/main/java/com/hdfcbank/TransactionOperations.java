package com.hdfcbank;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TransactionOperations {

	Date setDate;
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	Scanner sc = new Scanner(System.in);

	void multipleOperationOptionsAfterSigninin(String signInEmail) {
		do {
			System.out.println("Doing some operations on the bank application");
			System.out.println("Enter 1 to deposit the money into self-account ");
			System.out.println("Enter 2 to check balance");
			System.out.println("Enter 3 to deposit the money into another account");
			System.out.println("Enter 4 to display the details of all transactions");
			System.out.println("Enter 5 to display the details of recent transaction");
			System.out.println("Enter your choice");
			Integer choiceOfOperation = sc.nextInt();
			switch (choiceOfOperation) {
			case 1:
				System.out.println("Depositing the money based on account number");
				System.out.println("Enter the amount to be deposited");
				Double depositingAmount = sc.nextDouble();
				System.out.println("enter the account number");
				Integer accountNumber = sc.nextInt();
				System.out.println("Enter the date of transaction in the format YYYY-MM-DD");
				Date date = setDate.valueOf(sc.next());
				Double transactionAmount = depositingAmount;
				System.out.println("Transaction category");
				String transactionCategory = sc.next();
				Integer transactionUserId = 0;
				System.out.println("transaction party");
				Integer transactionParty = sc.nextInt();
				this.depositingMoneyToSelf(depositingAmount, accountNumber, new TransactionDetails(date,
						transactionAmount, transactionCategory, transactionUserId, transactionParty));
				break;
			case 2:
				System.out.println("Displaying the balance by account number");
				System.out.println("Enter Account Number");
				Integer displayingAmountByAccountNumber = sc.nextInt();
				System.out.println("AccountBalance : "
						+ this.displayingBalanceByAccountNumber(displayingAmountByAccountNumber, signInEmail));
				break;

			case 3:
				System.out.println("Transfering the money into another account");
				System.out.println("Enter the amount to be transferred");
				Double transferringAmount = sc.nextDouble();
				System.out.println("Enter the date of transaction");
				Date transferringDate = setDate.valueOf(sc.next());
				System.out.println("Transaction Category");
				String transferringCategory = sc.next();
				Integer transferringUserId = 0;
				System.out.println("Transaction Party");
				Integer transferringParty = sc.nextInt();
				this.transferringAmountIntoOtherAccount(signInEmail, new TransactionDetails(transferringDate,
						transferringAmount, transferringCategory, transferringUserId, transferringParty));

				break;

			case 4:
				System.out.println("Displaying list of transactions");
				List<TransactionDetails> transactions=this.listOfAllTransactions();
				transactions.forEach(System.out::println);
				break;

			case 5: System.out.println("Dislaying the last transaction");
			System.out.println(this.retrievingTheLastTransaction());
			}
			System.out.println("enter y to run the operations");
		} while (sc.next().equalsIgnoreCase("y"));
	}

	int depositingMoneyToSelf(Double depositingAmount, Integer accountNumber, TransactionDetails transactionDetails) {

		String qry1 = "select userBalanceId from balance where userAccountNumber=:accountNumber";
		MapSqlParameterSource source = new MapSqlParameterSource().addValue("accountNumber", accountNumber);
		Integer userId = namedParameterJdbcTemplate.queryForObject(qry1, source, Integer.class);

		String qry2 = "select currentBalance from balance where userAccountNumber=:accountNumber";
		MapSqlParameterSource source1 = new MapSqlParameterSource().addValue("accountNumber", accountNumber);
		Double currentBalance = namedParameterJdbcTemplate.queryForObject(qry2, source1, Double.class);
		System.out.println("currentBalance" + currentBalance);
		Double updatedBalance = currentBalance + depositingAmount;
		System.out.println("Updated Balance" + updatedBalance);
		String qry3 = "update balance set currentBalance=:updatedBalance where userAccountNumber=:accountNumber";
		MapSqlParameterSource source2 = new MapSqlParameterSource().addValue("updatedBalance", updatedBalance)
				.addValue("accountNumber", accountNumber);
		namedParameterJdbcTemplate.update(qry3, source2);
		// transaction history
		String qry4 = "insert into transactionhistory (transactionDate,transactionAmount,transactionCategory,userId,transactionParty) values (:date,:amount,:category,:id,:otherParty)";
		MapSqlParameterSource source4 = new MapSqlParameterSource()
				.addValue("date", transactionDetails.getTransactionDate())
				.addValue("amount", transactionDetails.getTransactionAmount())
				.addValue("category", transactionDetails.getTransactionCategory()).addValue("id", userId)
				.addValue("otherParty", transactionDetails.getTransactionparty());
		return namedParameterJdbcTemplate.update(qry4, source4);

	}

	Double displayingBalanceByAccountNumber(Integer accountNumber, String signInEmail) {
		String qry1 = "select userId from userdetails where userEmail=:signInEmail";
		MapSqlParameterSource source1 = new MapSqlParameterSource().addValue("signInEmail", signInEmail);
		Integer userIdFromUserDetails = namedParameterJdbcTemplate.queryForObject(qry1, source1, Integer.class);

		String qry2 = "select userBalanceId from balance where userAccountNumber=:accountNumber";
		MapSqlParameterSource source2 = new MapSqlParameterSource().addValue("accountNumber", accountNumber);
		Integer userIdFromBalance = namedParameterJdbcTemplate.queryForObject(qry2, source2, Integer.class);

		if (userIdFromBalance.equals(userIdFromUserDetails)) {
			String qry = "select currentBalance from balance where userAccountNumber=:accountNumber";
			MapSqlParameterSource source = new MapSqlParameterSource().addValue("accountNumber", accountNumber);
			return namedParameterJdbcTemplate.queryForObject(qry, source, Double.class);
		} else {
			System.out.println("You don't have the access to the particular account you will see nill");
			return 0.0;
		}
	}

	void transferringAmountIntoOtherAccount(String siginginEmail, TransactionDetails transactiondetails) {
		
		String qry="select userId from userdetails where userEmail=:siginginEmail";
		MapSqlParameterSource source=new MapSqlParameterSource()
				.addValue("siginginEmail", siginginEmail);
		Integer TransferringUserId=namedParameterJdbcTemplate.queryForObject(qry, source, Integer.class);
		
		// Deducting the amount from transferring ID:
		
		String qry1="select currentBalance from balance where userBalanceId=:TransferringUserId";
		MapSqlParameterSource source1=new MapSqlParameterSource()
				.addValue("TransferringUserId", TransferringUserId);
		Double currentBalance=namedParameterJdbcTemplate.queryForObject(qry1, source1, Double.class);
		System.out.println("Current Balance Before Deduction"+currentBalance);
		Double updatedBalance;
		if(transactiondetails.getTransactionAmount()>currentBalance)
		{
			System.out.println("Insufficient Balance");
		}
		else {
			updatedBalance=currentBalance-transactiondetails.getTransactionAmount();
			System.out.println("CurrentBalance After Deduction"+updatedBalance);
			String qry2="update balance set currentBalance=:updatedBalance where userBalanceId=:TransferringUserId";
			MapSqlParameterSource source2=new MapSqlParameterSource()
					.addValue("updatedBalance", updatedBalance)
			.addValue("TransferringUserId",TransferringUserId);
			namedParameterJdbcTemplate.update(qry2, source2);
			
		}
		
		
		
		
		// Adding the amount to transferring ID;
		
		String qry3="select currentBalance from balance where userBalanceId=:transferringToPartyId";
				MapSqlParameterSource source3=new MapSqlParameterSource()
				.addValue("transferringToPartyId", transactiondetails.getTransactionparty());
				Double currentBalanceInAnotherParty=namedParameterJdbcTemplate.queryForObject(qry3, source3, Double.class);
				System.out.println("Current Balance Before Credting into the account : "+currentBalanceInAnotherParty);
				
				Double updatedBalanceInAnotherParty=currentBalanceInAnotherParty+transactiondetails.getTransactionAmount();
				System.out.println("Updated Balance after credting: "+updatedBalanceInAnotherParty);
				
				String qry4="update balance set currentBalance=:updatedBalanceInAnotherParty where userBalanceId=:transferringToPartyId";
				
				MapSqlParameterSource source4=new MapSqlParameterSource()
						.addValue("updatedBalanceInAnotherParty",updatedBalanceInAnotherParty)
						.addValue("transferringToPartyId", transactiondetails.getTransactionparty());
				namedParameterJdbcTemplate.update(qry4, source4);
		
		
		
		// Adding the debit transaction into the transactionhistory table
				
				String qry5="insert into transactionhistory (transactionDate,transactionAmount,transactionCategory,userId,transactionParty) values (:transferringDate,:transferringAmount,:transferringCategory,:TransferringUserId,:transferringToPartyId)";

				MapSqlParameterSource source5=new MapSqlParameterSource()
						.addValue("transferringDate", transactiondetails.getTransactionDate())
						.addValue("transferringAmount", transactiondetails.getTransactionAmount())
						.addValue("transferringCategory", transactiondetails.getTransactionCategory())
						.addValue("TransferringUserId", TransferringUserId)
						.addValue("transferringToPartyId", transactiondetails.getTransactionparty());
				namedParameterJdbcTemplate.update(qry5, source5);
						
	}
	
	//Displaying the all transactions
	List<TransactionDetails> listOfAllTransactions(){
		 String qry="select * from transactionhistory ";
		return namedParameterJdbcTemplate.query(qry,
				(ResultSet rs,int numRows)->
		
				new TransactionDetails(
					rs.getDate("transactionDate"),
					rs.getDouble("transactionAmount"),
					rs.getString("transactionCategory"),
					rs.getInt("userId"),
					rs.getInt("transactionParty"))
	
				
				);
	 }
	
	//Displaying the last-transaction
	TransactionDetails retrievingTheLastTransaction() {
		String qry="select * from transactionhistory ";
		List<TransactionDetails> listOfTransactions= namedParameterJdbcTemplate.query(qry,
				(ResultSet rs,int numRows)->
		
				new TransactionDetails(
					rs.getDate("transactionDate"),
					rs.getDouble("transactionAmount"),
					rs.getString("transactionCategory"),
					rs.getInt("userId"),
					rs.getInt("transactionParty"))
	
				
				);
		return listOfTransactions.get(listOfTransactions.size() - 1);
	}

}
