package com.xderhuo.web.user;


import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Cart;
import com.xderhuo.domain.Product;
import com.xderhuo.service.ProductService;
import com.xderhuo.service.impl.ProductServiceImpl;
import com.xderhuo.vo.CartVo;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 添加商品到购物车
	 * @return
	 */
	public String addToCart(){
		//1 获得数据
		// 1.1 商品id
		// 1.2 购买的数量
		CartVo cartVo = toBean(CartVo.class);
		
		//2 操作
		//2.1 获得商品
		ProductService productService = new ProductServiceImpl();
		Product product = productService.selectByPrimaryKey(cartVo.getPid());
		//2.2 获得购物车
		Cart cart = getCart();
		//2.3 商品添加到购物车操作
		cart.addProduct(product , cartVo.getQuantity());
		
		//3 响应：重定向到cart.jsp
		return "redirect:/jsp/cart.jsp";
	}

	/**
	 * 获得购物车
	 * @return
	 */
	private Cart getCart() {
		//1 从session获得购物车
		Cart cart = (Cart)this.getSession().getAttribute("cart");
		//2 如果没有创建一个
		if(cart == null){
			cart = new Cart();
			this.getSession().setAttribute("cart", cart);
		}
		//3 返回
		return cart;
	}
	/**
	 * 清空购物车
	 * @return
	 */
	public String clearCart(){
		//1.获得购物车
		Cart cart = getCart();
		//2.清空操作
		cart.clear();
		//3.响应：重定向到cart.jsp
		return "redirect:/jsp/cart.jsp";
	}
	/**
	 * 改变数据
	 * @return
	 */
	public String changeQuantity(){
		//1.1 获得数据
		CartVo cartVo = toBean(CartVo.class);
		//1.2.获得购物车
		Cart cart = getCart();
		//2.改变数据
		cart.changeQuantity(cartVo.getPid(),cartVo.getQuantity());
		//3.响应：重定向到cart.jsp
		return "redirect:/jsp/cart.jsp";
	}

}
