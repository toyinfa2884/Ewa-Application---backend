package semicolon.africa.ewaApplication.dtos.responses;

import lombok.Data;

@Data
public class BeansOrderResponse {

    private Integer trackingId;
    private String deliveryAddress;
    private String receiversPhone;
}
