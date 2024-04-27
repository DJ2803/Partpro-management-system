package com.unt.se.ppms.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.unt.se.ppms.dto.OnlineSalesDTO;
import com.unt.se.ppms.dto.SalesDTO;
import com.unt.se.ppms.entities.Cart;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.entities.OnlineSales;
import com.unt.se.ppms.entities.Cart.OrderStatus;
import com.unt.se.ppms.entities.PaymentInfo;
import com.unt.se.ppms.repository.CartRepository;
import com.unt.se.ppms.repository.CustomerRepository;
import com.unt.se.ppms.repository.EmployeeRepository;
import com.unt.se.ppms.repository.OnlineSalesRepository;
import com.unt.se.ppms.repository.PaymentInfoRepository;
import com.unt.se.ppms.repository.ProductsRepository;
import com.unt.se.ppms.service.PaymentInfoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentInfoServiceImpl implements PaymentInfoService {
	
	@Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    
    @Value("${paypal.mode}")
    private String mode;
    
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    
    @Autowired 
    private EmployeeRepository  employeeRepository;
    
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private OnlineSalesRepository onlineSalesRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ProductsRepository productsRepository;
    

	@Override
	public Payment createPayment(Double total, String currency, String method, String intent, String description,
			String cancelUrl, String successUrl) throws PayPalRESTException {
		Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.format("%.2f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(Arrays.asList(transaction));

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        APIContext context = new APIContext(clientId, clientSecret, mode);
        return payment.create(context);
	}

	@Override
	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);

        APIContext context = new APIContext(clientId, clientSecret, mode);
        return payment.execute(context, paymentExecute);
	}

	@Override
	public void savePaymentInfo(PaymentInfo paymentInfo) {
		paymentInfoRepository.save(paymentInfo);
		
	}

	@Override
	public Double totalAmountOfProducts(long userId) {
		List<Cart> items = cartRepository.getAllProductsInCart(userId, OrderStatus.NOT_ORDERED);
		Double total = items.stream().mapToDouble(item -> item.getProductQuantity()*item.getProductPrice()).sum();
		return total;
	}

	@Override
	public String addOrUpdatePayment(PaymentInfo paymentInfo) {
		paymentInfoRepository.save(paymentInfo);
		return "Payment added successfully";
	}

	@Override
	public PaymentInfo getByPaymentId(String paymentId) {
		return paymentInfoRepository.findById(paymentId).get();
	}

	@Override
	public PaymentInfo getByOrderId(String orderId) {
		PaymentInfo p=	paymentInfoRepository.getPaymentInfoByOrderId(orderId);
		return p;
	}

	@Override
	public String manageOnlineSales(SalesDTO dto) {
		
		List<Employee> e=	employeeRepository.findAllAssistants();
		 if (e.isEmpty()) {
		        return null;
		    } 
		Random random = new Random();
		Employee emp= e.get(random.nextInt(e.size()));
		 String[] products = dto.getProductIDString().split(",");
		 int customerId= (int)dto.getCustomerID();
		 float totalPrice= (float)dto.getTotalAmount();
		 for(int i=0;i<products.length;i++) {
			 long prodid= Long.parseLong(products[i]);
			 OnlineSales os= new OnlineSales();
			 os.setCustomer(customerRepository.getById(customerId));
			 os.setTotalPrice(totalPrice);
			 os.setEmployer(employeeRepository.getById(emp.getEmployeeId()));
			 os.setProducts(productsRepository.getById(prodid));
			 onlineSalesRepository.save(os);
		 }
		return "Online Sales added successfully";   
	}

	@Override
	public List<OnlineSalesDTO> viewOnlineSales() {
		List<OnlineSales> os=onlineSalesRepository.findAll();
		List<OnlineSalesDTO> li= new ArrayList<OnlineSalesDTO>();
		for(int i=0;i<os.size();i++) {
			OnlineSalesDTO dto= new OnlineSalesDTO();
			OnlineSales s= os.get(i);
			dto.setCustomerName(s.getCustomer().getFullName());
			dto.setEmployeeName(s.getEmployer().getEmployeeName());
			dto.setProductName(s.getProducts().getProductName());
			dto.setSaleID(s.getSaleId());
			dto.setTotalPrice(s.getTotalPrice());
			li.add(dto);
		}
		return li;
	}

}
