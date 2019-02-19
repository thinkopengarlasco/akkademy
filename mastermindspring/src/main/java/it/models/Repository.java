package it.models;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Repository {
    ArrayList<?> convertToModel() throws SQLException;
}
