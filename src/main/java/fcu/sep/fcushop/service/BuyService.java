package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Buy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class BuyService {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public BuyService() {

  }

  public List<Buy> getBuy() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRIPTION description"
          + " from Team04.buy";

      return connection.createQuery(query).executeAndFetch(Buy.class);
    }
  }

  public void pushBuy(int buyID) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "insert into Team04.buy (NAME, IMAGE_URL, PRICE, DESCRIPTION)"
          + "SELECT NAME, IMAGE_URL, PRICE, DESCRIPTION FROM Team04.product WHERE ID = :buyID";
      connection.createQuery(query)
          .addParameter("buyID", buyID)
          .executeUpdate();
    }
  }

  public List<Buy> getBuy(String keyword) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRIPTION description"
          + " from Team04.buy where name like :keyword";

      return connection.createQuery(query)
          .addParameter("keyword", "%"+keyword+"%")
          .executeAndFetch(Buy.class);
    }
  }

}
