package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public String getUserPassword(String account) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "select PASSWORD"
                + " from USER where ACCOUNT like :account";
            return connection.createQuery(query)
                    .addParameter("account", account)
                    .toString();
        }
    }
}
