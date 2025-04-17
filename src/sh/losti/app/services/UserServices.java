package sh.losti.app.services;

import sh.losti.app.builders.ProfileBuilder;
import sh.losti.app.db.Client;
import sh.losti.app.interfaces.services.IUserServices;
import sh.losti.app.models.Profile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserServices implements IUserServices {
    private static final Logger logger = Logger.getLogger(UserServices.class.getName());
    private static UserServices instance;
    private static final String GET_PROFILE_DATA = "SELECT * FROM profiles WHERE user_id = ? LIMIT 1";

    private UserServices() {}

    public static synchronized UserServices getInstance() {
        if (instance == null) {
            instance = new UserServices();
        }
        return instance;
    }

    @Override
    public Profile getProfileData(int id) throws SQLException {
        try (PreparedStatement ps = Client.getPreparedStatement(GET_PROFILE_DATA)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) throw new SQLException();

            return new ProfileBuilder()
                    .setId(rs.getInt(1))
                    .setUserId(rs.getInt(2))
                    .setBiography(rs.getString(3))
                    .setNetworks(rs.getString(4))
                    .setBooks(rs.getString(5))
                    .setCreatedAt(rs.getTimestamp(6))
                    .setUpdatedAt(rs.getTimestamp(7))
                    .build();
        } catch (SQLException e) {
            e.fillInStackTrace();
            return null;
        }
    }
}
