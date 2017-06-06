package Data.insertintoDatabase;
import java.sql.SQLException;
public class DatainserMain {

	

	

		public static void main(String[] args) {
			InsertData_Table data = new InsertData_Table();
			try {
				data.loadData(20);
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
}
