package bsys.service.Validator;

import bsys.model.Client;
import bsys.model.Order;
import bsys.model.Tariff;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class FieldsValidator {
    private ClientService clientService;
    private OrderService orderService;

    @Autowired
    private void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


    public Map<String, String> clientAddValidate(Client client) {
        Map<String, String> errorMap = new HashMap<>();
        if (client.getIdClient() == 0 && client.getPassword().length() > 16) {
            errorMap.put("password", "Password must be between 8 and 16 characters!");
        }
        Client clientByEmail = clientService.getByEmail(client.getEmail());
        if (client.getIdClient() == 0) {
            if (clientByEmail != null) {
                errorMap.put("emailRepeat", "This account already exists!");
            }
        }
        else {
            Client curClient = clientService.getById(client.getIdClient());
            if (!curClient.getEmail().equals(client.getEmail())) {
                if (clientByEmail != null) {
                    errorMap.put("emailRepeat", "This email is occupied!");
                }
            }
        }
        return errorMap;
    }

    public Map<String, String> clientEditValidate(Client client) {
        Map<String, String> errorMap = new HashMap<>();
        Client curClient = clientService.getAuthClient();
        if (!client.getEmail().equals(curClient.getEmail())) {
            Client clientByEmail = clientService.getByEmail(client.getEmail());
            if (clientByEmail != null) {
                errorMap.put("email", "Account with such email already exists!");
            }
        }
        return errorMap;
    }

    public void verifyClient(int idOrder) throws SecurityException {
        Client curClient = clientService.getAuthClient();
        if (curClient.getRole().equals("USER") && curClient.getIdClient() != orderService.getById(idOrder).getClient().getIdClient()) {
            throw new SecurityException("Access denied");
        }
    }

    public Map<String, String> orderValidate(Order order) {
        Map<String, String> errorMap = new HashMap<>();
            if (order.getDiscount().compareTo(new BigDecimal(0)) < 0 || order.getDiscount().compareTo(new BigDecimal(100)) > 0) {
                errorMap.put("discount", "Discount must be between 0 and 100!");
            }
        return errorMap;
    }

    public Map<String, String> tariffValidate(Tariff tariff) {
        Map<String, String> errorMap = new HashMap<>();
        if (tariff.getPriceTariff().compareTo(new BigDecimal(0)) < 0) {
            errorMap.put("priceTariff", "Price must be positive!");
        }
        return errorMap;
    }

    public Map<String, String> getErrorMap(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                FieldError::getField,
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }
}
