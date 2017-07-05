package com.shengdiyage.dao.implement;

import com.shengdiyage.dao.ProductTypeDao;
import com.shengdiyage.model.Product;
import com.shengdiyage.model.ProductType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akari on 2017/6/28.
 */
public class ProductTypeDaoImplement extends BaseDao implements ProductTypeDao {

    @Override
    public int addProductTypeByType(ProductType productType) {
        int result = 0;
        String sql = "INSERT INTO producttype(typename) VALUES (?)";
        Object[] objects = {productType.getTypename()};
        result = super.executeUpdate(sql,objects);
        return result;
    }

    @Override
    public int deleteProductTypeByTypeId(int typeid) {
        int result = 0;
        String sql = "DELETE FROM producttype WHERE typeid = ?";
        Object[] objects = {typeid};
        result = super.executeUpdate(sql,objects);
        return result;
    }

    @Override
    public int updateProductTypeByTypeId(ProductType productType) {
        int result = 0;
        String sql = "UPDATE producttype set typename = ? WHERE typeid = ?";
        Object[] objects = {productType.getTypename(), productType.getTypeid()};
        result = super.executeUpdate(sql,objects);
        return result;
    }

    @Override
    public List<Product> queryProductByTypeId(int typeid) {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM producttype INNER JOIN product ON producttype.typeid = product.ptype WHERE ptype = ?";
        Object[] objects = {typeid};
        ResultSet rs = super.executeQuery(sql, objects);
        try {
            while (rs.next()) {
                products.add(new Product(rs.getInt("pid"), rs.getString("pname"), rs.getInt("pprice"), rs.getInt("pnumber"), rs.getInt("ptype")));
            }
            super.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductType queryProductTypeByTypeId(int typeid) {
        ProductType productType = new ProductType();
        String sql = "SELECT * FROM producttype WHERE typeid = ?";
        Object[] objects = {typeid};
        ResultSet rs = super.executeQuery(sql, objects);
        try {
            if(rs.next()) {
                productType.setTypeid(rs.getInt("typeid"));
                productType.setTypename(rs.getString("typename"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.closeAll();
        }
        return productType;
    }

    @Override
    public List<ProductType> queryAllProductType() {
        List<ProductType> productTypes = new ArrayList<>();
        String sql = "SELECT * FROM producttype";
        Object[] objects = {};
        ResultSet rs = super.executeQuery(sql, objects);
        try {
            while (rs.next()) {
                productTypes.add(new ProductType(rs.getInt("typeid"), rs.getString("typename")));
            }
            super.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productTypes;
    }

//    @Override
//    public boolean queryProductTypeByTypeName(String typename) {
//        String sql = "SELECT typename FROM producttype WHERE typename = ?";
//        Object[] objects = {typename};
//        try {
//            if("".equals(super.executeQuery(sql,objects).getString("typename"))) {
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    @Override
    public ProductType queryProductTypeByTypeName(String typename) {
        ProductType productType = new ProductType();
        String sql = "SELECT * FROM producttype WHERE typename = ?";
        Object[] objects = {typename};
        ResultSet rs = super.executeQuery(sql, objects);
        try {
            if(rs.next()) {
                productType.setTypeid(rs.getInt("typeid"));
                productType.setTypename(rs.getString("typename"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.closeAll();
        }
        return productType;
    }

//    @Override
//    public List<Product> queryProductByTypeId(int start, int conut) {
//        return null;
//    }
}
