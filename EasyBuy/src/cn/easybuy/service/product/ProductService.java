package cn.easybuy.service.product;

import java.util.List;

import cn.easybuy.entity.Product;
import cn.easybuy.param.ProductParam;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;

public interface ProductService {
	/**
	 * 根据分类查询商品列表
	 * @param categoryId
	 * @param level
	 * @param pager
	 * @return
	 */
	public List<Product> getProductsByCategory(Integer categoryId, int level, Pager pager,String keyWord);
	/**
	 * 根据分类查询商品数目
	 * @param categoryId
	 * @param level
	 * @return
	 */
	int getProductRowCount(String categoryId,int level,String keyWord);
	/**
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	Product findById(String id);//根据ID查询商品
	/**
	 * 保存商品返回id
	 * @param product
	 * @return
	 */
	Integer saveOrUpdate(Product product);//保存一款商品
	/**
	 * 查询商品数目
	 * @param params
	 * @return
	 */
	 public int getProductRowCount(ProductParam params);
	/**
	 * 查询商品列表
	 * @param params
	 * @return
	 */
	List<Product> queryProductsList(ProductParam params);
	/**
	 * 根据id删除商品
	 * @param id
	 */
	public void deleteById(Integer id);
	/**
	 * 根据分类id查询数目
	 * @param categoryId
	 * @return
	 */
	public int getProductCountBycategory(Integer categoryId);
}
