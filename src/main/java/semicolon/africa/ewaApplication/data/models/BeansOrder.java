package semicolon.africa.ewaApplication.data.models;

import lombok.Data;

@Data
public class BeansOrder {
        private Integer id;
        private String receiverName;
        private String deliveryAddress;
        private String receiversPhone;
        private String customerEmail;
}
