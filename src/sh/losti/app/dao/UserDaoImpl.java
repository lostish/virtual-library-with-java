package sh.losti.app.dao;

import sh.losti.app.builders.ProfileBuilder;
import sh.losti.app.db.Client;
import sh.losti.app.interfaces.dao.IDaoUser;
import sh.losti.app.models.Profile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IDaoUser {
    private static UserDaoImpl instance;
    private static final String GET_PROFILE_DATA = "SELECT * FROM profiles WHERE user_id = ? LIMIT 1";

    private UserDaoImpl() {}

    public static synchronized UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public Profile getProfile(int id) {
        try (PreparedStatement ps = Client.getPreparedStatement(GET_PROFILE_DATA)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) throw new SQLException("No profile found.");

            return new ProfileBuilder()
                    .setId(rs.getInt(1))
                    .setUserId(rs.getInt(2))
                    .setLWNameId(rs.getString(3))
                    .setLENameId(rs.getString(4))
                    .setBiography(rs.getString(5))
                    .setCreatedAt(rs.getTimestamp(6))
                    .setUpdatedAt(rs.getTimestamp(7))
                    .build();
        } catch (SQLException e) {
            e.fillInStackTrace();
            return null;
        }
    }
}
