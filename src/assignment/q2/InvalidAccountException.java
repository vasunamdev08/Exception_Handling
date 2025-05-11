package assignment.q2;

class InvalidAccountException extends BankingException {
    public InvalidAccountException(String message) {
        super(message);
    }
}