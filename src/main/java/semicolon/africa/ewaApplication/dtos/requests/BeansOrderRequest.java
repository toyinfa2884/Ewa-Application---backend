package semicolon.africa.ewaApplication.dtos.requests;

import lombok.Data;

@Data
public class BeansOrderRequest {
    private String receiverName;
    private String deliveryAddress;
    private String receiversPhone;
    private String customerEmail;
}
