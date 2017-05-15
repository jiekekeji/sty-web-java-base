package com.store.mapper;

import com.store.model.Order;
import com.store.model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    int countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    @Delete({
        "delete from order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    @Insert({
        "insert into order (id, orderid, ",
        "name, price, userid)",
        "values (#{id,jdbcType=BIGINT}, #{orderid,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{price,jdbcType=BIGINT}, #{userid,jdbcType=VARCHAR})"
    })
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    @Select({
        "select",
        "id, orderid, name, price, userid",
        "from order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    Order selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbggenerated Mon May 15 17:14:38 CST 2017
     */
    @Update({
        "update order",
        "set orderid = #{orderid,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=BIGINT},",
          "userid = #{userid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Order record);
}