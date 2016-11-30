package application;

import java.sql.SQLException;

import db.BankDb;
import db.BankingAppDataSource;
import exceptions.AccountDbFailure;

/* Test that multiple DB connections have been created.   Deposit money to the same account --
 * both reads are done before the first commit.   So second deposit (second connection) will overwrite the first.
 */
public class UpdateBankAcc {
	private static int accountId = 2;
	
	public static void main(String args[]) {
		
		/* Comment out one of the two methods below and run.   The call to connectionExperiment() is 
		 * an experiment showing problems that can happen with multiple connections.   The call to
		 * simpleDeposit() shows how normally a client would attempt to make a deposit.
		 */
		try {
			//connectionExperiment();
			simpleDeposit();
		} finally {
			try {
				BankingAppDataSource.shutdownDataSource();
			} catch (SQLException ex) {
				System.out.println("Error shutting down DataSource");
			}
		}
	}
	
	public static void connectionExperiment() {
		try {
			BankDb.depositToAccountTwoConn(accountId, 100.0D); // query and print results
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
	}
	
	public static void simpleDeposit() {
		double initialBal, finalBal;
		
		try {
			initialBal = BankDb.getAcctBalance(accountId);
			System.out.println("The initial bank balance is:  " + initialBal);
			
			BankDb.doDepositToAcctRetry(accountId, 100.0D); // This call deposits $100 to the account
			
			finalBal = BankDb.getAcctBalance(accountId);
			System.out.println("The final bank balance is:  " + finalBal);
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
	}
}
    
	


