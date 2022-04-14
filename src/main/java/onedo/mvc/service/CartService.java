package onedo.mvc.service;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.GoodsDTO;

public interface CartService {
	void insert(CartDTO cart, GoodsDTO goods, int amount);
	
	
}


