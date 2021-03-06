package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class TradeHistory extends BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    Date tradeDate;
    Long productId;
    Integer price;
    String seller;
    String buyer;
    String roomId;
}
