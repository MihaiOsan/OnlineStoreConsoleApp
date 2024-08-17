package entities.impl;

import java.util.Arrays;

import entities.Cart;
import entities.Product;

public class DefaultCart implements Cart {

	private Product[] products;
	private static final int DEFAULT_CART_CAPACITY = 10;
	private int lastIndex;

	{
		products = new Product[DEFAULT_CART_CAPACITY];
	}

	@Override
	public boolean isEmpty() {
		if (products == null || products.length == 0)
			return true;
		for (Product p : products)
			if (p != null)
				return false;

		return true;
	}

	@Override
	public void addProduct(Product product) {
		if (product == null)
			return;
		if (lastIndex >= products.length)
			Arrays.copyOf(products, products.length << 1);
		products[lastIndex++] = product;
	}

	@Override
	public Product[] getProducts() {
		int notNullProducts = 0;
		for (Product p : products)
			if (p != null)
				notNullProducts++;

		int i = 0;
		Product[] realProducts = new Product[notNullProducts];

		for (Product p : products)
			if (p != null)
				realProducts[i++] = p;

		return realProducts;
	}

	@Override
	public void clear() {
		// <write your code here>
	}

}
