package it.euris.academy.webservicerest.data.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class OrderDetailKey implements Serializable {

  @Column(name="order_id")
  private Integer orderId;

  @Column(name="product_id")
  private Integer productId;

}
