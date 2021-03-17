package db;

import java.sql.SQLException;
import model.Supplier;

public interface DBSupplierIF {
	Supplier insert(Supplier supplier) throws SQLException;
}