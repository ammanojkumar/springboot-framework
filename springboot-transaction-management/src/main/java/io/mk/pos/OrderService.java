package io.mk.pos;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mk.pos.dto.OrderAcknowledgement;
import io.mk.pos.dto.OrderRequest;
import io.mk.pos.entity.Customer;
import io.mk.pos.entity.PaymentInfo;
import io.mk.pos.entity.Product;
import io.mk.pos.entity.TransactionInfo;
import io.mk.pos.repository.CustomerRepository;
import io.mk.pos.repository.PaymentInfoRepository;
import io.mk.pos.repository.ProductRepository;
import io.mk.pos.repository.TransactionRepository;
import io.mk.pos.util.PaymentUtil;
import io.mk.pos.util.ProductUtil;

@Service
public class OrderService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private PaymentInfoRepository paymentRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private TransactionRepository transactionRepo;

	@Transactional
	public OrderAcknowledgement orderProduct(OrderRequest orderRequest) {
		Customer customerInfo = customerRepo.findById(orderRequest.getCustomerId()).get();
		Product productInfo = productRepo.findById(orderRequest.getProductId()).get();

		PaymentInfo paymentInfo = orderRequest.getPaymentInfo();
		paymentInfo.setBillAmount(productInfo.getPrice().multiply(new BigDecimal(orderRequest.getQuantity())));
		paymentInfo.setPaymentDate(new Date());
		PaymentInfo paymentInfoSaved = paymentRepo.save(paymentInfo);

		PaymentUtil.validateBalance(paymentInfo.getAccountNum(), paymentInfo.getBillAmount());
		ProductUtil.validateAvailablity(productInfo.getProductd(), orderRequest.getQuantity());

		TransactionInfo transactionInfo = new TransactionInfo();
		transactionInfo.setCustomerId(orderRequest.getCustomerId());
		transactionInfo.setProductId(orderRequest.getProductId());
		transactionInfo.setPaymentId(paymentInfoSaved.getPaymentId());
		transactionInfo.setTransactionDate(new Date());
		transactionRepo.save(transactionInfo);

		OrderAcknowledgement orderAcknowledgement = new OrderAcknowledgement();
		orderAcknowledgement.setTransactionId(transactionInfo.getTransactionId());
		orderAcknowledgement.setStatus("Success");
		orderAcknowledgement.setCustomerId(customerInfo.getCustomerId());
		orderAcknowledgement.setProductInfo(productInfo);
		return orderAcknowledgement;
	}
}
