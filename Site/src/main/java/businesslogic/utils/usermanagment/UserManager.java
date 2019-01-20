/**
 * 
 */
package businesslogic.utils.usermanagment;

import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import businesslogic.servlets.UserHandler;

/**
 * @author rodolfo
 * This class handle user operations for {@link UserHandler} servlet.
 * It use the strategy design pattern
 */
public class UserManager {

	/**
	 * Strategy to do
	 */
	private UserStrategy strategy;
	
	
	
	/**
	 * Constructor with parameters
	 * @param strategy to do
	 */
	public UserManager(UserStrategy strategy) {
		this.strategy = strategy;
	}



	/**
	 * Handle operation
	 * @throws Exception if there are problems in user operation
	 */
	public void handle() throws Exception {
		strategy.handle();
	}
	
}
