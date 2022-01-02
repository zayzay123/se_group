package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public  void pushBuyIdIntoUser(int buyId) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "insert into USER (BUY_ID)"
                + "values (:buyId)";
            connection.createQuery(query)
                .addParameter("buyId", buyId)
                .executeUpdate();
        }
    }

    public void pushUser(String userName, String account, String password, String email, String phoneNumber) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "insert into USER (NAME, ACCOUNT, PASSWORD, EMAIL, PHONE_NUMBER)"
                + "values (:userName, :account, :password, :email, :phoneNumber)";
            connection.createQuery(query)
                .addParameter("userName", userName)
                .addParameter("account", account)
                .addParameter("password", password)
                .addParameter("email", email)
                .addParameter("phoneNumber", phoneNumber)
                .executeUpdate();
        }
    }

    public List<User> getUser(String account) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "select ID id, NAME name, ACCOUNT account, PASSWORD password, EMAIL email, PHONE_NUMBER phoneNumber, BUY_ID buyId"
                + " from USER where ACCOUNT like :account";

            return connection.createQuery(query)
                .addParameter("account", account)
                .executeAndFetch(User.class);
        }
    }
}
