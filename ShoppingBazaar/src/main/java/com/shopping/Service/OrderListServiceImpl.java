package com.shopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Exception.CartException;
import com.shopping.Exception.OrderListException;
import com.shopping.Exception.ProductException;
import com.shopping.Repository.OrderListRepository;
import com.shopping.model.OrderList;
import com.shopping.model.Product;

@Service
public class OrderListServiceImpl implements OrderListService{

		@Autowired
		private OrderListRepository orderListRepository;
		
		@Autowired
		private CartService cartService;
		
		

		@Override
		public List<Product> addCartToOrderList(List<Product> products)throws ProductException, CartException, OrderListException {
			if(products.size()==0)throw new CartException("No any new value added");
		
			for(Product pro:products) {
				if(pro==null)throw new ProductException("Product is null");
				OrderList ol =new OrderList();
				
				ol.setProduct(pro);
				orderListRepository.save(ol);
//				if(orderListRepository.save(ol) != null)throw new OrderListException("Some Error in OrderList");
			}
			System.out.println(products);
//			
			return products;
			
			
			
			
		}

		
}
