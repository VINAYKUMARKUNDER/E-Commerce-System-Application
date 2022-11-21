package com.shopping.Service;

import java.time.LocalDate;
import java.util.List;

import com.shopping.Exception.CustomerException;
import com.shopping.Exception.PaymentHistoryException;
import com.shopping.model.PaymentHistory;

public interface PaymentHistoryService {
	
	public PaymentHistory addPaymentHistory(PaymentHistory paymentHistory) throws PaymentHistoryException;
	public List<PaymentHistory> viewPaymentHistoryByDate(String key,LocalDate from, LocalDate to) throws PaymentHistoryException,CustomerException;
	public List<PaymentHistory> findByPaymentHistoryType(String key,String transactionType) throws PaymentHistoryException,CustomerException;
//	
	public PaymentHistory findByPaymentHistoryId(String key,Integer id)throws PaymentHistoryException, CustomerException;
	public List<PaymentHistory> viewAllPaymentHistory(String key)throws PaymentHistoryException,CustomerException;
	public List<PaymentHistory> findByDate(String key,LocalDate date)throws PaymentHistoryException,CustomerException ;
	

}
