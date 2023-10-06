package it.euris.academy.webservicerest.repository.projection;

public interface ProductCountProjection {

  Long getCountAll();

  Integer getCountOk();

  Integer getCountDeleted();

}
