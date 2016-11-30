package exceptions;

public class AccountDbFailure extends Exception {
	private static final long serialVersionUID = 1L;
	public static final int STMT_FAILED = 0;
	public static final int BAD_ACCT_ID = 1;
	public static final int RETRY = 2;
	public static final int RETRY_LIMIT_EXCEEDED = 3;
	
	private int failureReason;
	
	public AccountDbFailure(int failureReason) {
		this.failureReason = failureReason;
	}
	
	public AccountDbFailure(int failureReason, String msg) {
		super(msg);
		this.failureReason = failureReason;
	}
	
	public int getFailureReason() {
		return failureReason;
	}
	
	public String getReasonStr() {
		switch (failureReason) {
		case STMT_FAILED:
			return "Failure Executing Statement";
		case BAD_ACCT_ID:
			return "Bad Account Id";
		case RETRY:
			return "Operation rolled back, retry";
		case RETRY_LIMIT_EXCEEDED:
			return "Multiple attempts to perform the statement failed";
		default:
			return "Unknown Reason";
		}
	}

}
